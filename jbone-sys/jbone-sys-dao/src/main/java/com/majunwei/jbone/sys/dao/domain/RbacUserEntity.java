package com.majunwei.jbone.sys.dao.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "rbac_user")
public class RbacUserEntity {
    private int id;
    private String username;
    private String password;
    private String salt;
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private Byte sex;
    private Byte locked;
    private Timestamp addTime;
    private Timestamp updateTime;
    private Integer version;
    private List<RbacOrganizationEntity> organizations;
    private List<RbacRoleEntity> roles;
    private List<RbacPermissionEntity> permissions;
    private List<RbacMenuEntity> menus;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Basic
    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "locked")
    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
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
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_organization",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "organization_id",referencedColumnName = "id"))
    public List<RbacOrganizationEntity> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<RbacOrganizationEntity> organizations) {
        this.organizations = organizations;
    }

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    public List<RbacRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RbacRoleEntity> roles) {
        this.roles = roles;
    }

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_permission",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"))
    public List<RbacPermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RbacPermissionEntity> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_menu",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "menu_id",referencedColumnName = "id"))
    public List<RbacMenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<RbacMenuEntity> menus) {
        this.menus = menus;
    }
}
