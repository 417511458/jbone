package cn.jbone.cms.common.dataobject.search;

import cn.jbone.common.dataobject.SearchListDO;
import lombok.Data;

import java.util.List;

@Data
public class DictionaryGroupSearchDO extends SearchListDO {
    private String code;
    private String name;
}
