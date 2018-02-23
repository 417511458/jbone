package com.majunwei.jbone.sys.service;

import com.majunwei.jbone.sys.dao.domain.RbacOrganizationEntity;
import com.majunwei.jbone.sys.dao.repository.RbacOrganizationRepository;
import com.majunwei.jbone.sys.service.model.organization.CreateOrganizationModel;
import com.majunwei.jbone.sys.service.model.organization.OrganizationBaseInfoModel;
import com.majunwei.jbone.sys.service.model.organization.TreeOrganizationModel;
import com.majunwei.jbone.sys.service.model.organization.UpdateOrganizationModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private RbacOrganizationRepository rbacOrganizationRepository;

    //获取树形组织结构
    public List<TreeOrganizationModel> findTreeOrganizationModel(){
        List<TreeOrganizationModel> organizationModels = getTreeOrganization(null);
        return organizationModels;
    }

    private List<TreeOrganizationModel> getTreeOrganization(TreeOrganizationModel organizationModel){
        int pid = 0;
        if(organizationModel != null){
            pid = organizationModel.getId();
        }
        List<RbacOrganizationEntity> organizationEntities = rbacOrganizationRepository.findByPid(pid);
        List<TreeOrganizationModel> organizationModels = new ArrayList<>();
        if(organizationEntities != null && !organizationEntities.isEmpty()){
            for (RbacOrganizationEntity organizationEntity : organizationEntities){
                TreeOrganizationModel treeOrganizationModel = new TreeOrganizationModel();
                BeanUtils.copyProperties(organizationEntity,treeOrganizationModel);
                organizationModels.add(treeOrganizationModel);
                getTreeOrganization(treeOrganizationModel);
            }

            if (organizationModel != null) {
                organizationModel.setChildren(organizationModels);
            }

        }
        return organizationModels;
    }


    public OrganizationBaseInfoModel get(int id){
        RbacOrganizationEntity organizationEntity = rbacOrganizationRepository.findOne(id);
        OrganizationBaseInfoModel organizationBaseInfoModel = new OrganizationBaseInfoModel();
        BeanUtils.copyProperties(organizationEntity,organizationBaseInfoModel);
        return organizationBaseInfoModel;
    }

    public void add(CreateOrganizationModel organizationModel){
        RbacOrganizationEntity organizationEntity = new RbacOrganizationEntity();
        BeanUtils.copyProperties(organizationModel,organizationEntity);
        rbacOrganizationRepository.save(organizationEntity);
    }

    public void delete(int id){
        RbacOrganizationEntity menuEntity = rbacOrganizationRepository.getOne(id);
        rbacOrganizationRepository.delete(menuEntity);
    }

    public void update(UpdateOrganizationModel organizationModel){
        RbacOrganizationEntity organizationEntity = rbacOrganizationRepository.getOne(organizationModel.getId());
        BeanUtils.copyProperties(organizationModel,organizationEntity);
        rbacOrganizationRepository.save(organizationEntity);
    }
}
