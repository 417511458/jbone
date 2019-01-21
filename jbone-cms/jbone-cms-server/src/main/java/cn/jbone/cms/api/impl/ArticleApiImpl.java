package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.article.ArticleApi;
import cn.jbone.cms.common.module.article.ArticleRequestDO;
import cn.jbone.cms.common.module.article.ArticleResponseDO;
import cn.jbone.cms.core.service.ArticleService;
import cn.jbone.common.exception.ObjectNotFoundException;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleApiImpl implements ArticleApi {

    @Autowired
    private ArticleService articleService;

    @Override
    public Result<ArticleResponseDO> addArticle(ArticleRequestDO articleRequestDO) {
        return null;
    }

    @Override
    public Result<ArticleResponseDO> updateArticle(ArticleRequestDO articleRequestDO) {
        return null;
    }

    @Override
    public Result<Void> deleteArticle(Long id) {
        return null;
    }

    @Override
    public Result<ArticleResponseDO> getArticle(Long id) {
        ArticleResponseDO articleResponseDO = null;
        try {
            articleResponseDO = articleService.getArticle(id);
        } catch (ObjectNotFoundException e){
            return Result.wrap404Error("article is not found");
        }
        catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return new Result(articleResponseDO);
    }
}
