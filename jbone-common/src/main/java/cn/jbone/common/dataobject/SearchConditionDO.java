package cn.jbone.common.dataobject;

import lombok.Data;

/**
 * 查询条件封装
 */
@Data
public class SearchConditionDO {

    /**
     * 运算符
     */
    private Operator operator;
    /**
     * 属性名
     */
    private String property;
    /**
     * 校验值
     */
    private Object value;

    public static enum  Operator {
        EQUAL("EQ","等于"),
        NOT_EQUAL("NEQ","不等于"),
        LESS_THAN("LT","小于"),
        LESS_THAN_OR_EQUAL("LTOE","小于或等于"),
        GREATER_THAN("GT","大于"),
        GREATER_THAN_OR_EQUAL("GTOE","大于或等于"),
        LIKE("LIKE","LIKE模糊查询");

        String code;
        String description;
        Operator(String code,String description){
            this.code = code;
            this.description = description;
        }
    }

    public SearchConditionDO(){}
    public SearchConditionDO(String property,Operator operator,Object value){
        this.operator = operator;
        this.property = property;
        this.value = value;
    }


    public static SearchConditionDO build(){
        return new SearchConditionDO();
    }

    public SearchConditionDO operator(Operator operator){
        this.operator = operator;
        return this;
    }

    public SearchConditionDO property(String property){
        this.property = property;
        return this;
    }

    public SearchConditionDO value(String value){
        this.value = value;
        return this;
    }
}
