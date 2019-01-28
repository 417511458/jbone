package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/tag")
public interface TagApi {

    @RequestMapping(value = "/getAll",method = {RequestMethod.POST})
    Result<List<TagDO>> getAll();

}
