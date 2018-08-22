package cn.jbone.b2b2c.shop.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * 店铺基本信息
 */
@Data
@Entity(name = "shop_info")
@org.hibernate.annotations.Table(appliesTo = "shop_info",comment = "店铺基本信息表")
public class ShopInfoEntity {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 店铺名称
     */
    @Column(name = "shop_name",length = 100,nullable = false)
    private String shopName;

    /**
     * 店铺LOGO
     */
    @Column(name = "shop_logo",length = 200,nullable = true)
    private String shopLogo;

    /**
     * 店铺二维码
     */
    @Column(name = "qrcode",length = 200,nullable = true)
    private String qrcode;

    /**
     * 店招图片
     */
    @Column(name = "front_cover",length = 200,nullable = true)
    private String frontCover;

    /**
     * 店铺公告
     */
    @Column(name = "note",length = 1000,nullable = true)
    private String note;

    /**
     * 状态，1为正常，0为注销
     */
    @Column(name = "status",columnDefinition = "int default 1 not null")
    private int status;

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

    @OneToOne(mappedBy = "shopInfo")
    private ShopGpsEntity shopGps;

    @OneToOne(mappedBy = "shopInfo")
    private ShopHoursEntity shopHours;

    @OneToOne(mappedBy = "shopInfo")
    private ShopCreditEntity shopCredit;

    @OneToMany(mappedBy = "shopInfo")
    private List<ShopTagEntity> shopTags;



}
