package cn.jbone.cms.common.dataobject;

import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.api.dto.SearchListDTO;
import lombok.Data;

/**
 * 分类请求模型
 */
@Data
public class CategoryRequestDO extends SearchListDTO {
    private String title;  //标题模糊查询
    private CategoryTypeEnum type;  //分类类型
    private StatusEnum status;
    private BooleanEnum inMenu;
    private long pid = 0l;

}
