package cn.jbone.sys.core.service;

import cn.jbone.sys.core.dao.domain.RbacMenuEntity;
import cn.jbone.sys.core.dao.domain.RbacPermissionEntity;
import cn.jbone.sys.core.dao.domain.RbacRoleEntity;
import cn.jbone.sys.core.dao.repository.RbacMenuRepository;
import cn.jbone.sys.core.dao.repository.RbacPermissionRepository;
import cn.jbone.sys.core.dao.repository.RbacRoleRepository;
import cn.jbone.sys.core.service.model.common.AssignPermissionModel;
import cn.jbone.sys.core.service.model.role.AssignMenuModel;
import cn.jbone.sys.core.service.model.role.CreateRoleModel;
import cn.jbone.sys.core.service.model.role.SimpleRoleModel;
import cn.jbone.sys.core.service.model.role.UpdateRoleModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class RoleService {

    @Autowired
    private RbacRoleRepository roleRepository;
    @Autowired
    private RbacMenuRepository menuRepository;
    @Autowired
    private RbacPermissionRepository permissionRepository;

    public void save(CreateRoleModel roleModel){
        RbacRoleEntity roleEntity = new RbacRoleEntity();
        BeanUtils.copyProperties(roleModel,roleEntity);
        roleRepository.save(roleEntity);
    }

    public void update(UpdateRoleModel roleModel){
        RbacRoleEntity roleEntity = roleRepository.findOne(roleModel.getId());
        BeanUtils.copyProperties(roleModel,roleEntity);
        roleRepository.save(roleEntity);
    }

    public void delete(String ids){
        String[] idArray =  ids.split(",");
        for (String id:idArray){
            if(StringUtils.isBlank(id)){
                continue;
            }
            roleRepository.delete(Integer.parseInt(id));
        }
    }

    public RbacRoleEntity get(int id){
        return roleRepository.getOne(id);
    }

    public List<RbacRoleEntity> findAll(){
        return roleRepository.findAll();
    }



    public Page<RbacRoleEntity> findPage(String condition, Pageable pageable){
        return roleRepository.findAll(new RoleSpecification(condition),pageable);
    }

    /**
     * 分配菜单
     * @param menuModel
     */
    public void assignMenu(AssignMenuModel menuModel){
        //首先删除该系统下所有菜单
        RbacRoleEntity roleEntity = roleRepository.findOne(menuModel.getRoleId());
        List<RbacMenuEntity> menuEntities = roleEntity.getMenus();
        if(menuEntities != null && !menuEntities.isEmpty()){
            for (int i = 0;i < menuEntities.size(); i++){
                RbacMenuEntity menuEntity = menuEntities.get(i);
                if(menuEntity.getSystemId() == menuModel.getSystemId()){
                    menuEntities.remove(menuEntity);
                    i--;
                }
            }
        }

        //然后插入菜单
        if(menuModel.getRoleMenu() != null && menuModel.getRoleMenu().length > 0){
            List<RbacMenuEntity> newMenus = menuRepository.findByIdIn(menuModel.getRoleMenu());
            menuEntities.addAll(newMenus);
        }
    }

    /**
     * 分配权限
     * @param permissionModel
     */
    public void assignPermission(AssignPermissionModel permissionModel){
        //首先删除该系统下所有菜单
        RbacRoleEntity roleEntity = roleRepository.findOne(permissionModel.getId());
        List<RbacPermissionEntity> permissionEntities = roleEntity.getPermissions();
        if(permissionEntities != null && !permissionEntities.isEmpty()){
            for (int i = 0;i < permissionEntities.size(); i++){
                RbacPermissionEntity permissionEntity = permissionEntities.get(i);
                if(permissionEntity.getSystemId() == permissionModel.getSystemId()){
                    permissionEntities.remove(permissionEntity);
                    i--;
                }
            }
        }

        //然后插入权限
        if(permissionModel.getPermission() != null && permissionModel.getPermission().length > 0){
            List<RbacPermissionEntity> newPermissions = permissionRepository.findByIdIn(permissionModel.getPermission());
            permissionEntities.addAll(newPermissions);
        }
    }

    private class RoleSpecification implements Specification<RbacRoleEntity> {
        private String condition;
        public RoleSpecification(String condition){
            this.condition = condition;
        }
        @Override
        public Predicate toPredicate(Root<RbacRoleEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(StringUtils.isBlank(condition)){
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("name");
            Path<String> title = root.get("title");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name,"%" + condition + "%"),criteriaBuilder.like(title,"%" + condition + "%"));
            return predicate;
        }
    }

    public List<SimpleRoleModel> getSimpleModels(List<RbacRoleEntity> roleEntities){
        List<SimpleRoleModel> result = new ArrayList<>();
        if(roleEntities == null || roleEntities.isEmpty()){
            return result;
        }

        for (RbacRoleEntity roleEntity : roleEntities){
            SimpleRoleModel roleModel = new SimpleRoleModel();
            BeanUtils.copyProperties(roleEntity,roleModel);
            result.add(roleModel);
        }
        return result;
    }

    public SimpleRoleModel getSimpleModel(RbacRoleEntity roleEntity){
        SimpleRoleModel roleModel = new SimpleRoleModel();
        BeanUtils.copyProperties(roleEntity,roleModel);
        return roleModel;
    }
}
