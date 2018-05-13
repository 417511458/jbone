package cn.jbone.sys.core.service.model.menu;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class UpdateMenuModel extends CreateMenuModel {
    @Min(value = 1,message = "ID不能为空，且必须大于0")
    private int id;
}

