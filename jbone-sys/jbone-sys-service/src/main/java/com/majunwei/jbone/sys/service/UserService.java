package com.majunwei.jbone.sys.service;

import com.majunwei.jbone.sys.api.model.Menu;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.dao.domain.*;
import com.majunwei.jbone.sys.dao.repository.RbacMenuRepository;
import com.majunwei.jbone.sys.dao.repository.RbacSystemRepository;
import com.majunwei.jbone.sys.dao.repository.RbacUserRepository;
import com.majunwei.jbone.sys.service.model.user.CreateUserModel;
import com.majunwei.jbone.sys.service.model.user.UpdateUserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.*;

@Service
public class UserService {
    @Autowired
    RbacUserRepository userRepository;

    @Autowired
    RbacSystemRepository systemRepository;

    @Autowired
    RbacMenuRepository menuRepository;


    public UserModel getUserDetailByNameAndServerName(String username, String serverName) {
        RbacUserEntity userEntity = this.findByUserNameAndServerName(username,serverName);
        UserModel userModel = new UserModel();
        Set<String> permissions = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        List<RbacPermissionEntity> permissionEntities =  userEntity.getPermissions();
        List<RbacRoleEntity> roleEntities = userEntity.getRoles();
        if(permissionEntities != null && !permissionEntities.isEmpty()){
            for(RbacPermissionEntity permissionEntity : permissionEntities){
                permissions.add(permissionEntity.getPermissionValue());
            }
        }

        if(roleEntities != null && !roleEntities.isEmpty()){
            for(RbacRoleEntity roleEntity : roleEntities){
                roles.add(roleEntity.getName());
            }
        }

        BeanUtils.copyProperties(userEntity,userModel);
        userModel.setPermissions(permissions);
        userModel.setRoles(roles);


        //解析前用户拥有的菜单
        List<Menu> menuList = new ArrayList<>();

        //解析菜单
        List<RbacMenuEntity> menuEntityList = userEntity.getMenus();
        if(menuEntityList != null && !menuEntityList.isEmpty()){
            for (RbacMenuEntity menuEntity:menuEntityList){
                Menu menu = new Menu();
                BeanUtils.copyProperties(menuEntity,menu);
                if(isContains(menuList,menuEntity)){
                    continue;
                }
                List<Menu> childMenuList = new ArrayList<Menu>();
                List<RbacMenuEntity> childMenus = menuEntity.getChildMenus();
                if(childMenus != null && !childMenus.isEmpty()){
                    for (RbacMenuEntity childMenuEntity:childMenus){
                        Menu childMenu = new Menu();
                        BeanUtils.copyProperties(childMenuEntity,childMenu);
                        childMenuList.add(childMenu);
                    }
                }
                Collections.sort(childMenuList);
                menu.setChildMenus(childMenuList);
                menuList.add(menu);
            }
        }
        Collections.sort(menuList);
        userModel.setMenus(menuList);

        return userModel;
    }


    public RbacUserEntity findByUserName(String username){
        return userRepository.findByUsername(username);
    }


