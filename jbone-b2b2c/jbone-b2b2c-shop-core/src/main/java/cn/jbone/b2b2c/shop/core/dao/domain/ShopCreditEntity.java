package cn.jbone.b2b2c.shop.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;

/**
 * 店铺积分等级
 */
@Data
@Entity(name = "shop_credit")
@org.hibernate.annotations.Table(appliesTo = "shop_credit",comment = "店铺积分等级表")
public class ShopCreditEntity {

    /**
     * COMMENT '主键ID'
     */
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * COMMENT '店铺等级积分'
     */
    @Column(name = "score")
    private int score;

    /**
     * COMMENT '等级类型，1：星级，2：钻石，3：皇冠'
     */
    @Column(name = "credit_type")
    private int creditType;

    /**
     * columnDefinition = "COMMENT '店铺等级数量，如1颗星，2颗钻'"
     */
    @Column(name = "credit_count")
    private int creditCount;

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
     * COMMENT '店铺ID'
     */
    @OneToOne
    @JoinColumn(name = "shop_id",referencedColumnName = "id",nullable = false)
    private ShopInfoEntity shopInfo;


}
