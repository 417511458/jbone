package cn.jbone.common.rpc;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultStatus implements Serializable {
	private int code = 0;     //状态码
    private String message = "";   //提示信息
    
}
