package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.LinkApi;
import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.cms.core.service.LinkService;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkApiImpl implements LinkApi {

    @Autowired
    private LinkService linkService;

    @Override
    public Result<Void> addOrUpdate(LinkDO linkDO) {
        return null;
    }

    @Override
    public Result<Void> delete(Long id) {
        return null;
    }

    @Override
    public Result<LinkDO> get(Long id) {
        return null;
    }

    @Override
    public Result<List<LinkDO>> getAll() {
        return null;
    }
}
