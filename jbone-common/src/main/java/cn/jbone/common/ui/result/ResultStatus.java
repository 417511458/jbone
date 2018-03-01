package cn.jbone.common.ui.result;

public enum  ResultStatus {

    SUCCESS(0,"success"),
    FAIL(-1,"fail")
    ;

    private int status;
    private String msg;

    ResultStatus(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
