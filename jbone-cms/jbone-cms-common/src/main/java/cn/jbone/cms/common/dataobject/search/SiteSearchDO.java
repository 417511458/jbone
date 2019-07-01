package cn.jbone.cms.common.dataobject.search;

import cn.jbone.common.dataobject.SearchListDO;
import lombok.Data;

@Data
public class SiteSearchDO extends SearchListDO {
    private String name;
    private String domain;
}
