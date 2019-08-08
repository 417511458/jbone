package cn.jbone.cms.common.dataobject.search;

import cn.jbone.common.dataobject.SearchListDO;
import lombok.Data;

@Data
public class SiteSettingsSearchDO extends SearchListDO {
    /**
     * 站点ID
     */
    private Integer siteId;

    /**
     * 内容key
     */
    private String name;
}
