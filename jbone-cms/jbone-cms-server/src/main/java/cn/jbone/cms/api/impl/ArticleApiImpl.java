package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.dataobject.ArticleRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.cms.core.service.ArticleService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.exception.ObjectNotFoundException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleApiImpl implements ArticleApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ArticleService articleService;

    @Override
    public Result<ArticleResponseDO> addOrUpdate(@RequestBody ArticleRequestDO articleRequestDO, @RequestHeader("userId") Integer userId) {
        ArticleResponseDO articleResponseDO = null;
        try {
            articleRequestDO.setCreator(userId);
            articleResponseDO = articleService.addOrUpdateArticle(articleRequestDO);
        }catch (JboneException e) {
            logger.warn("article addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        }catch (Exception e) {
            logger.warn("article addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }

        return Result.wrapSuccess(articleResponseDO);
    }

    @Override
    public Result<Void> delete(Long id,@RequestHeader("userId")Integer userId) {
        try {
            articleService.deleteArticle(id,userId);
        } catch (JboneException e) {
            logger.warn("article delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("article delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> flushDelete(Long id,@RequestHeader("userId")Integer userId) {
        try {
            articleService.flushDeleteArticle(id,userId);
        } catch (JboneException e) {
            logger.warn("article flushDelete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("article flushDelete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<ArticleResponseDO> get(Long id) {
        ArticleResponseDO articleResponseDO = null;
        try {
            articleResponseDO = articleService.getArticle(id);
        } catch (JboneException e){
            logger.warn("article get error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("article get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(articleResponseDO);
    }

    @Override
    public Result<Void> hits(Long id) {
        try {
            articleService.hits(id);
        } catch (JboneException e) {
            logger.warn("article hits error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("article hits error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<PagedResponseDO<ArticleResponseDO>> commonRequest(@RequestBody ArticleSearchDO articleSearchDO) {
        PagedResponseDO<ArticleResponseDO> pagedResponseDO = null;
        try {
            pagedResponseDO = articleService.commonRequest(articleSearchDO);
        } catch (JboneException e) {
            logger.warn("article commonRequest error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("article commonRequest error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(pagedResponseDO);
    }
}
