package com.majunwei.jbone.sys.service.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class TreeMenuModel {
    private int id;
    private Integer systemId;
    private int pid;
    private String name;
    private String url;
    private String target;
    private String icon;
    private Long orders;
    private List<TreeMenuModel> children;
}
