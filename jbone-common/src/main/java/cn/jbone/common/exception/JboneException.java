package cn.jbone.common.exception;

public class JboneException extends RuntimeException {

    public static final String ILLEGAL_PARAM = "参数错误";
    public static final String USER_IS_NOT_FOUND = "用户不存在";
    public static final String SITE_IS_NOT_FOUND = "站点不存在";
    public static final String PERMISSION_DENIED = "无权操作";

    public JboneException() {
        super();
    }
    public JboneException(String message) {
        super(message);
    }
}
