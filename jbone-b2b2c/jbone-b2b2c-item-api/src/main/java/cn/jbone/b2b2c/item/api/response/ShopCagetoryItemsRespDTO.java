package cn.jbone.b2b2c.item.api.response;

import lombok.Data;

import java.util.List;

@Data
public class ShopCagetoryItemsRespDTO {
    private long id;
    private String name;
    List<ItemBaseInfoRespDTO> items;
}
