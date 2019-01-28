package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.common.dataobject.ArticleRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
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
    public Result<ArticleResponseDO> addOrUpdate(ArticleRequestDO articleRequestDO) {
        ArticleResponseDO articleResponseDO = null;
        try {
            articleResponseDO = articleService.addOrUpdateArticle(articleRequestDO);
        }catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }

        return Result.wrapSuccess(articleResponseDO);
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            articleService.deleteArticle(id);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<ArticleResponseDO> get(Long id) {
        ArticleResponseDO articleResponseDO = null;
        try {
            articleResponseDO = articleService.getArticle(id);
        } catch (ObjectNotFoundException e){
            return Result.wrap404Error("article is not found");
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(articleResponseDO);
    }

    @Override
    public Result<PagedResponseDO<ArticleResponseDO>> commonRequest(ArticleCommonRequestDO articleCommonRequestDO) {
        PagedResponseDO<ArticleResponseDO> pagedResponseDO = null;
        try {
            pagedResponseDO = articleService.commonRequest(articleCommonRequestDO);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(pagedResponseDO);
    }
}
