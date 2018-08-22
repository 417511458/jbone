package cn.jbone.b2b2c.shop.api.dto.response;

import lombok.Data;

/**
 * 店铺标签
 */
@Data
public class ShopTagRespDTO {

    private long tagId;
    private long shopId;
    private String tagName;

}
