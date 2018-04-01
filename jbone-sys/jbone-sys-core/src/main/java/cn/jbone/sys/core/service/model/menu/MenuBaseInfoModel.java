package cn.jbone.sys.core.service.model.menu;

import lombok.Data;

@Data
public class MenuBaseInfoModel {
    private int id;
    private Integer systemId;
    private int pid;
    private String name;
    private String url;
    private String target;
    private String icon;
    private long orders;
}
