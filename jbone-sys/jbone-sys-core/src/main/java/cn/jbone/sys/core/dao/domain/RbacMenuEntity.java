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
@Table(name = "rbac_menu")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RbacMenuEntity implements Serializable {
    private int id;
    private Integer systemId;
    private Integer pid;
    private String name;
    private String url;
    private String target;
    private Long orders;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private String icon;
    private List<RbacRoleEntity> roles;
    private List<RbacUserEntity> users;
    private List<RbacMenuEntity> childMenus;

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
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
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
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "target")
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_role_menu",joinColumns = @JoinColumn(name = "menu_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    public List<RbacRoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RbacRoleEntity> roles) {
        this.roles = roles;
    }

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_menu",joinColumns = @JoinColumn(name = "menu_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    public List<RbacUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<RbacUserEntity> users) {
        this.users = users;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pid")
    public List<RbacMenuEntity> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<RbacMenuEntity> childMenus) {
        this.childMenus = childMenus;
    }
    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
