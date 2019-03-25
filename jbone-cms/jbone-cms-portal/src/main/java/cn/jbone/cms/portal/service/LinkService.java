package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.LinkApi;
import cn.jbone.cms.api.TagApi;
import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
    @Autowired
    private LinkApi linkApi;

    public List<LinkDO> findAll(){
        Result<List<LinkDO>> result = linkApi.getAll();
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }
}
