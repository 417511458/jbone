package cn.jbone.sys.core.service;

import cn.jbone.common.exception.JboneException;
import cn.jbone.common.utils.PasswordUtils;
import cn.jbone.sys.api.dto.ThirdPartyName;
import cn.jbone.sys.api.dto.request.ChangePasswordRequestDTO;
import cn.jbone.sys.api.dto.request.GithubUserLoginRequestDTO;
import cn.jbone.sys.api.dto.request.ThirdPartyUserLoginRequestDTO;
import cn.jbone.sys.api.dto.response.MenuInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserSecurityQuestionsResponseDTO;
import cn.jbone.sys.core.dao.domain.*;
import cn.jbone.sys.core.dao.repository.*;
import cn.jbone.sys.core.service.model.common.AssignPermissionModel;
import cn.jbone.sys.core.service.model.user.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.*;

@Transactional
@Service
public class UserService {
    @Autowired
    RbacUserRepository userRepository;

    @Autowired
    RbacSystemRepository systemRepository;

    @Autowired
    RbacMenuRepository menuRepository;

    @Autowired
    RbacUserRoleRepository userRoleRepository;

    @Autowired
    RbacRoleRepository roleRepository;

    @Autowired
    RbacPermissionRepository permissionRepository;

    @Autowired
    RbacOrganizationRepository organizationRepository;

    @Autowired
    RbacUserSecurityQuestionsRepository userSecurityQuestionsRepository;

    @Autowired
    GithubUserRepository githubUserRepository;


    /**
     * 查询用户详情
     * 1、用户基本信息
     * 2、用户权限
     * 3、用户角色
     * 4、用户菜单
     * 注：如果没有传服务名，则不加载用户菜单
     * @param username 用户名
     * @param serverName 服务名
     * @return 用户详细信息
     */
    public UserInfoResponseDTO getUserDetailByNameAndServerName(String username, String serverName) {
        UserInfoResponseDTO userModel = new UserInfoResponseDTO();
        Set<String> permissions = new HashSet<String>();
        Set<String> roles = new HashSet<String>();

        RbacUserEntity userEntity = userRepository.findByUsername(username);


        //用户角色
        List<RbacRoleEntity> roleEntities = userEntity.getRoles();
        if(roleEntities != null && !roleEntities.isEmpty()){
            for(RbacRoleEntity roleEntity : roleEntities){
                roles.add(roleEntity.getName());

                //角色对应的权限
                List<RbacPermissionEntity> permissionEntities = roleEntity.getPermissions();
                if(permissionEntities != null && !permissionEntities.isEmpty()){
                    for (RbacPermissionEntity permissionEntity : permissionEntities){
                        permissions.add(permissionEntity.getPermissionValue());
                    }
                }
            }
        }

        //用户权限
        List<RbacPermissionEntity> permissionEntities =  userEntity.getPermissions();
        if(permissionEntities != null && !permissionEntities.isEmpty()){
            for(RbacPermissionEntity permissionEntity : permissionEntities){
                permissions.add(permissionEntity.getPermissionValue());
            }
        }



        BeanUtils.copyProperties(userEntity,userModel,"menus");
        userModel.setPermissions(permissions);
        userModel.setRoles(roles);


        //如果不包含服务名，则不加载菜单信息
        if(!StringUtils.isBlank(serverName)){
            //解析前用户拥有的菜单
            List<MenuInfoResponseDTO> menuList = new ArrayList<>();
            List<RbacMenuEntity> correctMenuList = new ArrayList<>();

            RbacSystemEntity systemEntity = systemRepository.findByName(serverName);
            if(systemEntity == null){
                return userModel;
            }
            List<RbacUserEntity> userCondition = new ArrayList<>();
            userCondition.add(userEntity);

            //获取用户和对应角色拥有的系统菜单
            List<RbacMenuEntity> roleMenus = menuRepository.findDistinctByRolesInAndPidAndSystemIdOrderByOrdersDesc(userEntity.getRoles(),0,systemEntity.getId());
            List<RbacMenuEntity> userMenus = menuRepository.findDistinctByUsersInAndPidAndSystemIdOrderByOrdersDesc(userCondition,0,systemEntity.getId());
            correctMenuList.addAll(roleMenus);
            correctMenuList.addAll(userMenus);

            for (RbacMenuEntity menuEntity : correctMenuList){
                MenuInfoResponseDTO menu = new MenuInfoResponseDTO();
                BeanUtils.copyProperties(menuEntity,menu);
                if(isContains(menuList,menu)){
                    continue;
                }
                List<RbacMenuEntity> childRoleMenus = menuRepository.findDistinctByRolesInAndPidAndSystemIdOrderByOrdersDesc(userEntity.getRoles(),menuEntity.getId(),systemEntity.getId());
                List<RbacMenuEntity> childUserMenus = menuRepository.findDistinctByUsersInAndPidAndSystemIdOrderByOrdersDesc(userCondition,menuEntity.getId(),systemEntity.getId());
                List<RbacMenuEntity> childMenus = new ArrayList<>();
                childMenus.addAll(childRoleMenus);
                childMenus.addAll(childUserMenus);

                if(!childMenus.isEmpty()){
                    List<MenuInfoResponseDTO> childMenuList = new ArrayList<>();
                    for (RbacMenuEntity childMenuEntity : childMenus){
                        MenuInfoResponseDTO childMenu = new MenuInfoResponseDTO();
                        BeanUtils.copyProperties(childMenuEntity,childMenu);
                        if(isContains(childMenuList,childMenu)){
                            continue;
                        }
                        childMenuList.add(childMenu);

                    }
                    Collections.sort(childMenuList);
                    menu.setChildMenus(childMenuList);
                }

                menuList.add(menu);

            }
            Collections.sort(menuList);
            userModel.setMenus(menuList);
        }

        return userModel;
    }


