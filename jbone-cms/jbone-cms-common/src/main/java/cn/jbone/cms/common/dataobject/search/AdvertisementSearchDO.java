package cn.jbone.cms.common.dataobject.search;

import cn.jbone.common.dataobject.SearchListDO;
import lombok.Data;

@Data
public class AdvertisementSearchDO extends SearchListDO {
    private String location;
    private String type;
    private String name;
    private int enable;
    private Long id;
}
