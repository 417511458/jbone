package cn.jbone.common.service;


import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.*;

public class AbstractService<T> {
    private final String EQUAL = "EQ";
    private final String NOT_EQUAL = "NEQ";
    private final String LESS_THAN = "LT";
    private final String LESS_THAN_OR_EQUAL = "LTOE";
    private final String GREATER_THAN = "GT";
    private final String GREATER_THAN_OR_EQUAL = "GTOE";
    private final String LIKE = "LIKE";
    private final String SEARCH_PREFIX = "S_";

    /**
     * 获取搜索列表的通用Specification
     * key=S_filedName_pattern
     * @param searchListDTO
     * @return
     */
    public Specification<T> getSearchListSpecification(SearchListDTO searchListDTO){
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                Map<String,Object> condition = searchListDTO.getCondition();
                if(condition == null || condition.isEmpty()){
                    return criteriaQuery.getRestriction();
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
                Predicate predicate = null;
                if(!predicates.isEmpty()){
                    Predicate[] predicatesArr = new Predicate[predicates.size()];
                    predicate = criteriaQuery.where(predicates.toArray(predicatesArr)).getRestriction();
                }else{
                    predicate = criteriaQuery.getRestriction();
                }
                return predicate;
            }
        };
    }

    /**
     * 获取分页请求对象
     * @param searchListDTO
     * @return
     */
    public PageRequest getPageRequest(SearchListDTO searchListDTO){
        PageRequest pageRequest = null;
        if(StringUtils.isNotBlank(searchListDTO.getSortName())){
            pageRequest = new PageRequest(searchListDTO.getPageNumber()-1,searchListDTO.getPageSize(),Sort.Direction.fromString(searchListDTO.getSortOrder()),searchListDTO.getSortName());
        }else {
            pageRequest = new PageRequest(searchListDTO.getPageNumber()-1,searchListDTO.getPageSize());
        }
        return pageRequest;
    }

}
