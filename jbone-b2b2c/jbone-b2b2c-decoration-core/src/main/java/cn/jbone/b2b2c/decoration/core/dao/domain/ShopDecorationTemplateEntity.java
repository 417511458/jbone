package cn.jbone.b2b2c.decoration.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 店铺装修模版关系
 */
@Data
@Entity
@Table(name = "shop_decoration_template")
public class ShopDecorationTemplateEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id",nullable = false)
    private long shopId;

    /**
     * 装修模版ID
     */
    @ManyToOne
    @JoinColumn(name = "template_id",nullable = false)
    private DecorationTemplateEntity decorationTemplate;

    /**
     * 状态：
     * 1：可用
     * 0 : 不可用
     */
    @Column(name = "status",nullable = false)
    private int status = 1;

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
