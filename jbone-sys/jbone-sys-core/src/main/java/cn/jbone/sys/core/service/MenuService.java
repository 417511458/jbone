package cn.jbone.sys.core.service;

import cn.jbone.sys.core.dao.domain.RbacMenuEntity;
import cn.jbone.sys.core.dao.repository.RbacMenuRepository;
import cn.jbone.sys.core.service.model.menu.CreateMenuModel;
import cn.jbone.sys.core.service.model.menu.TreeMenuModel;
import cn.jbone.sys.core.service.model.menu.UpdateMenuModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private RbacMenuRepository rbacMenuRepository;

    //获取树形菜单
    public List<TreeMenuModel> findBySystemId(int systemId){
        List<TreeMenuModel> menuModelList = getTreeMenu(systemId,null);
        return menuModelList;
    }

    private List<TreeMenuModel> getTreeMenu(int systemId,TreeMenuModel menuModel){
        int pid = 0;
        if(menuModel != null){
            pid = menuModel.getId();
        }
        List<RbacMenuEntity> menuEntityList = rbacMenuRepository.findByPidAndSystemIdOrderByOrdersDesc(pid,systemId);
        List<TreeMenuModel> menuModelList = new ArrayList<>();
        if(menuEntityList != null && !menuEntityList.isEmpty()){
            for (RbacMenuEntity menuEntity : menuEntityList){
                TreeMenuModel treeMenuModel = new TreeMenuModel();
                BeanUtils.copyProperties(menuEntity,treeMenuModel);
                menuModelList.add(treeMenuModel);
                getTreeMenu(systemId,treeMenuModel);
            }

            if (menuModel != null) {
                menuModel.setChildren(menuModelList);
            }

        }
        return menuModelList;
    }


    public TreeMenuModel get(int id){
        RbacMenuEntity menuEntity = rbacMenuRepository.getOne(id);
        TreeMenuModel menuModel = new TreeMenuModel();
        BeanUtils.copyProperties(menuEntity,menuModel);
        return menuModel;
    }

    public void add(CreateMenuModel menuModel){
        RbacMenuEntity menuEntity = new RbacMenuEntity();
        BeanUtils.copyProperties(menuModel,menuEntity);
        rbacMenuRepository.save(menuEntity);
    }

    public void delete(int id){
        RbacMenuEntity menuEntity = rbacMenuRepository.getOne(id);
        rbacMenuRepository.delete(menuEntity);
    }

    public void update(UpdateMenuModel menuModel){
        RbacMenuEntity menuEntity = rbacMenuRepository.getOne(menuModel.getId());
        BeanUtils.copyProperties(menuModel,menuEntity);
        rbacMenuRepository.save(menuEntity);
    }
}
