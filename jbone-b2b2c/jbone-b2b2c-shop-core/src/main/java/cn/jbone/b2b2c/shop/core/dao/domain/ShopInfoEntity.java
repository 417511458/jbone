package cn.jbone.b2b2c.shop.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "shop_info")
public class ShopInfoEntity {
    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "shop_name",length = 100,nullable = false,columnDefinition = "COMMENT '店铺名称'")
    private String shopName;

    @Column(name = "shop_logo",length = 200,nullable = true,columnDefinition = "COMMENT '店铺LOGO'")
    private String shopLogo;

    @Column(name = "qrcode",length = 200,nullable = true,columnDefinition = "COMMENT '店铺二维码'")
    private String qrcode;

    @Column(name = "front_cover",length = 200,nullable = true,columnDefinition = "COMMENT '店招图片'")
    private String frontCover;

    @Column(name = "note",length = 1000,nullable = true,columnDefinition = "COMMENT '店铺公告'")
    private String note;

    @Column(name = "status",columnDefinition = "default 1 COMMENT '状态，1为正常，0为注销'")
    private int status;

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

    @OneToOne()
    private ShopGpsEntity shopGpsEntity;

}
