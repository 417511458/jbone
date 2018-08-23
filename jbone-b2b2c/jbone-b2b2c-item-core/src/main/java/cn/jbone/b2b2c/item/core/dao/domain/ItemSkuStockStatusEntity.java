package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商品SKU库存记录表
 */
@Data
@Entity
@Table(name = "item_sku_stock_status")
public class ItemSkuStockStatusEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 订单ID
     */
    @Column(name = "order_id",nullable = false)
    private long orderId;

    /**
     * 商品库存主表
     */
    @ManyToOne
    @JoinColumn(name = "item_stock_id",nullable = false)
    private ItemSkuStockEntity itemSkuStock;

    /**
     * 库存状态
     * 0:初始值
     * 1:已预知
     * 2:已扣减
     * 3:已回滚
     */
    @Column(name = "stock_status",nullable = false)
    private int stockStatus;

    /**
     * 销量状态
     * 0:初始值
     * 1:已加量
     * 2:已回退
     */
    @Column(name = "sold_status",nullable = false)
    private int soldStatus;

    /**
     * 增量库存数，用于预扣、扣减、回滚读取
     */
    @Column(name = "num",nullable = false)
    private int num;

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
