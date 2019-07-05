package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BatchSaveSiteSettingDO implements Serializable {
    private List<SiteSettingsDO> settingsList;
    private Integer siteId;
    private Integer userId;

}
