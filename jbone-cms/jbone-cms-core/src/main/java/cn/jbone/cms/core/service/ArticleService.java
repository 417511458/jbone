package cn.jbone.cms.core.service;

import cn.jbone.cms.common.module.article.ArticleRequest;
import cn.jbone.cms.common.module.article.ArticleResponse;
import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleResponse addOrUpdateArticle(ArticleRequest articleRequest){
        Article article = new Article();
        article.setAllowComment(articleRequest.getAllowComment());
//        article.setArticleData();
//        article.setCategory();
        article.setDescription(articleRequest.getDescription());
        article.setFrontCover(articleRequest.getFrontCover());
        article.setHits(articleRequest.getHits());
        article.setId(articleRequest.getId());
        article.setKeywords(article.getKeywords());
        article.setStatus(articleRequest.getStatus());
//        article.setTags();
        article.setTitle(articleRequest.getTitle());
//        article.setTemplate();
//        article.setCreator();
        return null;
    }
}
