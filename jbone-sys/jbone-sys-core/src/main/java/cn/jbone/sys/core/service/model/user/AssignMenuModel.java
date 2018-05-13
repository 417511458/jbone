package cn.jbone.sys.core.service.model.user;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class AssignMenuModel {
    @Min(value = 1,message = "用户ID必须大于0")
    private int userId;
    private int systemId;
    private int[] userMenu;

}
