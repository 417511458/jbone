package cn.jbone.sys.core.dao.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "rbac_role")
public class RbacRoleEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "orders")
    private long orders;

    @CreationTimestamp
    @Column(name = "add_time")
    private Timestamp addTime;

    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    @Version
    @Column(name = "version")
    private int version;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_role_permission",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "permission_id",referencedColumnName = "id"))
    private List<RbacPermissionEntity> permissions;

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_user_role",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"))
    private List<RbacUserEntity> users;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "rbac_role_menu",joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "menu_id",referencedColumnName = "id"))
    private List<RbacMenuEntity> menus;

}
