package cn.jbone.eb.category.core.dao.domain;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
@Entity
@Table(name = "back_category_property")
public class BackCategoryPropertyEntity {
    private int id;
    private int backCategoryId;
    private int propertyId;
    private int isMust;
    private int isMulti;
    private int isInputProp;
    private int isSku;
    private String description;
    private int status;
    private String operator;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private List<PublicValueEntity> publicValueEntities;

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
    @Column(name = "back_category_id")
    public int getBackCategoryId() {
        return backCategoryId;
    }

    public void setBackCategoryId(int backCategoryId) {
        this.backCategoryId = backCategoryId;
    }

    @Basic
    @Column(name = "property_id")
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Basic
    @Column(name = "is_must")
    public int getIsMust() {
        return isMust;
    }

    public void setIsMust(int isMust) {
        this.isMust = isMust;
    }

    @Basic
    @Column(name = "is_multi")
    public int getIsMulti() {
        return isMulti;
    }

    public void setIsMulti(int isMulti) {
        this.isMulti = isMulti;
    }

    @Basic
    @Column(name = "is_input_prop")
    public int getIsInputProp() {
        return isInputProp;
    }

    public void setIsInputProp(int isInputProp) {
        this.isInputProp = isInputProp;
    }

    @Basic
    @Column(name = "is_sku")
    public int getIsSku() {
        return isSku;
    }

    public void setIsSku(int isSku) {
        this.isSku = isSku;
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
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
    @JoinTable(name = "back_category_property_value",joinColumns = {@JoinColumn(name = "back_category_id",referencedColumnName = "back_category_id"),@JoinColumn(name = "property_id",referencedColumnName = "property_id")},inverseJoinColumns = @JoinColumn(name = "value_id",referencedColumnName = "id"))
    public List<PublicValueEntity> getPublicValueEntities() {
        return publicValueEntities;
    }

    public void setPublicValueEntities(List<PublicValueEntity> publicValueEntities) {
        this.publicValueEntities = publicValueEntities;
    }
}
