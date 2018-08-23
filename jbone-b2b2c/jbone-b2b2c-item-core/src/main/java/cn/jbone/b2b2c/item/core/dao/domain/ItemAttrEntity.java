package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商品属性
 */
@Data
@Entity
@Table(name = "item_attr")
public class ItemAttrEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    /**
     * 商品SKU ID，0代表不是SKU属性
     */
    @Column(name = "item_sku_id",nullable = false)
    private long itemSkuId=0;

    /**
     * 属性ID
     */
    @Column(name = "property_id",nullable = false)
    private int propertyId;

    /**
     * 属性值ID（为0时代表用户输入的）
     */
    @Column(name = "value_id",nullable = false)
    private int valueId=0;

    /**
     * 属性值ID（为0时代表用户输入的）
     */
    @Column(name = "value_content",length = 1000)
    private String valueContent;

    /**
     * 是否SKU属性；
     * 1:是
     * 0:不是
     */
    @Column(name = "is_sku",nullable = false)
    private int isSku=0;

    /**
     * 所属商品
     */
    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    private ItemInfoEntity itemInfo;

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
