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
     * 扩展key，如title
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 提示文案
     */
    private String prompt;

    /**
     * 数据类型
     */
    private String dataType;

    private Integer creator;
}
