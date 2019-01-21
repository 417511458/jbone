package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.module.article.ArticleDataDO;
import cn.jbone.cms.common.module.article.ArticleResponseDO;
import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.entity.ArticleData;
import cn.jbone.sys.common.UserResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleConverter {

    @Autowired
    private CategoryConverter categoryConverter;
    @Autowired
    private TagConverter tagConverter;
    @Autowired
    private TemplateConverter templateConverter;

    public ArticleResponseDO toArticleDO(Article article, UserResponseDO user){
        if(article == null){
            return null;
        }

        ArticleResponseDO articleResponseDO = new ArticleResponseDO();
        articleResponseDO.setAllowComment(article.getAllowComment());
        articleResponseDO.setAuthor(user);
        articleResponseDO.setArticleData(toArticleDataDO(article.getArticleData()));
        articleResponseDO.setCategory(categoryConverter.toCategoryDO(article.getCategory()));
        articleResponseDO.setCreator(article.getCreator());
        articleResponseDO.setDescription(article.getDescription());
        articleResponseDO.setFrontCover(article.getFrontCover());
        articleResponseDO.setHits(article.getHits());
        articleResponseDO.setKeywords(article.getKeywords());
        articleResponseDO.setId(article.getId());
        articleResponseDO.setStatus(article.getStatus());
        articleResponseDO.setTags(tagConverter.toTagDOs(article.getTags()));
        articleResponseDO.setTemplate(templateConverter.toTemplateDO(article.getTemplate()));
        articleResponseDO.setTitle(article.getTitle());
        articleResponseDO.setAddTime(article.getAddTime().getTime());
        articleResponseDO.setUpdateTime(article.getUpdateTime().getTime());

        return articleResponseDO;
    }

    public ArticleDataDO toArticleDataDO(ArticleData articleData){
        if(articleData == null){
            return null;
        }

        ArticleDataDO articleDataDO = new ArticleDataDO();
        articleDataDO.setContent(articleData.getContent());
        articleDataDO.setTableOfContents(articleData.getTableOfContents());

        return articleDataDO;
    }
}
