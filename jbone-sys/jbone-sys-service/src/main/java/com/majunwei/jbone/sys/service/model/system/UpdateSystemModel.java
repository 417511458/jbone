package com.majunwei.jbone.sys.service.model.system;

import javax.validation.constraints.Min;

public class UpdateSystemModel extends CreateSystemModel {
    @Min(value = 1,message = "id不能为空,且必须大于0")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
