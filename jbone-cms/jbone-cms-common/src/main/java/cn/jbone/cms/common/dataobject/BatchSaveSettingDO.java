package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BatchSaveSettingDO implements Serializable {
    private List<SettingsDO> settingsList;
    private Integer siteId;
}
