package cn.jbone.common.rpc;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -875864042638324305L;

    private ResultStatus status = new ResultStatus();
    private T data;


    private static final int STATUS_404 = 404;
    private static final int STATUS_500 = 500;
    private static final int STATUS_PROTECTED = 1000;
    private static final int SUCCESS_CODE=0;

    public Result(int code, String message){
        status.setCode(code);
        status.setMessage(message);
    }

    public Result(T data){
        this.setData(data);
    }

    public Result(){}

    public boolean isSuccess(){
        return this.getStatus().getCode() == SUCCESS_CODE;
    }

    /**
     * 构建失败返回结果
     * @param code 状态码
     * @param message 提示信息
     * @return 失败返回结果
     */
    public static Result wrapError(int code, String message) {
        Result result = new Result();
        result.getStatus().setCode(code);
        result.getStatus().setMessage(message);
        return result;
    }

    /**
     * 构建未找到资源的返回结果，比如查询用户没找到，可以使用此方法构建
     * @param message 提示信息
     * @return 错误结果
     */
    public static Result wrap404Error(String message) {
        return wrapError(STATUS_404,message);
    }


    /**
     * 构建系统错误结构，比如由程序引发的空指针错误等
     * @param message 提示信息
     * @return 错误结果
     */
    public static Result wrap500Error(String message) {
        return wrapError(STATUS_500,message);
    }

    /**
     * 系统错误
     * @return
     */
    public static Result wrap500Error() {
        return wrap500Error("系统错误");
    }

    /**
     * 系统熔断保护
     * @return
     */
    public static Result wrapProtectedError() {
        return wrapError(STATUS_PROTECTED,"系统熔断保护");
    }


    public static Result wrapSuccess() {
        return new Result();
    }

}
