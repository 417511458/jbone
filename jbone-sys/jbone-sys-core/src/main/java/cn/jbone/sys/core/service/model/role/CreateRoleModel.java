package cn.jbone.sys.core.service.model.role;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CreateRoleModel {
    @NotBlank(message = "角色名称不能为空")
    private String name;
    @NotBlank(message = "角色标题不能为空")
    private String title;
    private String description;
}
