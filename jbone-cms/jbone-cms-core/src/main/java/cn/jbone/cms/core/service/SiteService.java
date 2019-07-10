package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.common.dataobject.search.SiteSearchDO;
import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.core.converter.SiteConverter;
import cn.jbone.cms.core.dao.entity.Site;
import cn.jbone.cms.core.dao.entity.SiteAdmin;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.SiteAdminRepository;
import cn.jbone.cms.core.dao.repository.SiteRepository;
import cn.jbone.cms.core.dao.repository.TemplateRepository;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.utils.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    private SiteAdminRepository siteAdminRepository;

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private TemplateService templateService;

    Logger logger = LoggerFactory.getLogger(getClass());

    public SiteDO getRootSiteByDomain(String domain){
        List<Site> list = siteRepository.findByDomainOrAlias1OrAlias2(domain,domain,domain);
        if(CollectionUtils.isEmpty(list)){
            return null;
        }

        Site site = null;
        for (Site tempSite : list) {
            if(tempSite.getEnable() == BooleanEnum.TRUE.getCode()){
                site = tempSite;
                break;
            }
        }
        if(site != null && site.getPid() > 0){
            site = siteRepository.getOne(site.getPid());
        }

        SiteDO siteDO = siteConverter.toSiteDO(site);
        if(siteDO.getTemplateId() > 0){
           siteDO.setTemplate(templateService.get(siteDO.getTemplateId()));
        }
        return siteDO;
    }

    public void delete(Integer id){
        if(!siteRepository.existsById(id)){
            throw new JboneException("站点不存在");
        }
        Site site = siteRepository.getOne(id);
        site.setEnable(-1);
        siteRepository.save(site);
    }

    public void addOrUpdate(SiteDO siteDO){
        try {
            Site site = siteConverter.toSite(siteDO);
            siteRepository.save(site);
        } catch (DataIntegrityViolationException e) {
            logger.warn("域名或别名已存在",e);
            throw new JboneException("域名或别名已存在");
        }
    }

    public SiteDO getById(Integer id){
        if(!siteRepository.existsById(id)){
            throw new JboneException("站点不存在");
        }
        return siteConverter.toSiteDO(siteRepository.getOne(id));
    }

    public List<SiteDO> getByUserId(Integer userId){
        if(userId == null || userId <= 0){
            throw new JboneException("参数错误");
        }

        List<SiteAdmin> siteAdmins = siteAdminRepository.findByUserId(userId);
        if(!CollectionUtils.isEmpty(siteAdmins)){
            List<Integer> siteIds = new ArrayList<>();
            for (SiteAdmin siteAdmin:siteAdmins) {
                siteIds.add(siteAdmin.getSiteId());
            }
            List<Site> sites = siteRepository.findByIdInAndPid(siteIds,0);
            return siteConverter.toSiteDOs(sites);
        }
        return null;

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
