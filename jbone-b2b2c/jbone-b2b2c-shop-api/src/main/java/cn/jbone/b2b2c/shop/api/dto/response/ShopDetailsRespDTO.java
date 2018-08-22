package cn.jbone.b2b2c.shop.api.dto.response;

import lombok.Data;

import java.util.List;

/**
 * 店铺详情DTO
 */
@Data
public class ShopDetailsRespDTO {
    /**
     * 店铺基本信息
     */
    private ShopInfoRespDTO shopInfo;

    /**
     * 店铺积分等级
     */
    private ShopCreditRespDTO shopCredit;

    /**
     * 店铺营业时间
     */
    private ShopHoursRespDTO shopHours;

    /**
     * 店铺标签列表
     */
    private List<ShopTagRespDTO> shopTags;

    /**
     * 店铺定位信息
     */
    private ShopGpsRespDTO shopGps;

}
