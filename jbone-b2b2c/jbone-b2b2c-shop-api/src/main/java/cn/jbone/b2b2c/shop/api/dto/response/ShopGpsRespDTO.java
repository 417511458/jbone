package cn.jbone.b2b2c.shop.api.dto.response;

import lombok.Data;


/**
 * 店铺定位信息
 */
@Data
public class ShopGpsRespDTO {

    private String guid;

    private double lon;

    private double lat;

}
