package cn.jbone.sys.core.dao.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "rbac_permission")
public class RbacPermissionEntity implements Serializable {
    private int id;
    private int systemId;
    private String name;
    private int type;
    private String permissionValue;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private List<RbacRoleEntity> roles;
    private List<RbacUserEntity> users;
    private int menuId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "system_id")
    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    @Column(name = "menu_id")
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "permission_value")
    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
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
    @JoinTable(name = "rbac_role_permission",joinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    public List<RbacRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RbacRoleEntity> roles) {
        this.roles = roles;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_permission",joinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    public List<RbacUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<RbacUserEntity> users) {
        this.users = users;
    }
}
