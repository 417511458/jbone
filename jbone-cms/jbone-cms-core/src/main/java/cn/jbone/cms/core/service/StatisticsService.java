package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.StatisticsDO;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import cn.jbone.cms.core.dao.repository.LinkRepository;
import cn.jbone.cms.core.dao.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private LinkRepository linkRepository;

    public StatisticsDO count(){
        StatisticsDO statisticsDO = new StatisticsDO();
        statisticsDO.setArticleCount(articleRepository.count());
        statisticsDO.setCategoryCount(categoryRepository.count());
        statisticsDO.setHitsCount(articleRepository.findHitsCount());
        statisticsDO.setLinkCount(linkRepository.count());
        statisticsDO.setSpecialCount(categoryRepository.countByType(CategoryTypeEnum.SPECIAL));
        statisticsDO.setTagCount(tagRepository.count());
        return statisticsDO;
    }

}
