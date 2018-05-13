package cn.jbone.eb.category.core.dao.domain;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
@Entity
@Table(name = "back_category")
public class BackCategoryEntity {
    private int id;
    private String name;
    private int pid;
    private String cids;
    private String description;
    private int sortNum;
    private int status;
    private String features;
    private String operator;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private List<FrontCategoryEntity> frontCategoryEntities;
    private List<BrandEntity> brandEntities;
    private List<BackCategoryPropertyEntity> backCategoryPropertyEntities;
    private List<IndustryEntity> industryEntities;

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
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "cids")
    public String getCids() {
        return cids;
    }

    public void setCids(String cids) {
        this.cids = cids;
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

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "front_back_category_relation",joinColumns = @JoinColumn(name = "back_category_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "front_category_id",referencedColumnName = "id"))
    public List<FrontCategoryEntity> getFrontCategoryEntities() {
        return frontCategoryEntities;
    }

    public void setFrontCategoryEntities(List<FrontCategoryEntity> frontCategoryEntities) {
        this.frontCategoryEntities = frontCategoryEntities;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "back_category_brand_relation",joinColumns = @JoinColumn(name = "back_category_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "brand_id",referencedColumnName = "id"))
    public List<BrandEntity> getBrandEntities() {
        return brandEntities;
    }

    public void setBrandEntities(List<BrandEntity> brandEntities) {
        this.brandEntities = brandEntities;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "back_category_id")
    public List<BackCategoryPropertyEntity> getBackCategoryPropertyEntities() {
        return backCategoryPropertyEntities;
    }

    public void setBackCategoryPropertyEntities(List<BackCategoryPropertyEntity> backCategoryPropertyEntities) {
        this.backCategoryPropertyEntities = backCategoryPropertyEntities;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "industry_back_category",joinColumns = @JoinColumn(name = "back_category_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "industry_id",referencedColumnName = "id"))
    public List<IndustryEntity> getIndustryEntities() {
        return industryEntities;
    }

    public void setIndustryEntities(List<IndustryEntity> industryEntities) {
        this.industryEntities = industryEntities;
    }
}
