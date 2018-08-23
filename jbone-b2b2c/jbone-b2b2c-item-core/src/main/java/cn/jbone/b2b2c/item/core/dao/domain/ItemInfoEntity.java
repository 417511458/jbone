package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 商品基本信息表
 */
@Data
@Entity
@Table(name = "item_info")
public class ItemInfoEntity {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 后端类目ID（叶子节点）
     */
    @Column(name = "back_category_id",nullable = false)
    private int backCategoryId;

    /**
     * 品牌ID
     */
    @Column(name = "brand_id")
    private int brandId=0;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id",nullable = false)
    private long shopId;

    /**
     * 商品名称
     */
    @Column(name = "name",length = 200,nullable = false)
    private String name;

    /**
     * 商品价格,单位为分
     */
    @Column(name = "price",nullable = false)
    private int price;

    /**
     * 库存
     */
    @Column(name = "stock",nullable = false)
    private int stock;

    /**
     * 销量
     */
    @Column(name = "sold",nullable = false)
    private int sold;

    /**
     * 商品主图
     */
    @Column(name = "img_head",length = 200,nullable = false)
    private String imgHead;

    /**
     * 商品图片列表
     */
    @Column(name = "imgs",length = 4096)
    private String imgs;

    /**
     * 描述/备注
     */
    @Column(name = "description")
    private String description;

    /**
     * 状态：
     * 1：可用
     * 0 : 不可用
     */
    @Column(name = "status",nullable = false)
    private int status;

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

    /**
     * 商品详情
     */
    @OneToOne(mappedBy = "itemInfo")
    private ItemDetailEntity itemDetail;

    /**
     * 商品型号集合
     */
    @OneToMany(mappedBy = "itemInfo")
    private List<ItemSkuEntity> itemSkus;

    /**
     * 商品属性集合
     */
    @OneToMany(mappedBy = "itemInfo")
    private List<ItemAttrEntity> itemAttrs;

    /**
     * 商品-分类关系
     */
    @OneToMany(mappedBy = "itemInfo")
    private List<ItemCategoryRelationEntity> itemCategoryRelations;

    /**
     * 商品-标签关系
     */
    @OneToMany(mappedBy = "itemInfo")
    private List<ItemTagEntity> itemTags;
}
