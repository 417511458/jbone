package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.core.converter.ArticleConverter;
import cn.jbone.cms.core.dao.entity.*;
import cn.jbone.cms.core.dao.repository.ArticleDataRepository;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.TagRepository;
import cn.jbone.common.exception.ObjectNotFoundException;
import cn.jbone.common.utils.SpecificationUtils;
import cn.jbone.sys.api.UserApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleDataRepository articleDataRepository;

    @Autowired
    private ArticleConverter articleConverter;

    @Autowired
    private UserApi userApi;
    @Autowired
    private TagRepository tagRepository;

    public ArticleResponseDO addOrUpdateArticle(ArticleRequestDO articleRequestDO){
        checkParam(articleRequestDO);
        Article article = articleConverter.toArticle(articleRequestDO);
        article = articleRepository.save(article);

        ArticleData articleData = articleConverter.toArticleData(article,articleRequestDO.getArticleData());
        articleDataRepository.save(articleData);

        return getArticle(article.getId());
    }

    private void checkParam(ArticleRequestDO articleRequestDO){
        Assert.notNull(articleRequestDO.getTitle(),"文章标题不能为空.");
        Assert.notNull(articleRequestDO.getArticleData(),"文章内容不能为空.");
        Assert.notNull(articleRequestDO.getArticleData().getContent(),"文章内容不能为空.");
    }


    public ArticleResponseDO getArticle(Long id){
        Article article = articleRepository.getOne(id);
        if(article == null){
            throw new ObjectNotFoundException("article is not found");
        }

        ArticleResponseDO articleResponseDO = articleConverter.toArticleDO(article);

        return articleResponseDO;
    }

    /**
     * 增加文章点击量
     * @param id
     */
    public void hits(Long id){
        if(id == null || id < 0){
            return ;
        }
        Article article = articleRepository.getOne(id);
        if(article != null){
            article.setHits(article.getHits() + 1);
            articleRepository.save(article);
        }
    }

    public void deleteArticle(Long id){
        if(!articleRepository.existsById(id)){
            throw new ObjectNotFoundException("文章不存在.");
        }
        Article article = articleRepository.getOne(id);
        //逻辑删除
        article.setStatus(StatusEnum.DELETE);
        articleRepository.save(article);
    }

    public void flushDeleteArticle(Long id){
        if(!articleRepository.existsById(id)){
            throw new ObjectNotFoundException("文章不存在.");
        }
        articleRepository.deleteById(id);
    }


    /**
     * 通用查询
     * @param articleCommonRequestDO
     * @return
     */
    public PagedResponseDO<ArticleResponseDO> commonRequest(ArticleCommonRequestDO articleCommonRequestDO){


        PageRequest pageRequest = null;
        if(StringUtils.isNotBlank(articleCommonRequestDO.getSortName())){
            pageRequest = PageRequest.of(articleCommonRequestDO.getPageNumber()-1,articleCommonRequestDO.getPageSize(), Sort.Direction.fromString(articleCommonRequestDO.getSortOrder()),articleCommonRequestDO.getSortName());
        }else {
            pageRequest = PageRequest.of(articleCommonRequestDO.getPageNumber()-1,articleCommonRequestDO.getPageSize());
        }

        Page<Article> articlePage =  articleRepository.findAll(new ArticleCommonRequestSpecification(articleCommonRequestDO),pageRequest);

        PagedResponseDO<ArticleResponseDO> responseDO = new PagedResponseDO<>();
        responseDO.setTotal(articlePage.getTotalElements());
        responseDO.setPageNum(articlePage.getNumber() + 1);
        responseDO.setPageSize(articlePage.getSize());
        responseDO.setDatas(articleConverter.toArticleDOs(articlePage.getContent()));

        return responseDO;

    }



    /**
     * 用户查询声明，用于模糊查询分页
     * 1、标题模糊搜索
     * 2、关键词模糊搜索
     * 3、简介模糊搜索
     * 4、按栏目搜索
     * 5、按状态搜索（如果未传，则搜索全部）
     * 6、按标签ID搜索
     * 7、按模版搜索
     * 8、按作者搜索
     */
    private class ArticleCommonRequestSpecification implements Specification<Article> {
        private ArticleCommonRequestDO articleCommonRequestDO;
        public ArticleCommonRequestSpecification(ArticleCommonRequestDO articleCommonRequestDO){
            this.articleCommonRequestDO = articleCommonRequestDO;
        }

        @Override
        public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(articleCommonRequestDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.isNotBlank(articleCommonRequestDO.getTitle())){
                Path<String> title = root.get("title");
                predicates.add(criteriaBuilder.like(title,"%" + articleCommonRequestDO.getTitle() + "%"));
            }


            if(StringUtils.isNotBlank(articleCommonRequestDO.getKeywords())){
                Path<String> keyWords = root.get("keywords");
                predicates.add(criteriaBuilder.like(keyWords,"%" + articleCommonRequestDO.getKeywords() + "%"));
            }


            if(StringUtils.isNotBlank(articleCommonRequestDO.getDescription())){
                Path<String> description = root.get("description");
                predicates.add(criteriaBuilder.like(description,"%" + articleCommonRequestDO.getDescription() + "%"));
            }

            if(!CollectionUtils.isEmpty(articleCommonRequestDO.getStatusList())){
                CriteriaBuilder.In<StatusEnum> statusList =  criteriaBuilder.in(root.get("status"));
                for (StatusEnum statusEnum : articleCommonRequestDO.getStatusList()){
                    statusList.value(statusEnum);
                }
                predicates.add(statusList);
            }

            if(articleCommonRequestDO.getCategoryId() != null && articleCommonRequestDO.getCategoryId() > 0){
                Join<Article,Category> categoryJoin = root.join("category",JoinType.INNER);
                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"),articleCommonRequestDO.getCategoryId()));
            }

            if(articleCommonRequestDO.getTemplateId() != null && articleCommonRequestDO.getTemplateId() > 0){
                Join<Template,Template> templateJoin = root.join("template",JoinType.INNER);
                predicates.add(criteriaBuilder.equal(templateJoin.get("id"),articleCommonRequestDO.getTemplateId()));
            }


            // tag的In查询
            if(!CollectionUtils.isEmpty(articleCommonRequestDO.getTagIds())){
                List<Tag> tagList = tagRepository.findByIdIn(articleCommonRequestDO.getTagIds());
                if(!CollectionUtils.isEmpty(tagList)){
                    Join<Article,Tag> articleTagListJoin = root.join("tags",JoinType.INNER);
                    predicates.add(articleTagListJoin.in(tagList));
                }
            }

            if(articleCommonRequestDO.getCreator() != null && articleCommonRequestDO.getCreator() > 0){
                Path<Integer> creator = root.get("creator");
                predicates.add(criteriaBuilder.equal(creator,articleCommonRequestDO.getCreator()));
            }

            //条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder,articleCommonRequestDO.getCondition());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }
}


