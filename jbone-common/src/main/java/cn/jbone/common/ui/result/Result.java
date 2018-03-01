package cn.jbone.common.ui.result;

import java.io.Serializable;

public class Result implements Serializable {
    //提示消息
    private String msg;
    //状态码
    private int status;

    public Result(){}

    public Result(ResultStatus resultStatus){
        this.setMsg(resultStatus.getMsg());
        this.setStatus(resultStatus.getStatus());
    }

    public Result(int status,String msg){
        this.setMsg(msg);
        this.setStatus(status);
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
