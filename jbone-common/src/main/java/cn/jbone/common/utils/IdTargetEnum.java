package cn.jbone.common.utils;

public enum IdTargetEnum {
    SHOP(100),   //店铺
    ITEM(200),   //商品
    CMS(300),    //文章
    TAG(400);    //标签

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
