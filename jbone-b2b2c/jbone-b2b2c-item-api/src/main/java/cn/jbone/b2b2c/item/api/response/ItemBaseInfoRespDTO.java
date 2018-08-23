package cn.jbone.b2b2c.item.api.response;

import lombok.Data;

@Data
public class ItemBaseInfoRespDTO {
    private long id;
    private String name;
    private int price;
    private int stock;
    private int sold;
    private String imgHead;
    private String imgs;
    private String description;
}
