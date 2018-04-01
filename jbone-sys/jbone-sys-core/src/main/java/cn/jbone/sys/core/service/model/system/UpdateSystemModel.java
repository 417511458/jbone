package cn.jbone.sys.core.service.model.system;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class UpdateSystemModel extends CreateSystemModel {
    @Min(value = 1,message = "id不能为空,且必须大于0")
    private int id;
}
