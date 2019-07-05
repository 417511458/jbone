package cn.jbone.cms.common.dataobject.search;

import cn.jbone.common.dataobject.SearchListDO;
import lombok.Data;

@Data
public class TagSearchDO extends SearchListDO {
    private String name;
    private boolean includeArticleCount = false;
    private Integer siteId;
}
