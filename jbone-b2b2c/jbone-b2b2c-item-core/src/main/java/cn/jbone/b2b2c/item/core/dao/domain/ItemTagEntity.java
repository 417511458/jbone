package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "item_tag")
public class ItemTagEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 标签ID
     */
    @Column(name = "tag_id",nullable = false)
    private int tagId;

    /**
     * 商品
     */
    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
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
