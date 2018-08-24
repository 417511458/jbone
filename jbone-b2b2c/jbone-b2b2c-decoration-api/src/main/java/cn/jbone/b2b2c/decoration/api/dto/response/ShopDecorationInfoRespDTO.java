package cn.jbone.b2b2c.decoration.api.dto.response;

import lombok.Data;

@Data
public class ShopDecorationInfoRespDTO {
    private long templateId;        //模版ID
    private String templateCode;    //模版编码
    private String templateName;    //模版名字
    private String templateDescription; //模版描述
    private int status;     //是否装修
}
