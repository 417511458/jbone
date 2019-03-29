package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.CommentApi;
import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentApi commentApi;

    public List<CommentDO> getByArticleId(Long articleId){
        if(articleId == null || articleId <= 0){
            return null;
        }

        Result<List<CommentDO>> result = commentApi.getByArticleId(articleId);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }

    public boolean addOrUpdate(CommentDO commentDO){
        Result<Void> result = commentApi.addOrUpdate(commentDO);
        if(result != null && result.isSuccess()){
            return true;
        }
        return false;
    }
}
