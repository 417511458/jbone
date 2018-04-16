package cn.jbone.eb.manager.core.service.vo.operation;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class UpdateOperationVo extends CreateOperationVo {
    @Min(value = 1,message = "id不能为空,且必须大于0")
    private int id;
}
