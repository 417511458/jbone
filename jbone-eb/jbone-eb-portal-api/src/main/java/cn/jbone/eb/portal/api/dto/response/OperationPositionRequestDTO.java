package cn.jbone.eb.portal.api.dto.response;

import lombok.Data;

/**
 * @author hongxiangbin
 * @version 1.0.0
 * @email 862217801@qq.com
 * @date 2018/4/14 13:19
 */
@Data
public class OperationPositionRequestDTO extends OperationPostionBaseInfoDTO {
    private String imgUrl;
    private String linkUrl;
    private String description;
    private int sortNum;

}
