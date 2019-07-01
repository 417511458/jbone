package cn.jbone.cms.common.enums;

public enum BooleanEnum {

    FALSE(0,"FALSE"),

    TRUE(1,"TRUE");


    private int code;

    private String desc;

    BooleanEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
