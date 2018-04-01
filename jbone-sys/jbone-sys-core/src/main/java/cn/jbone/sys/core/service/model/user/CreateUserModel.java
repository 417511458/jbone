package cn.jbone.sys.core.service.model.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class CreateUserModel {
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20,message = "用户名最长不能超过20")
    private String username;
    @Length(max = 100,message = "密码最长不能超过100")
    @NotBlank(message = "密码不能为空")
    private String password;
    @Length(max = 20,message = "真实名字最长不能超过20")
    @NotBlank(message = "真实名字不能为空")
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private int sex;
    private int locked;
}
