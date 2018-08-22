package cn.jbone.b2b2c.shop.api.dto.response;

import lombok.Data;

/**
 * 店铺营业时间
 */
@Data
public class ShopHoursRespDTO {
    private String workingDayStart;

    private String workingDayEnd;

    private String weekendStart;

    private String weekendEnd;


}
