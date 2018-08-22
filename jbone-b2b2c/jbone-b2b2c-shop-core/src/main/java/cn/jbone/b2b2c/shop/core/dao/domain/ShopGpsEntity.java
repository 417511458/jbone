package cn.jbone.b2b2c.shop.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 店铺定位信息
 */
@Data
@Entity(name = "shop_gps")
@org.hibernate.annotations.Table(appliesTo = "shop_gps",comment = "店铺定位信息表")
public class ShopGpsEntity {
    /**
     * COMMENT '主键ID'
     */
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * COMMENT '设备ID'
     */
    @Column(name = "guid",length = 100)
    private String guid;

    /**
     * COMMENT '经度'
     */
    @Column(name = "lon")
    private double lon;

    /**
     * COMMENT '纬度'
     */
    @Column(name = "lat")
    private double lat;

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
