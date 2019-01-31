package cn.jbone.cms.common.dataobject;

import cn.jbone.common.api.dto.SearchListDTO;
import lombok.Data;

@Data
public class TagCommonRequestDO extends SearchListDTO {
    private String name;
    private boolean includeArticleCount = false;
}
