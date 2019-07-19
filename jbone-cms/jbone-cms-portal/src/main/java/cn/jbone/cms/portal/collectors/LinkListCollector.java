package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.api.LinkApi;
import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 友情链接数据收集器
 */
@Repository("linkListCollector")
public class LinkListCollector implements IDataCollector {

    private String DATA_KEY = "links";

    @Autowired
    private LinkApi linkApi;

    @Override
    public void collect(DataCollectorContext context) {
        Result<List<LinkDO>> result = linkApi.getAll(context.getSiteId());
        if(result != null && result.isSuccess()){
            context.addAttribute(DATA_KEY, result.getData());
        }

    }
}
