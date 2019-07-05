package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class SiteSettingsDO {
    private Long id;

    /**
     * 站点ID
     */
    private Integer siteId;

    /**
     * 设置名，如title
     */
    private String name;

    /**
     * 值
     */
    private String value;

    private Integer creator;
}
