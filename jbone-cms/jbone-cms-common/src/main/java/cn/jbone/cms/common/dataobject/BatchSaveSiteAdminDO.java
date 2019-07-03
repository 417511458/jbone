package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.util.List;

@Data
public class BatchSaveSiteAdminDO {
    private Integer siteId;
    private List<Integer> userIds;
}
