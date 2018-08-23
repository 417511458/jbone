package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 商品分类表
 */
@Data
@Entity
@Table(name = "item_category")
public class ItemCategoryEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 分类名
     */
    @Column(name = "name",length = 100,nullable = false)
    private String name;

    /**
     * 父分类ID
     */
    @Column(name = "pid",nullable = false)
    private long pid = 0;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id",nullable = false)
    private long shopId;

    /**
     * 状态
     * 1:可用
     * 0:不可用
     */
    @Column(name = "status",nullable = false)
    private int status;

    /**
     * 序号，自大到小
     */
    @Column(name = "sort_num",nullable = false)
    private int sortNum;

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
     * 商品-分类关系
     */
    @OneToMany(mappedBy = "itemCategory")
    private List<ItemCategoryRelationEntity> itemCategoryRelations;

}
