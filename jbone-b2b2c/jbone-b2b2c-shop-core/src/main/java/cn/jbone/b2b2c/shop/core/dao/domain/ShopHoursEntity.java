package cn.jbone.b2b2c.shop.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 店铺营业时间
 */
@Data
@Entity(name = "shop_hours")
@org.hibernate.annotations.Table(appliesTo = "shop_hours",comment = "店铺营业时间表")
public class ShopHoursEntity {
    /**
     * COMMENT '主键ID'
     */
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * COMMENT '工作日开始时间'
     */
    @Column(name = "working_day_start",length = 20)
    private String workingDayStart;

    /**
     * 工作日结束时间
     */
    @Column(name = "working_day_end",length = 20)
    private String workingDayEnd;

    /**
     * 周末开始时间
     */
    @Column(name = "weekend_start",length = 20)
    private String weekendStart;

    /**
     * 周末结束时间
     */
    @Column(name = "weekend_end",length = 20)
    private String weekendEnd;

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
    @OneToOne
    @JoinColumn(name = "shop_id",referencedColumnName = "id",nullable = false)
    private ShopInfoEntity shopInfo;


}
