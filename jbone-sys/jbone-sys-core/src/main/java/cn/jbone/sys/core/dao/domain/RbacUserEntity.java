package cn.jbone.sys.core.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "rbac_user")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RbacUserEntity implements Serializable {
    private int id;
    private String username;
    private String password;
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private String nickName;
    private int sex;
    private int locked;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private String salt;
    private List<RbacOrganizationEntity> organizations;
    private List<RbacRoleEntity> roles;
    private List<RbacPermissionEntity> permissions;
    private List<RbacMenuEntity> menus;

    @Column(name = "nick_name",length = 200)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "realname")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Column(name = "locked")
    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    @Column(name = "salt")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_organization",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "organization_id",referencedColumnName = "id"))
    public List<RbacOrganizationEntity> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<RbacOrganizationEntity> organizations) {
        this.organizations = organizations;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_role",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    public List<RbacRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RbacRoleEntity> roles) {
        this.roles = roles;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_permission",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"))
    public List<RbacPermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RbacPermissionEntity> permissions) {
        this.permissions = permissions;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_menu",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "menu_id",referencedColumnName = "id"))
    public List<RbacMenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<RbacMenuEntity> menus) {
        this.menus = menus;
    }
}
