package cn.jbone.cms.core.service;

import cn.jbone.cms.common.module.article.ArticleRequestDO;
import cn.jbone.cms.common.module.article.ArticleResponseDO;
import cn.jbone.cms.core.converter.ArticleConverter;
import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.common.exception.ObjectNotFoundException;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleConverter articleConverter;

    @Autowired
    private UserApi userApi;

    public ArticleResponseDO addOrUpdateArticle(ArticleRequestDO articleRequestDO){
        Article article = new Article();
        article.setAllowComment(articleRequestDO.getAllowComment());
//        article.setArticleData();
//        article.setCategory();
        article.setDescription(articleRequestDO.getDescription());
        article.setFrontCover(articleRequestDO.getFrontCover());
        article.setHits(articleRequestDO.getHits());
        article.setId(articleRequestDO.getId());
        article.setKeywords(article.getKeywords());
        article.setStatus(articleRequestDO.getStatus());
//        article.setTags();
        article.setTitle(articleRequestDO.getTitle());
//        article.setTemplate();
//        article.setCreator();
        return null;
    }


    public ArticleResponseDO getArticle(Long id){
        Article article = articleRepository.getOne(id);
        if(article == null){
            throw new ObjectNotFoundException("article is not found");
        }

        UserResponseDO userResponseDO = null;

        UserRequestDO userRequestDO = new UserRequestDO(article.getCreator().intValue());
        Result<UserResponseDO> userResponseDOResult = userApi.commonRequest(userRequestDO);
        if(userResponseDOResult != null && userResponseDOResult.isSuccess()){
            userResponseDO = userResponseDOResult.getData();
        }

        ArticleResponseDO articleResponseDO = articleConverter.toArticleDO(article,userResponseDO);

        return articleResponseDO;
    }
}


