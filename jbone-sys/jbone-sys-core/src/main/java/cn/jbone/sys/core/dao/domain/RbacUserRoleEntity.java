package cn.jbone.sys.core.dao.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "rbac_user_role")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class RbacUserRoleEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "role_id")
    private int roleId;

}
