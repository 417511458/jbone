package com.majunwei.jbone.sys.service;

import com.majunwei.jbone.sys.api.model.Menu;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.dao.domain.*;
import com.majunwei.jbone.sys.dao.repository.RbacMenuRepository;
import com.majunwei.jbone.sys.dao.repository.RbacSystemRepository;
import com.majunwei.jbone.sys.dao.repository.RbacUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        List<RbacMenuEntity> menuEntityList = userEntity.getMenus();
        List<RbacPermissionEntity> permissionEntityList = userEntity.getPermissions();


        if(roleEntityList != null && !roleEntityList.isEmpty()){
            for (RbacRoleEntity roleEntity: roleEntityList){
                List<RbacMenuEntity> menuEntities = roleEntity.getMenus();
                if(menuEntities != null && !menuEntities.isEmpty()){
                    menuEntityList.addAll(menuEntities);
                }

                //角色对应的权限
                List<RbacPermissionEntity> permissionEntities = roleEntity.getPermissions();

                if(permissionEntities != null && !permissionEntities.isEmpty()){
                    permissionEntityList.addAll(permissionEntities);
                }
            }
        }

        // 清洗所有非一级菜单，以及非当前系统的菜单
        RbacSystemEntity systemEntity = systemRepository.findByName(serverName);
        if(menuEntityList != null && !menuEntityList.isEmpty()){
            for (RbacMenuEntity menuEntity:menuEntityList){
                if(menuEntity.getPid() == 0 && systemEntity.getId() == menuEntity.getSystemId() && !isContains(correctMenuList,menuEntity)){
                    correctMenuList.add(menuEntity);
                }
            }
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

    private boolean isContains(List<RbacMenuEntity> menuEntities,RbacMenuEntity menuEntity){
        for (RbacMenuEntity rbacMenuEntity : menuEntities){
            if(menuEntity.getId() == rbacMenuEntity.getId()){
                return true;
            }
        }
        return false;
    }



}
