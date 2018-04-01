package cn.jbone.sys.core.dao.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "rbac_organization")
public class RbacOrganizationEntity implements Serializable {
    private int id;
    private Integer pid;
    private String name;
    private String description;
    private Timestamp addTime;
    private Timestamp updateTime;
    private int version;
    private List<RbacUserEntity> users;
    private List<RbacOrganizationEntity> childOrganizations;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "pid")
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @JoinTable(name = "rbac_user_organization",joinColumns = @JoinColumn(name = "organization_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    public List<RbacUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<RbacUserEntity> users) {
        this.users = users;
    }

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pid")
    public List<RbacOrganizationEntity> getChildOrganizations() {
        return childOrganizations;
    }

    public void setChildOrganizations(List<RbacOrganizationEntity> childOrganizations) {
        this.childOrganizations = childOrganizations;
    }
}
