package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.SiteSettingConstant;
import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.core.converter.ArticleConverter;
import cn.jbone.cms.core.dao.entity.*;
import cn.jbone.cms.core.dao.repository.*;
import cn.jbone.cms.core.validator.ContentValidator;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.utils.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.Map;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleDataRepository articleDataRepository;

    @Autowired
    private ArticleConverter articleConverter;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ContentValidator contentValidator;

    @Autowired
    private SiteSettingsService siteSettingsService;

    Logger logger = LoggerFactory.getLogger(getClass());

    public ArticleResponseDO addOrUpdateArticle(ArticleRequestDO articleRequestDO){
        checkParam(articleRequestDO);

        contentValidator.checkPermition(articleRequestDO.getCreator(),articleRequestDO.getSiteId());

        checkLimit(articleRequestDO);

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

    /**
     * 校验限额
     */
    private void checkLimit(ArticleRequestDO articleRequestDO){
        if(articleRequestDO.getId() == null || articleRequestDO.getId() <= 0){
            Map<String, String> settingMap = siteSettingsService.getSettingsMap(articleRequestDO.getSiteId());
            if(!settingMap.containsKey(SiteSettingConstant.LIMIT_ARTICLE_COUNT)){
                throw new JboneException("本站禁止添加文章，如有疑问请联系管理员.");
            }
            Long limitCount = Long.parseLong(settingMap.get(SiteSettingConstant.LIMIT_ARTICLE_COUNT));
            if(limitCount <= 0){
                logger.warn("超出文章限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "篇文章");
            }
            long currentCount = articleRepository.countBySiteId(articleRequestDO.getSiteId());
            if(currentCount >= limitCount){
                logger.warn("超出文章限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "篇文章");
            }
        }
    }


    public ArticleResponseDO getArticle(Long id){
        Article article = articleRepository.getOne(id);
        if(article == null){
            throw new JboneException("文章不存在");
        }

        ArticleResponseDO articleResponseDO = articleConverter.toArticleDO(article, ArticleFiledConfigDO.buildAll());

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

    public void deleteArticle(Long id,Integer userId){
        if(!articleRepository.existsById(id)){
            throw new JboneException("文章不存在");
        }
        Article article = articleRepository.getOne(id);

        contentValidator.checkPermition(userId,article.getSiteId());

        //逻辑删除
        article.setStatus(StatusEnum.DELETE);
        articleRepository.save(article);
    }

    public void flushDeleteArticle(Long id,Integer userId){
        if(!articleRepository.existsById(id)){
            throw new JboneException("文章不存在.");
        }
        Article article = articleRepository.getOne(id);
        contentValidator.checkPermition(userId,article.getSiteId());
        articleRepository.delete(article);
    }


    /**
     * 通用查询
     * @param articleSearchDO
     * @return
     */
    public PagedResponseDO<ArticleResponseDO> commonRequest(ArticleSearchDO articleSearchDO){

        Sort sort = SpecificationUtils.buildSort(articleSearchDO.getSorts());

        //默认添加时间倒叙
        if(sort.isUnsorted()){
            sort = Sort.by(Sort.Order.desc("addTime"));
        }
        PageRequest pageRequest = PageRequest.of(articleSearchDO.getPageNumber()-1, articleSearchDO.getPageSize(),sort);
        Page<Article> articlePage =  articleRepository.findAll(new ArticleCommonRequestSpecification(articleSearchDO),pageRequest);

        PagedResponseDO<ArticleResponseDO> responseDO = new PagedResponseDO<>();
        responseDO.setTotal(articlePage.getTotalElements());
        responseDO.setPageNum(articlePage.getNumber() + 1);
        responseDO.setPageSize(articlePage.getSize());
        responseDO.setDatas(articleConverter.toArticleDOs(articlePage.getContent(), articleSearchDO.getConfig()));

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
        private ArticleSearchDO articleSearchDO;
        public ArticleCommonRequestSpecification(ArticleSearchDO articleSearchDO){
            this.articleSearchDO = articleSearchDO;
        }

        @Override
        public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(articleSearchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();

            if(articleSearchDO.getId() != null && articleSearchDO.getId() > 0){
                Path<Long> id = root.get("id");
                predicates.add(criteriaBuilder.equal(id, articleSearchDO.getId()));
            }

            if(articleSearchDO.getSiteId() != null && articleSearchDO.getSiteId() > 0){
                Path<Integer> siteId = root.get("siteId");
                predicates.add(criteriaBuilder.equal(siteId, articleSearchDO.getSiteId()));
            }

            if(StringUtils.isNotBlank(articleSearchDO.getTitle())){
                Path<String> title = root.get("title");
                predicates.add(criteriaBuilder.like(title,"%" + articleSearchDO.getTitle() + "%"));
            }


            if(StringUtils.isNotBlank(articleSearchDO.getKeywords())){
                Path<String> keyWords = root.get("keywords");
                predicates.add(criteriaBuilder.like(keyWords,"%" + articleSearchDO.getKeywords() + "%"));
            }


            if(StringUtils.isNotBlank(articleSearchDO.getDescription())){
                Path<String> description = root.get("description");
                predicates.add(criteriaBuilder.like(description,"%" + articleSearchDO.getDescription() + "%"));
            }

            if(!CollectionUtils.isEmpty(articleSearchDO.getStatusList())){
                CriteriaBuilder.In<StatusEnum> statusList =  criteriaBuilder.in(root.get("status"));
                for (StatusEnum statusEnum : articleSearchDO.getStatusList()){
                    statusList.value(statusEnum);
                }
                predicates.add(statusList);
            }

            if(articleSearchDO.getCategoryId() != null && articleSearchDO.getCategoryId() > 0){
                Join<Article,Category> categoryJoin = root.join("category",JoinType.INNER);
                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), articleSearchDO.getCategoryId()));
            }


            if(articleSearchDO.getTemplateId() != null && articleSearchDO.getTemplateId() > 0){
                Join<Template,Template> templateJoin = root.join("template",JoinType.INNER);
                predicates.add(criteriaBuilder.equal(templateJoin.get("id"), articleSearchDO.getTemplateId()));
            }

            if(!CollectionUtils.isEmpty(articleSearchDO.getCategoryIds())){
                List<Category> categories = categoryRepository.findByIdIn(articleSearchDO.getCategoryIds());
                if(!CollectionUtils.isEmpty(categories)){
                    Join<Article,Category> categoryJoin = root.join("category",JoinType.INNER);
                    predicates.add(categoryJoin.in(categories));
                }
            }

            // tag的In查询
            if(!CollectionUtils.isEmpty(articleSearchDO.getTagIds())){
                List<Tag> tagList = tagRepository.findByIdIn(articleSearchDO.getTagIds());
                if(!CollectionUtils.isEmpty(tagList)){
                    Join<Article,Tag> articleTagListJoin = root.join("tags",JoinType.INNER);
                    predicates.add(articleTagListJoin.in(tagList));
                }
            }

            if(articleSearchDO.getCreator() != null && articleSearchDO.getCreator() > 0){
                Path<Integer> creator = root.get("creator");
                predicates.add(criteriaBuilder.equal(creator, articleSearchDO.getCreator()));
            }

            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, articleSearchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }
}


