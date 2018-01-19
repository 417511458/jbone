package com.majunwei.jbone.sys.service;

import com.majunwei.jbone.sys.dao.domain.*;
import com.majunwei.jbone.sys.dao.repository.RbacMenuRepository;
import com.majunwei.jbone.sys.dao.repository.RbacSystemRepository;
import com.majunwei.jbone.sys.dao.repository.RbacUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    RbacUserRepository userRepository;

    @Autowired
    RbacSystemRepository systemRepository;

    @Autowired
    RbacMenuRepository menuRepository;



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
        List<RbacMenuEntity> menuEntityList = userEntity.getMenus();
        List<RbacPermissionEntity> permissionEntityList = userEntity.getPermissions();

        if(menuEntityList == null){
            menuEntityList = new ArrayList<RbacMenuEntity>();
        }

        if(permissionEntityList == null){
            permissionEntityList = new ArrayList<RbacPermissionEntity>();
        }

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
                if(menuEntity.getPid() != 0 || systemEntity.getId() != menuEntity.getSystemId()){
                    menuEntityList.remove(menuEntity);
                }
            }
        }

        // 清洗本系统之外的权限
        if(permissionEntityList != null && !permissionEntityList.isEmpty()){
            for (RbacPermissionEntity permissionEntity : permissionEntityList){
                if(permissionEntity.getSystemId() != systemEntity.getId()){
                    permissionEntityList.remove(permissionEntity);
                }
            }
        }

        userEntity.setMenus(menuEntityList);
        userEntity.setPermissions(permissionEntityList);

        return userEntity;
    }



}
