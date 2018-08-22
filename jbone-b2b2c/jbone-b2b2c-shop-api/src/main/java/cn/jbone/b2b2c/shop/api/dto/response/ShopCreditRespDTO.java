package cn.jbone.b2b2c.shop.api.dto.response;

import lombok.Data;

/**
 * 店铺积分等级
 */
@Data
public class ShopCreditRespDTO {
    private int score;
    private int creditType;
    private int creditCount;
}
