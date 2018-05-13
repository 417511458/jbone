package cn.jbone.eb.category.core.dao.domain;

import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
@Entity
@Table(name = "front_back_category_relation")
public class FrontBackCategoryRelationEntity {
    private int id;
    private int frontCategoryId;
    private int backCategoryId;
    private String operator;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "front_category_id")
    public int getFrontCategoryId() {
        return frontCategoryId;
    }

    public void setFrontCategoryId(int frontCategoryId) {
        this.frontCategoryId = frontCategoryId;
    }

    @Basic
    @Column(name = "back_category_id")
    public int getBackCategoryId() {
        return backCategoryId;
    }

    public void setBackCategoryId(int backCategoryId) {
        this.backCategoryId = backCategoryId;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @CreationTimestamp
    @Basic
    @Column(name = "add_time")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @UpdateTimestamp
    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Version
    @Basic
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}
