package cn.jbone.sys.core.service.model.permission;

import lombok.Data;

@Data
public class PermissionCreateModel {
    private int systemId;
    private String name;
    private int type;
    private String permissionValue;
    private int menuId;
}
