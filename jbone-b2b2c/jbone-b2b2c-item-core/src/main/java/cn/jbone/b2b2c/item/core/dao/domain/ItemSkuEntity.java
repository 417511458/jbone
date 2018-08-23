package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商品型号
 */
@Data
@Entity
@Table(name = "item_sku")
public class ItemSkuEntity {

    /**
     * 自增主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 型号标题
     * 默认为属性值的组合，用户可修改
     */
    @Column(name = "title",length = 200,nullable = false)
    private String title;

    /**
     * 属性ID集合；
     * 属性ID：ValueId；属性ID：ValueId
     */
    @Column(name = "property_values",length = 200)
    private String propertyValues;

    /**
     * SKU图片
     */
    @Column(name = "img",length = 200,nullable = false)
    private String img;

    /**
     * 状态：
     * 1：可用
     * 0:不可用
     */
    @Column(name = "status",nullable = false)
    private int status=1;

    /**
     * SKU所属商品
     */
    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemInfoEntity itemInfo;


    /**
     * 商品型号库存
     */
    @OneToOne(mappedBy = "itemSku")
    private ItemSkuStockEntity itemSkuStock;

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
