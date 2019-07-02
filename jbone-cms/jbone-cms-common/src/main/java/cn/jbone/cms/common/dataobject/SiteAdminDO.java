package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class SiteAdminDO {
    private Long id;

    /**
     * 站点ID
     */
    private Integer siteId;

    /**
     * 用户ID
     */
    private Integer userId;
}
