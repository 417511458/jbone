package cn.jbone.common.utils;

public enum IdTargetEnum {
    SHOP(10),   //店铺
    ITEM(20),   //商品
    CMS(30),    //文章
    TAG(40),    //标签
    MAX(99);

    private int target;

    IdTargetEnum(int target){
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }
}
