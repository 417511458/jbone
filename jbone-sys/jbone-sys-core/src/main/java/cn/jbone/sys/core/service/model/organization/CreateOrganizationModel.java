package cn.jbone.sys.core.service.model.organization;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CreateOrganizationModel {
    private Integer pid;
    @NotBlank(message = "组织名称不能为空")
    private String name;
    private String description;
}
