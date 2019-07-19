package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.api.TagApi;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tagCloudCollector")
public class TagCloudCollector implements IDataCollector {

    @Autowired
    private TagApi tagApi;

    private String DATA_KEY = "tagCloud";


    @Override
    public void collect(DataCollectorContext context) {
        Result<List<TagDO>> result = tagApi.findTagCloud(context.getSiteId());
        if(result != null && result.isSuccess()){
            context.addAttribute(DATA_KEY,result.getData());
        }
    }
}
