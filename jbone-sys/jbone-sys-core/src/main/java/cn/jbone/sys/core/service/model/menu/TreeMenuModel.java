package cn.jbone.sys.core.service.model.menu;

import lombok.Data;

import java.util.List;

@Data
public class TreeMenuModel extends MenuBaseInfoModel {
    private List<TreeMenuModel> children;
}
