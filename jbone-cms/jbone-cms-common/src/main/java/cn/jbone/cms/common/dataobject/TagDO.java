package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class TagDO {
    /**
     * 标签ID
     */
    private Long id;

    /**
     * 标签名称
     */
    private String name;
}
