package cn.jbone.cms.core.dao.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    /**
     * 添加时间
     */
    @CreationTimestamp
    @Basic
    @Column(name = "add_time")
    private Timestamp addTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Basic
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private int version;

    /**
     * 创建者
     */
    @Column(name = "creator")
    private int creator;
}
