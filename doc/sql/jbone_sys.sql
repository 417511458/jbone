/*
 Navicat MySQL Data Transfer

 Source Server         : jbone_sys
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : 121.42.174.77
 Source Database       : jbone_sys

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 09/10/2018 10:50:58 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `github_user`
-- ----------------------------
DROP TABLE IF EXISTS `github_user`;
CREATE TABLE `github_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `github_id` bigint(20) NOT NULL COMMENT 'Github用户ID',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT 'RBAC用户ID',
  `login` varchar(100) NOT NULL COMMENT 'Github帐号',
  `node_id` varchar(100) DEFAULT NULL COMMENT 'Github nodeId',
  `avatar_url` varchar(200) DEFAULT NULL COMMENT 'Github头像',
  `html_url` varchar(200) DEFAULT NULL COMMENT 'Github主页',
  `name` varchar(100) DEFAULT NULL COMMENT 'Github名字',
  `company` varchar(100) DEFAULT NULL COMMENT 'Github单位',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `blog` varchar(100) DEFAULT NULL COMMENT '博客',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `github_user`
-- ----------------------------
BEGIN;
INSERT INTO `github_user` VALUES ('2', '11766855', '60', '417511458', null, 'https://avatars3.githubusercontent.com/u/11766855?v=4', 'https://github.com/417511458', 'Small', '微店', null, '', '2018-08-16 19:15:41', '2018-08-16 19:15:41', '0');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_menu`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_menu`;
CREATE TABLE `rbac_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限类型(-1:减权限,1:增权限)',
  `system_id` int(10) DEFAULT NULL,
  `pid` int(10) DEFAULT NULL COMMENT '父菜单',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `url` varchar(100) DEFAULT NULL COMMENT '链接',
  `target` varchar(10) DEFAULT NULL COMMENT '打开方式',
  `orders` bigint(20) DEFAULT NULL COMMENT '排序',
  `add_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
--  Records of `rbac_menu`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_menu` VALUES ('9', '3', null, '', '', null, null, '2018-02-02 15:42:18', '2018-02-02 15:42:18', '0', null), ('10', '3', '0', 'ffeeedf', 'asdf', null, '111', '2018-02-02 15:49:57', '2018-02-02 15:49:57', '0', null), ('13', '3', '10', 'wef', 'wef', null, '1111', '2018-02-02 15:57:11', '2018-02-02 15:57:11', '0', null), ('14', '3', '10', 'rrr', '阿斯顿发', null, '111', '2018-02-02 16:19:35', '2018-02-02 16:19:35', '0', null), ('19', '2', '0', '23', '123', null, '123', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('21', '3', '0', '权限管理', '#', null, '1', '2018-02-02 16:46:59', '2018-02-04 22:02:28', '23', null), ('22', '3', '21', '用户管理', '/user/index', null, '3', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('23', '3', '21', '角色管理', '/role/index', null, '2', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('24', '3', '21', '菜单管理', '/menu/index', null, '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('25', '3', '0', '系统管理', '#', null, '1', '2018-02-02 16:46:59', '2018-02-04 22:02:28', '23', null), ('26', '3', '25', '系统管理', '/system/index', null, '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('27', '3', '10', 'eef', 'ef', null, '111', '2018-02-06 11:39:48', '2018-02-06 11:39:48', '0', null), ('29', '3', '10', '1211111', '124444', null, '112111', '2018-02-06 11:40:01', '2018-02-08 15:05:52', '1', null), ('30', '3', '21', '权限管理', '/permission/index', null, '0', '2018-02-06 16:53:24', '2018-02-06 16:53:24', '0', null), ('31', '3', '21', '组织机构', '/organization/index', null, '0', '2018-02-23 16:15:06', '2018-02-23 16:15:06', '0', null), ('32', '20', '0', '标签管理', '#', null, '1', '2018-03-25 18:46:40', '2018-03-25 18:46:40', '0', null), ('35', '20', '32', '标签详情管理', '/tag/index', null, '1', '2018-03-25 19:00:11', '2018-03-25 19:00:11', '0', null), ('36', '21', '0', '电商门户管理', '/portal', null, '100', '2018-04-03 19:55:48', '2018-04-03 19:55:48', '0', null), ('37', '21', '0', '后台类目管理', '/backCategory', null, '90', '2018-04-03 19:56:15', '2018-04-03 19:56:15', '0', null), ('38', '21', '0', '前台类目管理', '/frontCategory', null, '80', '2018-04-03 19:56:40', '2018-04-03 19:56:40', '0', null), ('39', '21', '36', '配置电商首页', '/portal/index', null, '100', '2018-04-03 19:58:03', '2018-04-03 19:58:03', '0', null), ('41', '21', '36', '运营位管理', '/operation/index', null, '90', '2018-04-03 19:59:46', '2018-04-07 15:08:01', '1', null), ('42', '21', '37', '后台类目管理', '/backCategory/manage', null, '100', '2018-04-03 20:00:29', '2018-04-03 20:02:32', '1', null), ('43', '21', '37', '属性管理', '/property/manage', null, '80', '2018-04-03 20:01:44', '2018-04-03 20:01:44', '0', null), ('44', '21', '37', '属性值管理', '/publicValue/manage', null, '70', '2018-04-03 20:02:17', '2018-04-03 20:02:17', '0', null), ('45', '21', '38', '前台类目管理', '/frontCategory/manage', null, '100', '2018-04-03 20:03:24', '2018-04-03 20:03:24', '0', null), ('46', '22', '0', '流程定义管理', '/processDefinition', null, '100', '2018-04-21 16:15:02', '2018-04-21 16:15:02', '0', null), ('47', '22', '0', '流程实例管理', '/processInstance', null, '90', '2018-04-21 16:15:25', '2018-04-21 16:16:14', '1', null), ('48', '22', '0', '任务管理', '/task', null, '80', '2018-04-21 16:15:54', '2018-04-21 16:20:00', '1', null), ('49', '22', '46', '流程设计', '/processDefinition/design', null, '100', '2018-04-21 16:18:12', '2018-04-21 16:18:12', '0', null), ('50', '22', '46', '流程定义管理', '/processDefinition/index', null, '90', '2018-04-21 16:18:46', '2018-04-21 16:18:46', '0', null), ('51', '22', '0', '审核权限管理', '/security', null, '50', '2018-04-21 16:19:44', '2018-04-21 16:19:44', '0', null), ('52', '22', '47', '流程实例管理', '/processInstance/index', null, '100', '2018-04-21 16:21:19', '2018-04-21 16:21:19', '0', null), ('53', '22', '48', '任务管理', '/task/instance', null, '100', '2018-04-21 16:22:03', '2018-04-21 16:22:03', '0', null), ('54', '22', '51', '审核用户管理', '/security/user/index', null, '100', '2018-04-21 16:22:47', '2018-04-21 16:22:47', '0', null), ('55', '22', '51', '审核用户组管理', '/security/group/index', null, '90', '2018-04-21 16:23:33', '2018-04-21 16:23:33', '0', null), ('56', '18', '0', '系统设置', '#', null, '0', '2018-08-09 17:41:12', '2018-08-09 17:41:12', '0', null), ('57', '18', '0', '素材管理', '#', null, '0', '2018-08-09 17:41:23', '2018-08-09 17:41:23', '0', null), ('59', '18', '56', '工作台', '/index/workbench', null, '0', '2018-08-09 17:42:47', '2018-08-09 17:42:47', '0', null), ('60', '18', '57', '图文管理', '/material/document/document', null, '0', '2018-08-09 17:43:25', '2018-08-09 17:43:25', '0', null);
COMMIT;

-- ----------------------------
--  Table structure for `rbac_organization`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_organization`;
CREATE TABLE `rbac_organization` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pid` int(10) DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) DEFAULT NULL COMMENT '组织名称',
  `description` varchar(1000) DEFAULT NULL COMMENT '组织描述',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='组织';

-- ----------------------------
--  Records of `rbac_organization`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_organization` VALUES ('1', null, '总部', '北京总部', null, null, '0'), ('4', null, '河北分部', '河北石家庄', null, null, '0'), ('5', null, '河南分部', '河南郑州', null, null, '0'), ('6', null, '湖北分部', '湖北武汉', null, null, '0'), ('7', null, '湖南分部', '湖南长沙', null, null, '0'), ('12', '0', 'jbone集团', '', '2018-02-23 16:23:44', '2018-02-23 16:23:44', '0'), ('13', '12', '北京分部', '', '2018-02-23 16:24:00', '2018-02-23 16:24:00', '0'), ('14', '12', '山东分部', '', '2018-02-23 16:24:16', '2018-02-23 16:24:16', '0');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_permission`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_permission`;
CREATE TABLE `rbac_permission` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `system_id` int(10) unsigned NOT NULL COMMENT '所属系统',
  `menu_id` int(10) DEFAULT NULL COMMENT '所属上级',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型(1:功能,2:菜单,3:按钮)',
  `permission_value` varchar(50) DEFAULT NULL COMMENT '权限值',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8mb4 COMMENT='权限';

-- ----------------------------
--  Records of `rbac_permission`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_permission` VALUES ('93', '3', '0', '系统管理-查看', '1', 'sys:system:read', '2018-02-08 16:35:15', '2018-02-08 16:37:48', '1'), ('94', '3', '0', '系统管理-新增', '1', 'sys:system:create', '2018-02-08 16:36:08', '2018-02-08 16:38:11', '1'), ('95', '3', '26', '系统管理-修改', '1', 'sys:system:update', '2018-02-08 16:36:52', '2018-02-08 16:36:52', '0'), ('96', '3', '0', '系统管理-删除', '1', 'sys:system:delete', '2018-02-08 16:39:14', '2018-02-08 16:39:30', '1'), ('97', '3', '0', '菜单管理-查看', '1', 'sys:menu:read', '2018-02-22 21:47:08', '2018-02-22 21:47:08', '0'), ('98', '3', '0', '菜单管理-新增', '1', 'sys:menu:create', '2018-02-22 21:47:39', '2018-02-22 21:47:50', '1'), ('99', '3', '0', '菜单管理-修改', '1', 'sys:menu:update', '2018-02-22 21:48:21', '2018-02-22 21:48:29', '1'), ('100', '3', '0', '菜单管理-删除', '1', 'sys:menu:delete', '2018-02-22 21:48:58', '2018-02-22 21:48:58', '0'), ('101', '3', '30', '权限管理-查看', '1', 'sys:permission:read', '2018-02-22 21:49:57', '2018-02-22 22:32:12', '1'), ('102', '3', '30', '权限管理-新增', '1', 'sys:permission:create', '2018-02-22 21:50:14', '2018-02-22 22:32:02', '1'), ('103', '3', '30', '权限管理-修改', '1', 'sys:permission:update', '2018-02-22 21:50:31', '2018-02-22 22:31:50', '1'), ('104', '3', '30', '权限管理-删除', '1', 'sys:permission:delete', '2018-02-22 21:50:59', '2018-02-22 22:31:32', '1'), ('105', '3', '0', '角色管理-查看', '1', 'sys:role:read', '2018-02-22 21:51:48', '2018-02-22 21:51:48', '0'), ('106', '3', '0', '角色管理-新增', '1', 'sys:role:create', '2018-02-22 21:52:12', '2018-02-22 21:52:22', '1'), ('107', '3', '0', '角色管理-修改', '1', 'sys:role:update', '2018-02-22 21:57:26', '2018-02-22 21:57:26', '0'), ('108', '3', '23', '角色管理-删除', '1', 'sys:role:delete', '2018-02-22 21:57:54', '2018-02-22 22:34:59', '1'), ('109', '3', '0', '角色管理-分配菜单', '1', 'sys:role:assignMenu', '2018-02-22 21:58:17', '2018-02-22 21:58:17', '0'), ('110', '3', '0', '角色管理-分配权限', '1', 'sys:role:assignPermission', '2018-02-22 21:58:40', '2018-02-22 21:58:40', '0'), ('111', '3', '0', '用户管理-查看', '1', 'sys:user:read', '2018-02-22 21:59:09', '2018-02-22 21:59:09', '0'), ('112', '3', '0', '用户管理-新增', '1', 'sys:user:create', '2018-02-22 21:59:25', '2018-02-22 21:59:25', '0'), ('113', '3', '0', '用户管理-修改', '1', 'sys:user:update', '2018-02-22 21:59:40', '2018-02-22 21:59:40', '0'), ('114', '3', '0', '用户管理-删除', '1', 'sys:user:delete', '2018-02-22 21:59:57', '2018-02-22 21:59:57', '0'), ('115', '3', '0', '用户管理-分配角色', '1', 'sys:user:assignRole', '2018-02-22 22:00:18', '2018-02-22 22:00:18', '0'), ('116', '3', '0', '用户管理-分配菜单', '1', 'sys:user:assignMenu', '2018-02-22 22:00:42', '2018-02-22 22:00:42', '0'), ('117', '3', '0', '用户管理-分配权限', '1', 'sys:user:assignPermission', '2018-02-22 22:01:03', '2018-02-22 22:01:03', '0'), ('118', '3', '31', '组织机构-查看', '1', 'sys:organization:read', '2018-02-23 16:15:49', '2018-02-23 16:15:49', '0'), ('119', '3', '31', '组织机构-新增', '1', 'sys:organization:create', '2018-02-23 16:16:24', '2018-02-23 16:16:24', '0'), ('120', '3', '31', '组织机构-修改', '1', 'sys:organization:update', '2018-02-23 16:16:51', '2018-02-23 16:16:51', '0'), ('121', '3', '31', '组织机构-删除', '1', 'sys:organization:delete', '2018-02-23 16:17:13', '2018-02-23 16:17:13', '0'), ('122', '3', '22', '用户管理-分配组织机构', '1', 'sys:user:assignOrganization', '2018-02-23 16:52:41', '2018-02-23 16:52:41', '0'), ('123', '3', '0', '用户管理-修改密码', '1', 'sys:user:modifyPassword', '2018-03-24 14:25:24', '2018-03-24 14:26:36', '1'), ('124', '20', '0', '标签管理-新增', '1', 'tag:tagInfo:create', '2018-03-24 21:50:47', '2018-03-24 21:50:47', '0'), ('125', '20', '0', '标签系统-修改', '1', 'tag:tagInfo:update', '2018-03-24 21:51:38', '2018-03-24 21:51:38', '0'), ('126', '20', '0', '标签管理-查看', '1', 'tag:tagInfo:read', '2018-03-24 21:52:09', '2018-03-24 21:52:09', '0'), ('127', '20', '0', '标签管理-删除', '1', 'tag:tagInfo:delete', '2018-03-24 21:52:47', '2018-03-24 21:52:47', '0'), ('129', '21', '41', '电商运营位管理-查看', '1', 'eb:manager:operation:read', '2018-04-07 15:09:35', '2018-04-07 15:09:35', '0'), ('130', '21', '41', '电商运营位管理-新增', '1', 'eb:manager:operation:create', '2018-04-12 16:48:06', '2018-04-12 16:48:06', '0'), ('131', '21', '41', '电商运营位管理-修改', '1', 'eb:manager:operation:update', '2018-04-12 16:48:53', '2018-04-12 16:48:53', '0'), ('132', '21', '41', '电商运营位管理-删除', '1', 'eb:manager:operation:delete', '2018-04-12 16:49:28', '2018-04-12 16:49:28', '0');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_role`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role`;
CREATE TABLE `rbac_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `title` varchar(20) DEFAULT NULL COMMENT '角色标题',
  `description` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  `orders` bigint(20) NOT NULL COMMENT '排序',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT='角色';

-- ----------------------------
--  Records of `rbac_role`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_role` VALUES ('8', 'sso', '单点登录', '单点登录', '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '1'), ('9', 'serverAdministrator', '服务管理员', '服务管理员', '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '1'), ('10', 'admin', '系统管理员', '系统管理员', '1', '2018-02-02 16:46:59', '2018-03-25 19:01:06', '10'), ('11', 'casAdministrator', '单点登录认证管理员', '用于管理CASManager', '0', '2018-03-30 11:18:27', '2018-03-30 11:19:05', '1'), ('12', 'ebAdministrator', '电商平台管理员', '电商平台管理员', '0', '2018-04-03 20:04:05', '2018-04-12 16:49:57', '3'), ('13', 'bpmAdministrator', '工作流管理员', '工作流管理员', '0', '2018-04-21 16:24:23', '2018-04-21 16:24:37', '1'), ('16', 'www', 'www', 'www', '0', '2018-06-02 06:49:25', '2018-06-02 06:49:25', '0'), ('19', 'guest', '访客', '三方账户首次登录，默认赋予的角色', '0', '2018-06-02 21:51:03', '2018-08-16 17:16:15', '5'), ('20', '4444', '4444', '44eeee', '0', '2018-06-02 22:04:58', '2018-06-02 22:10:17', '1');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_menu`;
CREATE TABLE `rbac_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8 COMMENT='角色-菜单关系表';

-- ----------------------------
--  Records of `rbac_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_role_menu` VALUES ('46', '10', '21'), ('47', '10', '22'), ('48', '10', '23'), ('49', '10', '24'), ('50', '10', '25'), ('51', '10', '26'), ('52', '10', '30'), ('53', '10', '31'), ('54', '10', '32'), ('55', '10', '35'), ('56', '12', '36'), ('57', '12', '37'), ('58', '12', '38'), ('59', '12', '39'), ('60', '12', '41'), ('61', '12', '42'), ('62', '12', '43'), ('63', '12', '44'), ('64', '12', '45'), ('65', '13', '46'), ('66', '13', '47'), ('67', '13', '48'), ('68', '13', '49'), ('69', '13', '50'), ('70', '13', '51'), ('71', '13', '52'), ('72', '13', '53'), ('73', '13', '54'), ('74', '13', '55'), ('95', '19', '21'), ('96', '19', '22'), ('97', '19', '23'), ('98', '19', '24'), ('99', '19', '25'), ('100', '19', '26'), ('101', '19', '30'), ('102', '19', '31'), ('103', '19', '32'), ('104', '19', '35');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_role_permission`;
CREATE TABLE `rbac_role_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色编号',
  `permission_id` int(10) unsigned NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=175 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';

-- ----------------------------
--  Records of `rbac_role_permission`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_role_permission` VALUES ('130', '10', '93'), ('131', '10', '94'), ('132', '10', '95'), ('133', '10', '96'), ('134', '10', '97'), ('135', '10', '98'), ('136', '10', '99'), ('137', '10', '100'), ('138', '10', '101'), ('139', '10', '102'), ('140', '10', '103'), ('141', '10', '104'), ('142', '10', '105'), ('143', '10', '106'), ('144', '10', '107'), ('145', '10', '108'), ('146', '10', '109'), ('147', '10', '110'), ('148', '10', '111'), ('149', '10', '112'), ('150', '10', '113'), ('151', '10', '114'), ('152', '10', '115'), ('153', '10', '116'), ('154', '10', '117'), ('155', '10', '118'), ('156', '10', '119'), ('157', '10', '120'), ('158', '10', '121'), ('159', '10', '122'), ('160', '10', '123'), ('162', '12', '129'), ('163', '12', '130'), ('164', '12', '131'), ('165', '12', '132'), ('170', '19', '93'), ('171', '19', '97'), ('172', '19', '105'), ('173', '19', '111'), ('174', '19', '126');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_system`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_system`;
CREATE TABLE `rbac_system` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `basepath` varchar(100) DEFAULT NULL COMMENT '根目录',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态(-1:黑名单,1:正常)',
  `name` varchar(20) DEFAULT NULL COMMENT '系统名称',
  `title` varchar(20) DEFAULT NULL COMMENT '系统标题',
  `description` varchar(300) DEFAULT NULL COMMENT '系统描述',
  `orders` bigint(20) DEFAULT NULL COMMENT '排序',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `service_registered` int(11) DEFAULT '1' COMMENT '是否注册为CAS服务',
  `service_cas_filter` varchar(200) DEFAULT NULL COMMENT '服务CAS过滤器路径，对应CAS的service_id',
  `service_theme_server` varchar(200) DEFAULT NULL COMMENT '主题皮肤服务，用于加载服务',
  `service_id` int(10) DEFAULT '0' COMMENT '服务ID',
  `service_description` varchar(500) DEFAULT NULL COMMENT '服务描述',
  `service_evaluation_order` int(11) DEFAULT '0' COMMENT '服务皮肤加载权重',
  `service_name` varchar(50) DEFAULT NULL COMMENT '服务名称',
  `service_theme_path` varchar(45) DEFAULT NULL COMMENT '服务皮肤路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='系统';

-- ----------------------------
--  Records of `rbac_system`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_system` VALUES ('2', 'http://jbone-sm-admin.majunwei:10002/jbone-sm-admin', '1', 'jbone-sm-admin', '服务管理系统', '服务管理系统', '2', null, null, '0', '1', 'http://jbone-sm-admin.majunwei.com:10002/cas111', 'http://localhost:20001/Jbone-sys-server/service/getTheme', '10002', 'Jbone服务管理系统，是基于Spring Cloud、Spring Boot Admin做的服务管理，包含服务健康检查、内存分析、JVM监控、垃圾回收、环境变量等监控和管理等功能', '1', 'Jbone服务管理系统', 'jbonesmadmin1'), ('3', 'http://jbone-sys-admin.majunwei:20002', '1', 'jbone-sys-admin', '系统管理', '系统管理', '0', null, '2018-01-28 16:32:46', '1', '1', null, null, '20002', null, '1', null, null), ('17', 'test', '-1', '测试系统', '测试系统', 'ffffeeee', '0', '2018-01-28 16:14:08', '2018-09-08 14:33:37', '4', '0', null, null, '0', null, '0', null, null), ('18', 'http://jbone-wx-admin.majunwei.com:40003', '1', 'jbone-wx-admin	', '微信公众号管理平台', '统一管理微信公众号', '0', '2018-01-29 18:56:57', '2018-08-09 17:50:36', '2', '0', null, null, '0', null, '0', null, null), ('19', 'http://jbone-sm-monitor.majunwei.com:10003/', '1', 'jbone-sm-monitor', '服务监控系统', '服务监控系统', '0', '2018-02-24 18:14:55', '2018-03-24 21:37:02', '1', '0', null, null, '0', null, '0', null, null), ('20', 'http://jbone-tag-admin.majunwei.com:40002/', '1', 'jbone-tag-admin', '标签管理系统', '标签管理系统', '0', '2018-03-24 21:36:36', '2018-03-24 21:36:36', '0', '0', null, null, '0', null, '0', null, null), ('21', 'http://jbone-eb-manager.majunwei.com:50001/', '1', 'jbone-eb-manager', '电商平台后台管理', '电商平台后台管理', '0', '2018-04-03 19:54:42', '2018-04-03 19:54:42', '0', '0', null, null, '0', null, '0', null, null), ('22', 'http://jbone-bpm-admin.majunwei.com:60002/', '1', 'jbone-bpm-admin', 'BPM后台管理', 'BPM后台管理', '0', '2018-04-21 16:13:17', '2018-04-21 16:13:17', '0', '0', null, null, '0', null, '0', null, null), ('23', 'http://eop-sys-admin.majunwei.com:50002', '1', 'eop-sys-admin', 'EOP系统', 'EOP系统', '0', '2018-05-31 18:26:01', '2018-05-31 19:13:30', '2', '0', null, null, '0', null, '0', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `rbac_user`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user`;
CREATE TABLE `rbac_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(100) NOT NULL COMMENT '密码MD5(密码+盐)',
  `realname` varchar(20) DEFAULT NULL COMMENT '姓名',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `salt` varchar(20) DEFAULT NULL COMMENT '加密盐，用于加密密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
--  Records of `rbac_user`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user` VALUES ('14', 'test123', 'test', '1231111', null, '123', '123fff', '123', '1', '1', '2018-02-01 09:31:47', '2018-03-21 09:20:09', '2', null), ('24', 'jbone', '49a12ae5ed3a17e04e9837bae71da54e', '渔樵', null, 'http://majunwei.com/logo.png', '1', '417511458@qq.com', '1', '1', '2018-02-01 09:31:47', '2018-08-17 10:18:35', '30', '1521896490652'), ('25', 'test1', 'eedcca02294e4519f834984df8ec5939', 'test1', null, 'jbone666@163.com', '111', '417511458@qq.com', '1', '0', '2018-02-27 21:47:53', '2018-02-27 21:59:54', '3', null), ('28', 'salt', '97d993a9e0c5ba68c86570350c6cd7bf', '测试Salt', null, '', '', '', '1', '0', '2018-03-22 22:15:16', '2018-03-24 17:52:21', '2', '1521885141059'), ('30', 'test77', '5ebb7bad80b2250d14df6759e91487ac', '测试修改密码', null, '', '', '', '1', '0', '2018-03-24 17:01:02', '2018-06-03 16:33:02', '8', '1521987975171'), ('32', 'admin', 'f48ee23c20880b460f7bf3ef1f4a9d9d', 'testAdmin', null, '', '', '', '1', '0', '2018-05-09 04:40:57', '2018-05-09 04:44:22', '3', '1525812262119'), ('40', 'jboneeeeee', '8b5d5518c9187e46a691c596b0abb41d', 'eeeee', null, '', '', '', '1', '0', '2018-05-29 10:09:50', '2018-06-03 16:33:26', '1', '1527559789781'), ('46', 'jbone111', '85fcb53ffff84e1333a0f38dde8d01f4', '111', null, '', '', '', '1', '0', '2018-06-04 08:03:58', '2018-06-04 08:03:58', '0', '1528070638008'), ('48', 'test111', '7e7c0e57ea12ecf9bba8bb2bdc8eb12d', '111', null, '', '', '', '1', '0', '2018-06-04 15:22:34', '2018-06-04 16:37:59', '4', '1528096953590'), ('49', 'test222', '7003d4a4b7c7d3c30721d25ac3dba5fc', '123', null, '', '', '', '1', '0', '2018-06-04 16:43:09', '2018-06-04 16:43:14', '1', '1528101789052'), ('60', 'GITHUB_11766855', '342f5885f21fc3fbec51e2dc9b7bf32c', 'Small', null, 'https://avatars3.githubusercontent.com/u/11766855?v=4', null, null, '0', '0', '2018-08-16 19:15:41', '2018-08-16 19:15:41', '1', '1534418140354');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_menu`;
CREATE TABLE `rbac_user_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2527 DEFAULT CHARSET=utf8 COMMENT='用户-菜单-关系表';

-- ----------------------------
--  Records of `rbac_user_menu`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_menu` VALUES ('2519', '24', '25'), ('2520', '24', '21'), ('2521', '24', '21'), ('2522', '24', '25'), ('2523', '24', '56'), ('2524', '24', '57'), ('2525', '24', '59'), ('2526', '24', '60');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_user_organization`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_organization`;
CREATE TABLE `rbac_user_organization` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户编号',
  `organization_id` int(10) unsigned NOT NULL COMMENT '组织编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COMMENT='用户组织关联表';

-- ----------------------------
--  Records of `rbac_user_organization`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_organization` VALUES ('19', '1', '1'), ('20', '1', '4'), ('21', '1', '5'), ('22', '1', '6'), ('23', '1', '7'), ('26', '24', '12'), ('27', '24', '13'), ('28', '24', '14');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_user_permission`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_permission`;
CREATE TABLE `rbac_user_permission` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户编号',
  `permission_id` int(10) unsigned NOT NULL COMMENT '权限编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COMMENT='用户权限关联表';

-- ----------------------------
--  Records of `rbac_user_permission`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_permission` VALUES ('40', '24', '124'), ('41', '24', '125'), ('42', '24', '126'), ('43', '24', '127'), ('44', '24', '93'), ('45', '24', '96'), ('46', '24', '97'), ('47', '24', '98'), ('48', '24', '99'), ('49', '24', '100'), ('50', '40', '122');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_role`;
CREATE TABLE `rbac_user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户编号',
  `role_id` int(10) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

-- ----------------------------
--  Records of `rbac_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_role` VALUES ('4', '1', '1'), ('5', '1', '2'), ('6', '2', '1'), ('7', '2', '2'), ('49', '25', '8'), ('50', '25', '9'), ('51', '25', '10'), ('54', '28', '8'), ('55', '28', '9'), ('56', '28', '10'), ('75', '24', '8'), ('76', '24', '9'), ('77', '24', '10'), ('78', '24', '11'), ('79', '24', '12'), ('80', '24', '13'), ('81', '32', '8'), ('82', '32', '9'), ('83', '32', '10'), ('84', '32', '11'), ('85', '32', '12'), ('86', '32', '13'), ('87', '30', '8'), ('88', '30', '9'), ('89', '30', '10'), ('90', '30', '11'), ('91', '30', '12'), ('94', '49', '8'), ('96', '60', '19');
COMMIT;

-- ----------------------------
--  Table structure for `rbac_user_securityquestions`
-- ----------------------------
DROP TABLE IF EXISTS `rbac_user_securityquestions`;
CREATE TABLE `rbac_user_securityquestions` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `question` varchar(500) NOT NULL COMMENT '问题',
  `answer` varchar(500) NOT NULL COMMENT '答案',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户安全问题，用于找回密码';

-- ----------------------------
--  Records of `rbac_user_securityquestions`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_securityquestions` VALUES ('1', '24', '1', '1', '2018-05-11 17:26:24', '2018-05-11 17:26:24', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `description` varchar(100) DEFAULT NULL COMMENT '操作描述',
  `username` varchar(20) DEFAULT NULL COMMENT '操作用户',
  `start_time` bigint(20) DEFAULT NULL COMMENT '操作时间',
  `spend_time` int(11) DEFAULT NULL COMMENT '消耗时间',
  `base_path` varchar(500) DEFAULT NULL COMMENT '根路径',
  `uri` varchar(500) DEFAULT NULL COMMENT 'URI',
  `url` varchar(500) DEFAULT NULL COMMENT 'URL',
  `method` varchar(10) DEFAULT NULL COMMENT '请求类型',
  `parameter` mediumtext,
  `user_agent` varchar(500) DEFAULT NULL COMMENT '用户标识',
  `ip` varchar(30) DEFAULT NULL COMMENT 'IP地址',
  `result` mediumtext,
  `permissions` varchar(100) DEFAULT NULL COMMENT '权限值',
  PRIMARY KEY (`id`),
  KEY `log_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='操作日志';

SET FOREIGN_KEY_CHECKS = 1;
