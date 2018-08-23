package cn.jbone.b2b2c.item.core.dao.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商品详情，存储商品富文本
 */
@Data
@Entity
@Table(name = "item_detail")
public class ItemDetailEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "detail_content",columnDefinition = "text not null")
    private String detailContent;

    @OneToOne
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
