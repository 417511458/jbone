package cn.jbone.cms.core.service;

import cn.jbone.cms.common.module.article.ArticleRequestDO;
import cn.jbone.cms.common.module.article.ArticleResponseDO;
import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

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
}
