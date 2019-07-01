package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.common.dataobject.search.SiteSearchDO;
import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.core.converter.SiteConverter;
import cn.jbone.cms.core.dao.entity.Site;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.SiteRepository;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.ObjectNotFoundException;
import cn.jbone.common.utils.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private SiteConverter siteConverter;

    @Autowired
    private ArticleRepository articleRepository;

    public SiteDO getRootSiteByDomain(String domain){
        Site site = siteRepository.findByDomainAndEnable(domain, BooleanEnum.TRUE.getCode());
        if(site.getPid() > 0){
            site = siteRepository.getOne(site.getPid());
        }
        return siteConverter.toSiteDO(site);
    }

    public void delete(Integer id){
        if(!siteRepository.existsById(id)){
            throw new ObjectNotFoundException("站点不存在");
        }
        Site site = siteRepository.getOne(id);
        site.setEnable(-1);
        siteRepository.save(site);
    }

    public void addOrUpdate(SiteDO siteDO){
        Site site = siteConverter.toSite(siteDO);
        siteRepository.save(site);
    }

    public SiteDO getById(Integer id){
        if(!siteRepository.existsById(id)){
            throw new ObjectNotFoundException("站点不存在");
        }
        return siteConverter.toSiteDO(siteRepository.getOne(id));
    }

    /**
     * 通用查询
     * @return
     */
    public PagedResponseDO<SiteDO> commonRequest(SiteSearchDO siteSearchDO){
        PagedResponseDO<SiteDO> responseDO = new PagedResponseDO<>();

        Sort sort = SpecificationUtils.buildSort(siteSearchDO.getSorts());
        PageRequest pageRequest = PageRequest.of(siteSearchDO.getPageNumber()-1, siteSearchDO.getPageSize(), sort);

        Page<Site> sitePage =  siteRepository.findAll(new SiteCommonRequestSpecification(siteSearchDO),pageRequest);

        responseDO.setTotal(sitePage.getTotalElements());
        responseDO.setPageNum(sitePage.getNumber()+1);
        responseDO.setPageSize(sitePage.getSize());
        responseDO.setDatas(siteConverter.toSiteDOs(sitePage.getContent()));
        return responseDO;

    }

    /**
     *
     */
    private class SiteCommonRequestSpecification implements Specification<Site> {
        private SiteSearchDO siteSearchDO;
        public SiteCommonRequestSpecification(SiteSearchDO siteSearchDO){
            this.siteSearchDO = siteSearchDO;
        }

        @Override
        public Predicate toPredicate(Root<Site> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(siteSearchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.isNotBlank(siteSearchDO.getName())){
                Path<String> name = root.get("name");
                predicates.add(criteriaBuilder.like(name,"%" + siteSearchDO.getName() + "%"));
            }

            if(StringUtils.isNotBlank(siteSearchDO.getDomain())){
                Path<String> name = root.get("domain");
                predicates.add(criteriaBuilder.like(name,"%" + siteSearchDO.getDomain() + "%"));
            }

            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, siteSearchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }
}
