package cn.jbone.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpecificationUtils<T> {
    public static final String EQUAL = "EQ";
    public static final String NOT_EQUAL = "NEQ";
    public static final String LESS_THAN = "LT";
    public static final String LESS_THAN_OR_EQUAL = "LTOE";
    public static final String GREATER_THAN = "GT";
    public static final String GREATER_THAN_OR_EQUAL = "GTOE";
    public static final String LIKE = "LIKE";
    public static final String SEARCH_PREFIX = "S_";

    public static <T> List<Predicate> generatePredicates(Root<T> root, CriteriaBuilder criteriaBuilder, Map<String,Object> condition){
        if(CollectionUtils.isEmpty(condition)){
            return null;
        }

        List<Predicate> predicates = new ArrayList<Predicate>();
        Set<String> set = condition.keySet();
        for (String key : set){
            if(!key.startsWith(SEARCH_PREFIX)){
                continue;
            }
            String[] fp = key.split("_");
            if(fp.length < 3){
                continue;
            }
            String filedName = fp[1];
            String pattern = fp[2];

            if(StringUtils.isBlank(filedName) || StringUtils.isBlank(filedName)){
                continue;
            }
            //空值不作为查询条件
            if(condition.get(key) == null || StringUtils.isBlank(condition.get(key).toString())){
                continue;
            }
            //基本数字类型且小于0，不作为查询条件
            if(root.get(filedName).getJavaType().isPrimitive() && (Long.parseLong(condition.get(key).toString())) < 0){
                continue;
            }

            //如果是日期类型，需要做下转换
            boolean isDate = false;
            if (!root.get(filedName).getJavaType().isPrimitive()){
                String typeName = root.get(filedName).getJavaType().getName();
                if(typeName.equalsIgnoreCase("java.sql.Timestamp") || typeName.equalsIgnoreCase("java.util.Date")){
                    isDate = true;
                }
            }

            Path<Comparable> expression = root.get(filedName);
            Comparable value = (Comparable)condition.get(key);
            if(isDate){
                value = DateUtil.getDate(value.toString());
            }

            if(EQUAL.equalsIgnoreCase(pattern)){
                predicates.add(criteriaBuilder.equal(expression,value));
            }else if(NOT_EQUAL.equalsIgnoreCase(pattern)){
                predicates.add(criteriaBuilder.notEqual(expression,value));
            }else if(LESS_THAN.equalsIgnoreCase(pattern)){
                predicates.add(criteriaBuilder.lessThan(expression,  value));
            }else if(LESS_THAN_OR_EQUAL.equalsIgnoreCase(pattern)){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(expression,value));
            }else if(GREATER_THAN.equalsIgnoreCase(pattern)){
                predicates.add(criteriaBuilder.greaterThan(expression,value));
            }else if(GREATER_THAN_OR_EQUAL.equalsIgnoreCase(pattern)){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(expression,value));
            }else if(LIKE.equalsIgnoreCase(pattern)){
                Path<String> expressionLike = root.get(filedName);
                Object valueLike = condition.get(key);
                predicates.add(criteriaBuilder.like(expressionLike,"%" + valueLike + "%"));
            }
        }

        return predicates;
    }
}
