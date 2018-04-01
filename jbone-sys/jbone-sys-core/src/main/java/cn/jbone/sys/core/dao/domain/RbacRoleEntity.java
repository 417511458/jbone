package cn.jbone.sys.core.dao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "rbac_role")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RbacRoleEntity implements Serializable {
    private int id;
    private String name;
    private String title;
    private String description;
    private long orders;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private List<RbacPermissionEntity> permissions;
    private List<RbacUserEntity> users;
    private List<RbacMenuEntity> menus;

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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "orders")
    public long getOrders() {
        return orders;
    }

    public void setOrders(long orders) {
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

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_role_permission",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"))
    public List<RbacPermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RbacPermissionEntity> permissions) {
        this.permissions = permissions;
    }

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_role",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    public List<RbacUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<RbacUserEntity> users) {
        this.users = users;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_role_menu",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "menu_id",referencedColumnName = "id"))
    public List<RbacMenuEntity> getMenus() {
        return menus;
    }

    public void setMenus(List<RbacMenuEntity> menus) {
        this.menus = menus;
    }
}
