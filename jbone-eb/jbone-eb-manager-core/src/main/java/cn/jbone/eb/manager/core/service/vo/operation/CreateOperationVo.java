package cn.jbone.eb.manager.core.service.vo.operation;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;


@Data
public class CreateOperationVo {
    @Min(value = 1,message = "运营位类型不能为空")
    private int type;
    @Length(max = 200,message = "运营位标题最长不能超过200")
    @NotBlank(message = "运营位标题不能为空")
    private String title;
    @Length(max = 200,message = "运营图URL最长不能超过200")
    @NotBlank(message = "运营图URL不能为空")
    private String imgUrl;
    @Length(max = 200,message = "运营跳转链接最长不能超过200")
    @NotBlank(message = "运营跳转链接不能为空")
    private String linkUrl;
    @Length(max = 500,message = "运营描述最长不能超过500")
    private String description;
    @Min(value = 0,message = "运营排序号不能为空,且不能小于0")
    private int sortNum;
    private int status;
    private String operator;
}
