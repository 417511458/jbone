package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.util.List;

@Data
public class DictionaryGroupDO {
    private int id;
    private String code;
    private String name;
    private List<DictionaryItemDO> items;
}