    /**
     * 根据用户名和系统名，获取用户详情
     * @param username
     * @param serverName
     * @return
     */
    public RbacUserEntity findByUserNameAndServerName(String username,String serverName){
        RbacUserEntity userEntity = userRepository.findByUsername(username);
        List<RbacRoleEntity> roleEntityList = userEntity.getRoles();

        List<RbacMenuEntity> correctMenuList = new ArrayList<>();
        List<RbacPermissionEntity> correctPermissionList = new ArrayList<>();
        List<RbacPermissionEntity> permissionEntityList = userEntity.getPermissions();


        if(roleEntityList != null && !roleEntityList.isEmpty()){
            for (RbacRoleEntity roleEntity: roleEntityList){
                //角色对应的权限
                List<RbacPermissionEntity> permissionEntities = roleEntity.getPermissions();

                if(permissionEntities != null && !permissionEntities.isEmpty()){
                    permissionEntityList.addAll(permissionEntities);
                }
            }
        }

        // 清洗所有非一级菜单，以及非当前系统的菜单
        RbacSystemEntity systemEntity = systemRepository.findByName(serverName);

        List<RbacUserEntity> userCondition = new ArrayList<>();
        userCondition.add(userEntity);

        //获取用户和对应角色拥有的系统菜单
        List<RbacMenuEntity> roleMenus = menuRepository.findDistinctByRolesInAndPidAndSystemIdOrderByOrders(userEntity.getRoles(),0,systemEntity.getId());
        List<RbacMenuEntity> userMenus = menuRepository.findDistinctByUsersInAndPidAndSystemIdOrderByOrders(userCondition,0,systemEntity.getId());
        correctMenuList.addAll(roleMenus);
        correctMenuList.addAll(userMenus);

        for (RbacMenuEntity menuEntity : correctMenuList){
            List<RbacMenuEntity> childRoleMenus = menuRepository.findDistinctByRolesInAndPidAndSystemIdOrderByOrders(userEntity.getRoles(),menuEntity.getId(),systemEntity.getId());
            List<RbacMenuEntity> childUserMenus = menuRepository.findDistinctByUsersInAndPidAndSystemIdOrderByOrders(userCondition,menuEntity.getId(),systemEntity.getId());
            List<RbacMenuEntity> childMenus = new ArrayList<>();
            childMenus.addAll(childRoleMenus);
            childMenus.addAll(childUserMenus);
            menuEntity.setChildMenus(childMenus);
        }

        // 清洗本系统之外的权限
        if(permissionEntityList != null && !permissionEntityList.isEmpty()){
            for (RbacPermissionEntity permissionEntity : permissionEntityList){
                if(permissionEntity.getSystemId() == systemEntity.getId()){
                    correctPermissionList.add(permissionEntity);
                }
            }
        }

        userEntity.setMenus(correctMenuList);
        userEntity.setPermissions(correctPermissionList);

        return userEntity;
    }

    private boolean isContains(List<Menu> menuEntities,RbacMenuEntity menuEntity){
        for (Menu rbacMenuEntity : menuEntities){
            if(menuEntity.getId() == rbacMenuEntity.getId()){
                return true;
            }
        }
        return false;
    }

    public void save(CreateUserModel userModel){
        RbacUserEntity userEntity = new RbacUserEntity();
        BeanUtils.copyProperties(userModel,userEntity);
        userRepository.save(userEntity);
    }

    public void update(UpdateUserModel userModel){
        RbacUserEntity userEntity = userRepository.findOne(userModel.getId());
        BeanUtils.copyProperties(userModel,userEntity);
        userRepository.save(userEntity);
    }

    public void delete(String ids){
        String[] idArray =  ids.split(",");
        for (String id:idArray){
            if(StringUtils.isBlank(id)){
                continue;
            }
            userRepository.delete(Integer.parseInt(id));
        }
    }

    public RbacUserEntity findById(int id){
        return userRepository.getOne(id);
    }

    public Page<RbacUserEntity> findPage(String condition, Pageable pageable){
        return userRepository.findAll(new UserSpecification(condition),pageable);
    }


    private class UserSpecification implements Specification<RbacUserEntity> {
        private String condition;
        public UserSpecification(String condition){
            this.condition = condition;
        }
        @Override
        public Predicate toPredicate(Root<RbacUserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(StringUtils.isBlank(condition)){
                return criteriaQuery.getRestriction();
            }
            Path<String> username = root.get("username");
            Path<String> realname = root.get("realname");
            Path<String> phone = root.get("phone");
            Path<String> email = root.get("email");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(username,"%" + condition + "%"),criteriaBuilder.like(realname,"%" + condition + "%"),criteriaBuilder.like(phone,"%" + condition + "%"),criteriaBuilder.like(email,"%" + condition + "%"));
            return predicate;
        }
    }

}
