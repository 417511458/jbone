package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.CommentApi;
import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.cms.core.service.CommentService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentApiImpl implements CommentApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CommentService commentService;

    @Override
    public Result<List<CommentDO>> getByArticleId(Long articleId) {
        List<CommentDO> commentDOS = null;
        try {
            commentDOS = commentService.getByArticleId(articleId);
        } catch (JboneException e) {
            logger.warn("comment getByArticleId error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("comment getByArticleId error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(commentDOS);
    }

    @Override
    public Result<Void> addOrUpdate(@RequestBody CommentDO commentDO) {
        try {
            commentService.addOrUpdate(commentDO);
        } catch (JboneException e) {
            logger.warn("comment addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("comment addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }
}
