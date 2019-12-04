package cn.jbone.common.utils;

import cn.jbone.common.dataobject.SearchConditionDO;
import cn.jbone.common.dataobject.SearchSortDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SpecificationUtils<T> {
    /**
     * 构建条件查询
     * @param root p
     * @param criteriaBuilder p
     * @param conditions p
     * @param <T> t
     * @return r
     */
    public static <T> List<Predicate> generatePredicates(Root<T> root, CriteriaBuilder criteriaBuilder, List<SearchConditionDO> conditions){
        if(CollectionUtils.isEmpty(conditions)){
            return null;
        }

        List<Predicate> predicates = new ArrayList<Predicate>();
        for (SearchConditionDO condition : conditions){

            String filedName = condition.getProperty();

            if(StringUtils.isBlank(filedName) || condition.getOperator() == null || condition.getValue() == null){
                continue;
            }
            //基本数字类型且小于0，不作为查询条件
            if(root.get(filedName).getJavaType().isPrimitive() && (Long.parseLong(condition.getValue().toString())) < 0){
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
            Comparable value = (Comparable)condition.getValue();
            if(isDate){
                value = DateUtil.getDate(value.toString());
            }

            if(SearchConditionDO.Operator.EQUAL == condition.getOperator()){
                predicates.add(criteriaBuilder.equal(expression,value));
            }else if(SearchConditionDO.Operator.NOT_EQUAL == condition.getOperator()){
                predicates.add(criteriaBuilder.notEqual(expression,value));
            }else if(SearchConditionDO.Operator.LESS_THAN == condition.getOperator()){
                predicates.add(criteriaBuilder.lessThan(expression,  value));
            }else if(SearchConditionDO.Operator.LESS_THAN_OR_EQUAL == condition.getOperator()){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(expression,value));
            }else if(SearchConditionDO.Operator.GREATER_THAN == condition.getOperator()){
                predicates.add(criteriaBuilder.greaterThan(expression,value));
            }else if(SearchConditionDO.Operator.GREATER_THAN_OR_EQUAL == condition.getOperator()){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(expression,value));
            }else if(SearchConditionDO.Operator.LIKE == condition.getOperator()){
                Path<String> expressionLike = root.get(filedName);
                Object valueLike = condition.getValue();
                predicates.add(criteriaBuilder.like(expressionLike,"%" + valueLike + "%"));
            }
        }

        return predicates;
    }

    /**
     * 构建排序
     * @param sortDOS s
     * @return r
     */
    public static Sort buildSort(List<SearchSortDO> sortDOS){
        Sort sort = null;
        //构建排序
        if(!CollectionUtils.isEmpty(sortDOS)){
            List<Sort.Order> orders = new ArrayList<>();
            for (SearchSortDO sortDO: sortDOS) {
                Sort.Order order = null;
                if(sortDO.getDirection() == SearchSortDO.Direction.ASC){
                    order = Sort.Order.asc(sortDO.getProperty());
                }else{
                    order = Sort.Order.desc(sortDO.getProperty());
                }
                orders.add(order);
            }
            sort = Sort.by(orders);
        }else{
            sort = Sort.unsorted();
        }
        return sort;
    }
}
