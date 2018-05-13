package cn.jbone.sys.core.service.model.organization;

import lombok.Data;

@Data
public class OrganizationBaseInfoModel {
    private int id;
    private Integer pid;
    private String name;
    private String description;
}
