package cn.jbone.eb.portal.api.dto.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OperationPostionBaseInfoDTO {
    private int id;
    private int type;
    private String title;
    private int status;
    private String operator;
    private Timestamp addTimeFrom;
    private Timestamp addTimeTo;
}
