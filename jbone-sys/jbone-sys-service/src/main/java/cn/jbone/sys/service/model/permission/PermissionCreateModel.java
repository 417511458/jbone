package cn.jbone.sys.service.model.permission;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PermissionCreateModel {
    private int systemId;
    private String name;
    private int type;
    private String permissionValue;
    private int menuId;
}
