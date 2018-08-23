package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商品-分类关系
 */
@Data
@Entity
@Table(name = "item_category_relation")
public class ItemCategoryRelationEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 所属分类
     */
    @ManyToOne
    @JoinColumn(name = "item_category_id")
    private ItemCategoryEntity itemCategory;

    /**
     * 所属商品
     */
    @ManyToOne
    @JoinColumn(name = "item_id")
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
