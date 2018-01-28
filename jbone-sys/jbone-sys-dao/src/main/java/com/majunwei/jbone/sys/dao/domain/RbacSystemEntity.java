package com.majunwei.jbone.sys.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "rbac_system")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RbacSystemEntity {
    private int id;
    @NotBlank(message = "系统路径不能为空.")
    private String basepath;
    private Byte status;
    @NotBlank(message = "系统名不能为空.")
    private String name;
    @NotBlank(message = "系统标题不能为空.")
    private String title;
    private String description;
    private Long orders;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private int serviceRegistered;
    private String serviceCasFilter;
    private String serviceThemeServer;
    private int serviceId;
    private String serviceDescription;
    private int serviceEvaluationOrder;
    private String serviceName;
    private String serviceThemePath;


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "basepath")
    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "orders")
    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    @CreationTimestamp
    @Column(name = "add_time")
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @UpdateTimestamp
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getServiceRegistered() {
        return serviceRegistered;
    }

    public void setServiceRegistered(int serviceRegistered) {
        this.serviceRegistered = serviceRegistered;
    }

    public String getServiceCasFilter() {
        return serviceCasFilter;
    }

    public void setServiceCasFilter(String serviceCasFilter) {
        this.serviceCasFilter = serviceCasFilter;
    }

    public String getServiceThemeServer() {
        return serviceThemeServer;
    }

    public void setServiceThemeServer(String serviceThemeServer) {
        this.serviceThemeServer = serviceThemeServer;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public int getServiceEvaluationOrder() {
        return serviceEvaluationOrder;
    }

    public void setServiceEvaluationOrder(int serviceEvaluationOrder) {
        this.serviceEvaluationOrder = serviceEvaluationOrder;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceThemePath() {
        return serviceThemePath;
    }

    public void setServiceThemePath(String serviceThemePath) {
        this.serviceThemePath = serviceThemePath;
    }
}
