package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.dataobject.config.CategoryFieldConfigDO;
import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.entity.ArticleData;
import cn.jbone.cms.core.dao.entity.Tag;
import cn.jbone.cms.core.dao.repository.*;
import cn.jbone.common.rpc.Result;
import cn.jbone.common.utils.DateUtil;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleConverter {

    @Autowired
    private CategoryConverter categoryConverter;
    @Autowired
    private TagConverter tagConverter;
    @Autowired
    private TemplateConverter templateConverter;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleDataRepository articleDataRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserApi userApi;

    @Autowired
    private CommentRepository commentRepository;

    public ArticleResponseDO toArticleDO(Article article, ArticleFiledConfigDO config){
        if(article == null){
            return null;
        }

        ArticleResponseDO articleResponseDO = new ArticleResponseDO();
        articleResponseDO.setAllowComment(article.getAllowComment());

        articleResponseDO.setCreator(article.getCreator());
        articleResponseDO.setDescription(article.getDescription());
        articleResponseDO.setFrontCover(article.getFrontCover());
        articleResponseDO.setHits(article.getHits());
        articleResponseDO.setKeywords(article.getKeywords());
        articleResponseDO.setId(article.getId());
        articleResponseDO.setStatus(article.getStatus());


        articleResponseDO.setTitle(article.getTitle());
        articleResponseDO.setAddTime(article.getAddTime().getTime());
        articleResponseDO.setUpdateTime(article.getUpdateTime().getTime());
        articleResponseDO.setAddTimeText(DateUtil.formateDate(article.getAddTime(),DateUtil.DATE_FORMAT));
        articleResponseDO.setUpdateTimeText(DateUtil.formateDate(article.getUpdateTime(),DateUtil.DATE_FORMAT));
        articleResponseDO.setSiteId(article.getSiteId());
        if(config.isIncludeContent()){
            articleResponseDO.setArticleData(toArticleDataDO(article.getArticleData()));
        }

        //作者
        if(config.isIncludeAuthor()){
            UserRequestDO userRequestDO = UserRequestDO.buildSimple(article.getCreator());
            Result<UserResponseDO> responseResult =  userApi.commonRequest(userRequestDO);
            if(responseResult != null && responseResult.isSuccess()){
                articleResponseDO.setAuthor(responseResult.getData());
            }
        }

        //分类
        if(config.isIncludeCategory()){
            articleResponseDO.setCategory(categoryConverter.toCategoryDO(article.getCategory(), CategoryFieldConfigDO.build()));
        }

        //评论数
        if(config.isIncludeCommentCount()){
            articleResponseDO.setCommentCount(commentRepository.countByArticleId(article.getId()));
        }

        //模版
        if(config.isIncludeTemplate()){
            articleResponseDO.setTemplate(templateConverter.toTemplateDO(article.getTemplate()));
        }

        //标签
        if(config.isIncludeTags()){
            articleResponseDO.setTags(tagConverter.toTagDOs(article.getTags()));
        }

        List<Long> tagIds = new ArrayList<>();
        if(!CollectionUtils.isEmpty(article.getTags())){
            for (Tag tag : article.getTags()){
                tagIds.add(tag.getId());
            }
        }
        articleResponseDO.setTagIds(tagIds);

        return articleResponseDO;
    }

    public ArticleResponseDO toBaseArticleDO(Article article){
        if(article == null){
            return null;
        }

        return toArticleDO(article, ArticleFiledConfigDO.build());
    }

    public List<ArticleResponseDO> toArticleDOs(List<Article> articles, ArticleFiledConfigDO config){
        if(CollectionUtils.isEmpty(articles)){
            return null;
        }

        List<ArticleResponseDO> articleResponseDOS = new ArrayList<>();
        for (Article article : articles){
            ArticleResponseDO articleResponseDO = toArticleDO(article,config);
            if(articleResponseDO != null){
                articleResponseDOS.add(articleResponseDO);
            }
        }
        return articleResponseDOS;
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

    public ArticleData toArticleData(Article article,ArticleDataDO articleDataDO){
        if(articleDataDO == null){
            return null;
        }

        ArticleData articleData = null;
        if(article.getId() != null && article.getId() > 0){
            articleData = articleDataRepository.findByArticle(article);
        }

        if(articleData == null){
            articleData = new ArticleData();
        }

        articleData.setArticle(article);
        articleData.setContent(articleDataDO.getContent());
        articleData.setTableOfContents(articleDataDO.getTableOfContents());


        return articleData;
    }

    public Article toArticle(ArticleDO articleDO){
        if(articleDO == null){
            return null;
        }

        Article article = null;
        if(articleDO.getId() != null && articleDO.getId() > 0){
            article = articleRepository.getOne(articleDO.getId());
        }

        if(article == null){
            article = new Article();
        }

        BeanUtils.copyProperties(articleDO,article,"category","tags","template","articleData","addTime","updateTime","hits");

        article.setCategory(categoryRepository.getOne(articleDO.getCategory().getId()));
        article.setTags(tagConverter.toTagsByIds(articleDO.getTagIds()));
        article.setTemplate(templateConverter.toTemplate(articleDO.getTemplate()));
//        article.setArticleData(toArticleData(article,articleDO.getArticleData()));


        return article;
    }
}
