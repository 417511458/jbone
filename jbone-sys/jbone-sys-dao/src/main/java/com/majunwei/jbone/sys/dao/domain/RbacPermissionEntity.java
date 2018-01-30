package com.majunwei.jbone.sys.dao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "rbac_permission")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RbacPermissionEntity implements Serializable {
    private int id;
    private int systemId;
    private Integer pid;
    private String name;
    private Byte type;
    private String permissionValue;
    private String uri;
    private String icon;
    private Byte status;
    private Long orders;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private List<RbacRoleEntity> roles;
    private List<RbacUserEntity> users;

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
    @Column(name = "system_id")
    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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
    @Column(name = "type")
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "permission_value")
    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    @Basic
    @Column(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
    @Column(name = "orders")
    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
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

    @JsonBackReference
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "permissions")
    public List<RbacRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RbacRoleEntity> roles) {
        this.roles = roles;
    }

    @JsonBackReference
    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "permissions")
    public List<RbacUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<RbacUserEntity> users) {
        this.users = users;
    }
}
