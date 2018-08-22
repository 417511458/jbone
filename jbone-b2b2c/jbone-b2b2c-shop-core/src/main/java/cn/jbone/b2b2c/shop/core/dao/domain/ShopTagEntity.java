package cn.jbone.b2b2c.shop.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 店铺标签
 */
@Data
@Entity(name = "shop_tag")
@org.hibernate.annotations.Table(appliesTo = "shop_tag",comment = "店铺标签关系表")
public class ShopTagEntity {

    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 标签ID,外键依赖标签中心的标签ID
     */
    @Column(name = "tag_id",nullable = false)
    private int tagId;

    /**
     * COMMENT '操作人'
     */
    @Column(name = "operator", length = 100)
    private String operator;

    /**
     * COMMENT '添加时间'
     */
    @CreationTimestamp
    @Column(name = "add_time")
    private Timestamp addTime;

    /**
     * COMMENT '更新时间'
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * COMMENT '版本号，乐观锁'
     */
    @Version
    @Column(name = "version")
    private int version;

    /**
     * 店铺ID
     */
    @ManyToOne
    @JoinColumn(name = "shop_id",nullable = false)
    private ShopInfoEntity shopInfo;



}
