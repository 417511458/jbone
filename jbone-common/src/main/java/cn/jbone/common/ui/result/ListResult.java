package cn.jbone.common.ui.result;

import java.util.Collection;

/**
 * 列表结果
 */
public class ListResult extends Result {

    private long total;
    private Collection rows;

    public ListResult(ResultStatus resultStatus){
        super(resultStatus);
    }

    public ListResult(ResultStatus resultStatus,long total,Collection rows){
        this(resultStatus);
        this.total = total;
        this.rows = rows;
    }

    public ListResult(int status,String msg){
        super(status, msg);
    }

    public ListResult(int status,String msg, long total,Collection rows){
        this(status, msg);
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Collection getRows() {
        return rows;
    }

    public void setRows(Collection rows) {
        this.rows = rows;
    }
}
