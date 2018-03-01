package cn.jbone.sys.service.model.user;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class UpdateUserModel extends CreateUserModel {
    @Min(value = 1,message = "id不能为空,且必须大于0")
    private int id;
}
