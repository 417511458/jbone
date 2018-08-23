package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 商品SKU库存表
 */
@Data
@Entity
@Table(name = "item_sku_stock")
public class ItemSkuStockEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 商品ID（冗余）
     */
    @Column(name = "item_id",nullable = false)
    private long itemId;

    /**
     * 店铺ID（冗余）
     */
    @Column(name = "shop_id",nullable = false)
    private long shopId;

    /**
     * 价格，单位为分
     */
    @Column(name = "price",nullable = false)
    private int price;

    /**
     * 库存量
     */
    @Column(name = "stock",nullable = false)
    private int stock;

    /**
     * 销量
     */
    @Column(name = "sold",nullable = false)
    private int sold;

    /**
     * 状态：
     * 1：可用
     * 0:不可用
     */
    @Column(name = "status")
    private int status=1;

    /**
     * 商品SKU ID，如果商品没有SKU，则为0，并将价格、库存、销量同步过来
     */
    @OneToOne
    @JoinColumn(name = "item_sku_id")
    private ItemSkuEntity itemSku;

    @OneToMany(mappedBy = "itemSkuStock")
    private List<ItemSkuStockStatusEntity> itemSkuStockStatuses;

    /**
     * 操作人
     */
    @Column(name = "operator", length = 100)
    private String operator;

    /**
     * 添加时间
     */
    @CreationTimestamp
    @Column(name = "add_time")
    private Timestamp addTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 版本号，乐观锁
     */
    @Version
    @Column(name = "version")
    private int version;
}
