package cn.jbone.sys.core.service.model.role;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class AssignMenuModel {
    @Min(value = 1,message = "角色ID必须大于0")
    private int roleId;
    private int systemId;
    private int[] roleMenu;

}