    /**
     * 获取用户实体
     * @param username
     * @return
     */
    public UserBaseInfoModel findByUserName(String username){
        RbacUserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            throw new JboneException("没有找到用户");
        }
        UserBaseInfoModel userBaseInfoModel = new UserBaseInfoModel();
        BeanUtils.copyProperties(userEntity,userBaseInfoModel);
        return userBaseInfoModel;
    }



    private boolean isContains(List<MenuInfoResponseDTO> menuEntities, MenuInfoResponseDTO menu){
        for (MenuInfoResponseDTO rbacMenuEntity : menuEntities){
            if(menu.getId() == rbacMenuEntity.getId()){
                return true;
            }
        }
        return false;
    }

    /**
     * 新增用户
     * @param userModel
     */
    public void save(CreateUserModel userModel){
        RbacUserEntity userEntity = new RbacUserEntity();
        BeanUtils.copyProperties(userModel,userEntity);
        //使用时间撮作为盐值
        String salt = System.currentTimeMillis() + "";
        userEntity.setSalt(salt);
        userEntity.setPassword(PasswordUtils.getMd5PasswordWithSalt(userEntity.getPassword(),salt));


        userRepository.save(userEntity);
    }

    /**
     * 更新用户
     * @param userModel
     */
    public void update(UpdateUserModel userModel){
        RbacUserEntity userEntity = userRepository.findOne(userModel.getId());
        if(userEntity == null){
            throw new JboneException("没有找到用户");
        }

        //不修改密码
        BeanUtils.copyProperties(userModel,userEntity,"password");

        userRepository.save(userEntity);
    }

    /**
     * 删除用户
     * @param ids
     */
    public void delete(String ids){
        String[] idArray =  ids.split(",");
        for (String id:idArray){
            if(StringUtils.isBlank(id)){
                continue;
            }
            userRepository.delete(Integer.parseInt(id));
        }
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    public RbacUserEntity findById(int id){
        RbacUserEntity userEntity = userRepository.findOne(id);
        if(userEntity == null){
            throw new JboneException("没有找到用户");
        }
        return userEntity;
    }

    /**
     * 分配角色
     *
     * 1、全部删除
     * 2、重新赋值
     * @param assignRoleModel
     */
    public void assignRole(AssignRoleModel assignRoleModel){
        RbacUserEntity userEntity = userRepository.findOne(assignRoleModel.getUserId());
        List<RbacRoleEntity> roleEntities = null;
        if(assignRoleModel.getUserRole() != null && assignRoleModel.getUserRole().length > 0){
            roleEntities = roleRepository.findByIdIn(assignRoleModel.getUserRole());
        }
        userEntity.setRoles(roleEntities);
    }

    /**
     * 分页查询
     * @return
     */
    public Page<RbacUserEntity> findPage(String condition,PageRequest pageRequest){
        //分页查找
        return userRepository.findAll(new UserSpecification(condition),pageRequest);
    }

    /**
     * 分配菜单
     * @param assignMenuModel
     */
    public void assignMenu(AssignMenuModel assignMenuModel){
        //首先删除用户在该系统下的所有菜单
        RbacUserEntity userEntity = this.findById(assignMenuModel.getUserId());
        List<RbacMenuEntity> menuEntities = userEntity.getMenus();
        if(menuEntities != null && !menuEntities.isEmpty()){
            for (int i = 0;i < menuEntities.size(); i++){
                RbacMenuEntity menuEntity = menuEntities.get(i);
                if(menuEntity.getSystemId() == assignMenuModel.getSystemId()){
                    menuEntities.remove(menuEntity);
                    i--;
                }
            }
        }

        //然后插入用户菜单
        if(assignMenuModel.getUserMenu() != null && assignMenuModel.getUserMenu().length > 0){
            List<RbacMenuEntity> newMenus = menuRepository.findByIdIn(assignMenuModel.getUserMenu());
            menuEntities.addAll(newMenus);
        }
    }

    /**
     * 分配权限
     * @param permissionModel
     */
    public void assignPermission(AssignPermissionModel permissionModel){
        //首先删除该系统下所有菜单
        RbacUserEntity userEntity = userRepository.findOne(permissionModel.getId());
        List<RbacPermissionEntity> permissionEntities = userEntity.getPermissions();
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

    /**
     * 分配组织机构
     */
    public void assignOrganization(AssignOrganizationModel assignOrganizationModel){
        //首先删除用户在该系统下的所有菜单
        RbacUserEntity userEntity = this.findById(assignOrganizationModel.getUserId());
        List<RbacOrganizationEntity> organizationEntities = userEntity.getOrganizations();
        organizationEntities.clear();
        //然后插入用户菜单
        if(assignOrganizationModel.getUserOrganization() != null && assignOrganizationModel.getUserOrganization().length > 0){
            List<RbacOrganizationEntity> newOganizations = organizationRepository.findByIdIn(assignOrganizationModel.getUserOrganization());
            organizationEntities.addAll(newOganizations);
        }

    }


    /**
     * 用户查询声明，用于模糊查询分页
     */
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

    public List<UserBaseInfoModel> getUserBaseInfos(List<RbacUserEntity> userEntities){
        List<UserBaseInfoModel> userBaseInfoModelList = new ArrayList<>();
        if(userEntities == null || userEntities.isEmpty()){
            return userBaseInfoModelList;
        }
        for (RbacUserEntity userEntity : userEntities){
            UserBaseInfoModel userBaseInfoModel = new UserBaseInfoModel();
            BeanUtils.copyProperties(userEntity,userBaseInfoModel);
            userBaseInfoModelList.add(userBaseInfoModel);
        }
        return userBaseInfoModelList;
    }

    /**
     * 修改密码
     * @param modifyPasswordModel
     */
    public void modifyPassword(ModifyPasswordModel modifyPasswordModel){
        RbacUserEntity userEntity = userRepository.findOne(modifyPasswordModel.getId());
        if(userEntity == null){
            throw new JboneException("没有找到用户");
        }
        //使用时间撮作为盐值
        String salt = System.currentTimeMillis() + "";
        userEntity.setSalt(salt);
        userEntity.setPassword(PasswordUtils.getMd5PasswordWithSalt(modifyPasswordModel.getPassword(),salt));
        userRepository.save(userEntity);
    }

    /**
     * 获取用户安全问题
     * @param username
     * @return
     */
    public List<UserSecurityQuestionsResponseDTO> findUserSecurityQuestions(String username){
        UserBaseInfoModel userBaseInfoModel = findByUserName(username);
        int userId = userBaseInfoModel.getId();
        List<RbacUserSecurityQuestionsEntity> list = userSecurityQuestionsRepository.findByUserId(userId);
        if(list == null || list.isEmpty()){
            return null;
        }
        List<UserSecurityQuestionsResponseDTO> responseDTOList = new ArrayList<>();
        for(RbacUserSecurityQuestionsEntity entity:list){
            UserSecurityQuestionsResponseDTO responseDTO = new UserSecurityQuestionsResponseDTO();
            BeanUtils.copyProperties(entity,responseDTO);
            responseDTOList.add(responseDTO);
        }
        return responseDTOList;
    }


    /**
     * 修改密码
     * @param changePasswordRequestDTO
     */
    public void modifyPassword(ChangePasswordRequestDTO changePasswordRequestDTO){
        RbacUserEntity userEntity = userRepository.findByUsername(changePasswordRequestDTO.getUsername());
        if(userEntity == null){
            throw new JboneException("没有找到用户");
        }
        //使用时间撮作为盐值
        String salt = System.currentTimeMillis() + "";
        userEntity.setSalt(salt);
        userEntity.setPassword(PasswordUtils.getMd5PasswordWithSalt(changePasswordRequestDTO.getPassword(),salt));
        userRepository.save(userEntity);
    }

    /**
     * 第三方登录
     * @param thirdPartyUserLoginRequestDTO
     */
    public void thirdPartyLogin(ThirdPartyUserLoginRequestDTO thirdPartyUserLoginRequestDTO){
        if(thirdPartyUserLoginRequestDTO.getThirdPartyName() == ThirdPartyName.GITHUB){
            GithubUserLoginRequestDTO requestDTO = (GithubUserLoginRequestDTO)thirdPartyUserLoginRequestDTO;
            GithubUserEntity githubUserEntity = githubUserRepository.findByGithubId(Long.parseLong(requestDTO.getId()));
            if(githubUserEntity == null){
                githubUserEntity = new GithubUserEntity();

                //如果是第一次登录，默认添加用户并赋予guest角色
                String username = ThirdPartyName.GITHUB.toString().toUpperCase() + "_" + requestDTO.getId();
                CreateUserModel createUserModel = new CreateUserModel();
                createUserModel.setAvatar(requestDTO.getAvatarUrl());
                createUserModel.setEmail(requestDTO.getEmail());
                createUserModel.setRealname(requestDTO.getName());
                createUserModel.setUsername(username);
                createUserModel.setPassword(username);
                save(createUserModel);

                RbacUserEntity userEntity = userRepository.findByUsername(username);
                List<RbacRoleEntity> roleEntities = roleRepository.findByName("guest");
                if(roleEntities != null && !roleEntities.isEmpty()){
                    userEntity.setRoles(roleEntities);
                }
                githubUserEntity.setUserId(userEntity.getId());
            }
            githubUserEntity.setAvatarUrl(requestDTO.getAvatarUrl());
            githubUserEntity.setBlog(requestDTO.getBlog());
            githubUserEntity.setCompany(requestDTO.getCompany());
            githubUserEntity.setEmail(requestDTO.getEmail());
            githubUserEntity.setGithubId(Long.parseLong(requestDTO.getId()));
            githubUserEntity.setHtmlUrl(requestDTO.getHtmlUrl());
            githubUserEntity.setLogin(requestDTO.getLogin());
            githubUserEntity.setName(requestDTO.getName());
            githubUserEntity.setNodeId(requestDTO.getNodeId());


            githubUserRepository.save(githubUserEntity);
        }

    }

}
