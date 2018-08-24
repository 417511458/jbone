package cn.jbone.b2b2c.decoration.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 装修模版
 */
@Data
@Entity
@Table(name = "decoration_template")
public class DecorationTemplateEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    /**
     * 装修模版名称
     */
    @Column(name = "name",nullable = false,length = 100)
    private String name;

    /**
     * 装修模版编码
     */
    @Column(name = "code",nullable = false,length = 100)
    private String code;

    /**
     * 装修模版描述
     */
    @Column(name = "description",length = 1000)
    private String description;

    /**
     * 样例图，以逗号隔开
     */
    @Column(name = "demo",length = 1000)
    private String demo;

    /**
     * 状态：
     * 1：可用
     * 0 : 不可用
     */
    @Column(name = "status",nullable = false)
    private int status;



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
