package cn.jbone.b2b2c.item.api.request;

import lombok.Data;

@Data
public class GetItemTopListReqDTO {

    /**
     * 店铺ID
     */
    private long shopId;
    /**
     * 数量
     */
    private int size;

    /**
     * 排序方式，支持按库存和按销量
     */
    private GetTopListSortTypeEnum sortType = GetTopListSortTypeEnum.SOLD;

    public enum GetTopListSortTypeEnum{
        STOCK,SOLD
    }
}
