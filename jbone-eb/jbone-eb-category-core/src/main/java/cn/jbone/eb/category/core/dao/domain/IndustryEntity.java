package cn.jbone.eb.category.core.dao.domain;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
@Entity
@Table(name = "industry")
public class IndustryEntity {
    private int id;
    private String name;
    private int businessType;
    private String description;
    private int sortNum;
    private int status;
    private String features;
    private String operator;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private List<BackCategoryEntity> backCategoryEntities;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "business_type")
    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "sort_num")
    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "features")
    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "industry_back_category",joinColumns = @JoinColumn(name = "industry_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "back_category_id",referencedColumnName = "id"))
    public List<BackCategoryEntity> getBackCategoryEntities() {
        return backCategoryEntities;
    }

    public void setBackCategoryEntities(List<BackCategoryEntity> backCategoryEntities) {
        this.backCategoryEntities = backCategoryEntities;
    }
}
