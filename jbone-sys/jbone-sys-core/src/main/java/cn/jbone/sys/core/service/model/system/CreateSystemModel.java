package cn.jbone.sys.core.service.model.system;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CreateSystemModel {

    @NotBlank(message = "系统路径不能为空.")
    private String basepath;
    private Byte status;
    @NotBlank(message = "系统名不能为空.")
    private String name;
    @NotBlank(message = "系统标题不能为空.")
    private String title;
    private String description;
    private long orders;
}
