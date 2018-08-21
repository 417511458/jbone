package cn.jbone.b2b2c.shop.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "shop_gps")
public class ShopGpsEntity {
    @Id
    @Column(name = "id",unique = true,columnDefinition = "COMMENT '主键ID'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "shop_id",nullable = false,columnDefinition = "COMMENT '店铺ID'")
    private long shopId;

    @Column(name = "guid",length = 100,columnDefinition = "COMMENT '设备ID'")
    private String guid;

    @Column(name = "lon",columnDefinition = "COMMENT '经度'")
    private double lon;

    @Column(name = "lat",columnDefinition = "COMMENT '纬度'")
    private double lat;

    @Column(name = "operator", length = 100, columnDefinition = "COMMENT '操作人'")
    private String operator;

    @CreationTimestamp
    @Column(name = "add_time",columnDefinition = "COMMENT '添加时间'")
    private Timestamp addTime;

    @UpdateTimestamp
    @Column(name = "update_time",columnDefinition = "COMMENT '更新时间'")
    private Timestamp updateTime;

    @Version
    @Column(name = "version",columnDefinition = "COMMENT '版本号，乐观锁'")
    private int version;


}
