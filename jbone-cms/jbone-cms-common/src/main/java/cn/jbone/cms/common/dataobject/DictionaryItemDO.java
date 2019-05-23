package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class DictionaryItemDO {
    private int id;
    private int groupId;
    private String dictName;
    private String dictValue;
    private String dictPrompt;
    private int orders;
}
