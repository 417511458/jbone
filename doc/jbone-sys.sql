/*
 Navicat MySQL Data Transfer

 Source Server         : jbone_root
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : 121.42.174.77
 Source Database       : jbone_sys

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 03/22/2018 22:21:05 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
--  Records of `rbac_menu`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_menu` VALUES ('9', '3', null, '', '', null, null, '2018-02-02 15:42:18', '2018-02-02 15:42:18', '0', null), ('10', '3', '0', 'ffeeedf', 'asdf', null, '111', '2018-02-02 15:49:57', '2018-02-02 15:49:57', '0', null), ('13', '3', '10', 'wef', 'wef', null, '1111', '2018-02-02 15:57:11', '2018-02-02 15:57:11', '0', null), ('14', '3', '10', 'rrr', '阿斯顿发', null, '111', '2018-02-02 16:19:35', '2018-02-02 16:19:35', '0', null), ('19', '2', '0', '23', '123', null, '123', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('21', '3', '0', '权限管理', '#', null, '1', '2018-02-02 16:46:59', '2018-02-04 22:02:28', '23', null), ('22', '3', '21', '用户管理', '/user/index', null, '3', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('23', '3', '21', '角色管理', '/role/index', null, '2', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('24', '3', '21', '菜单管理', '/menu/index', null, '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('25', '3', '0', '系统管理', '#', null, '1', '2018-02-02 16:46:59', '2018-02-04 22:02:28', '23', null), ('26', '3', '25', '系统管理', '/system/index', null, '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '0', null), ('27', '3', '10', 'eef', 'ef', null, '111', '2018-02-06 11:39:48', '2018-02-06 11:39:48', '0', null), ('29', '3', '10', '1211111', '124444', null, '112111', '2018-02-06 11:40:01', '2018-02-08 15:05:52', '1', null), ('30', '3', '21', '权限管理', '/permission/index', null, '0', '2018-02-06 16:53:24', '2018-02-06 16:53:24', '0', null), ('31', '3', '21', '组织机构', '/organization/index', null, '0', '2018-02-23 16:15:06', '2018-02-23 16:15:06', '0', null);
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
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COMMENT='权限';

-- ----------------------------
--  Records of `rbac_permission`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_permission` VALUES ('93', '3', '0', '系统管理-查看', '1', 'sys:system:read', '2018-02-08 16:35:15', '2018-02-08 16:37:48', '1'), ('94', '3', '0', '系统管理-新增', '1', 'sys:system:create', '2018-02-08 16:36:08', '2018-02-08 16:38:11', '1'), ('95', '3', '26', '系统管理-修改', '1', 'sys:system:update', '2018-02-08 16:36:52', '2018-02-08 16:36:52', '0'), ('96', '3', '0', '系统管理-删除', '1', 'sys:system:delete', '2018-02-08 16:39:14', '2018-02-08 16:39:30', '1'), ('97', '3', '0', '菜单管理-查看', '1', 'sys:menu:read', '2018-02-22 21:47:08', '2018-02-22 21:47:08', '0'), ('98', '3', '0', '菜单管理-新增', '1', 'sys:menu:create', '2018-02-22 21:47:39', '2018-02-22 21:47:50', '1'), ('99', '3', '0', '菜单管理-修改', '1', 'sys:menu:update', '2018-02-22 21:48:21', '2018-02-22 21:48:29', '1'), ('100', '3', '0', '菜单管理-删除', '1', 'sys:menu:delete', '2018-02-22 21:48:58', '2018-02-22 21:48:58', '0'), ('101', '3', '30', '权限管理-查看', '1', 'sys:permission:read', '2018-02-22 21:49:57', '2018-02-22 22:32:12', '1'), ('102', '3', '30', '权限管理-新增', '1', 'sys:permission:create', '2018-02-22 21:50:14', '2018-02-22 22:32:02', '1'), ('103', '3', '30', '权限管理-修改', '1', 'sys:permission:update', '2018-02-22 21:50:31', '2018-02-22 22:31:50', '1'), ('104', '3', '30', '权限管理-删除', '1', 'sys:permission:delete', '2018-02-22 21:50:59', '2018-02-22 22:31:32', '1'), ('105', '3', '0', '角色管理-查看', '1', 'sys:role:read', '2018-02-22 21:51:48', '2018-02-22 21:51:48', '0'), ('106', '3', '0', '角色管理-新增', '1', 'sys:role:create', '2018-02-22 21:52:12', '2018-02-22 21:52:22', '1'), ('107', '3', '0', '角色管理-修改', '1', 'sys:role:update', '2018-02-22 21:57:26', '2018-02-22 21:57:26', '0'), ('108', '3', '23', '角色管理-删除', '1', 'sys:role:delete', '2018-02-22 21:57:54', '2018-02-22 22:34:59', '1'), ('109', '3', '0', '角色管理-分配菜单', '1', 'sys:role:assignMenu', '2018-02-22 21:58:17', '2018-02-22 21:58:17', '0'), ('110', '3', '0', '角色管理-分配权限', '1', 'sys:role:assignPermission', '2018-02-22 21:58:40', '2018-02-22 21:58:40', '0'), ('111', '3', '0', '用户管理-查看', '1', 'sys:user:read', '2018-02-22 21:59:09', '2018-02-22 21:59:09', '0'), ('112', '3', '0', '用户管理-新增', '1', 'sys:user:create', '2018-02-22 21:59:25', '2018-02-22 21:59:25', '0'), ('113', '3', '0', '用户管理-修改', '1', 'sys:user:update', '2018-02-22 21:59:40', '2018-02-22 21:59:40', '0'), ('114', '3', '0', '用户管理-删除', '1', 'sys:user:delete', '2018-02-22 21:59:57', '2018-02-22 21:59:57', '0'), ('115', '3', '0', '用户管理-分配角色', '1', 'sys:user:assignRole', '2018-02-22 22:00:18', '2018-02-22 22:00:18', '0'), ('116', '3', '0', '用户管理-分配菜单', '1', 'sys:user:assignMenu', '2018-02-22 22:00:42', '2018-02-22 22:00:42', '0'), ('117', '3', '0', '用户管理-分配权限', '1', 'sys:user:assignPermission', '2018-02-22 22:01:03', '2018-02-22 22:01:03', '0'), ('118', '3', '31', '组织机构-查看', '1', 'sys:organization:read', '2018-02-23 16:15:49', '2018-02-23 16:15:49', '0'), ('119', '3', '31', '组织机构-新增', '1', 'sys:organization:create', '2018-02-23 16:16:24', '2018-02-23 16:16:24', '0'), ('120', '3', '31', '组织机构-修改', '1', 'sys:organization:update', '2018-02-23 16:16:51', '2018-02-23 16:16:51', '0'), ('121', '3', '31', '组织机构-删除', '1', 'sys:organization:delete', '2018-02-23 16:17:13', '2018-02-23 16:17:13', '0'), ('122', '3', '22', '用户管理-分配组织机构', '1', 'sys:user:assignOrganization', '2018-02-23 16:52:41', '2018-02-23 16:52:41', '0');
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='角色';

-- ----------------------------
--  Records of `rbac_role`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_role` VALUES ('8', 'sso', '单点登录', '单点登录', '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '1'), ('9', 'serverAdministrator', '服务管理员', '服务管理员', '1', '2018-02-02 16:46:59', '2018-02-02 16:46:59', '1'), ('10', 'admin', '系统管理员', '系统管理员', '1', '2018-02-02 16:46:59', '2018-02-23 16:52:53', '8');
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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='角色-菜单关系表';

-- ----------------------------
--  Records of `rbac_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_role_menu` VALUES ('38', '10', '21'), ('39', '10', '22'), ('40', '10', '23'), ('41', '10', '24'), ('42', '10', '25'), ('43', '10', '26'), ('44', '10', '30'), ('45', '10', '31');
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
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8mb4 COMMENT='角色权限关联表';

-- ----------------------------
--  Records of `rbac_role_permission`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_role_permission` VALUES ('100', '10', '93'), ('101', '10', '94'), ('102', '10', '95'), ('103', '10', '96'), ('104', '10', '97'), ('105', '10', '98'), ('106', '10', '99'), ('107', '10', '100'), ('108', '10', '101'), ('109', '10', '102'), ('110', '10', '103'), ('111', '10', '104'), ('112', '10', '105'), ('113', '10', '106'), ('114', '10', '107'), ('115', '10', '108'), ('116', '10', '109'), ('117', '10', '110'), ('118', '10', '111'), ('119', '10', '112'), ('120', '10', '113'), ('121', '10', '114'), ('122', '10', '115'), ('123', '10', '116'), ('124', '10', '117'), ('125', '10', '118'), ('126', '10', '119'), ('127', '10', '120'), ('128', '10', '121'), ('129', '10', '122');
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='系统';

-- ----------------------------
--  Records of `rbac_system`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_system` VALUES ('2', 'http://jbone-sm-admin.majunwei:10002/jbone-sm-admin', '1', 'jbone-sm-admin', '服务管理系统', '服务管理系统', '2', null, null, '0', '1', 'http://jbone-sm-admin.majunwei.com:10002/cas111', 'http://localhost:20001/Jbone-sys-server/service/getTheme', '10002', 'Jbone服务管理系统，是基于Spring Cloud、Spring Boot Admin做的服务管理，包含服务健康检查、内存分析、JVM监控、垃圾回收、环境变量等监控和管理等功能', '1', 'Jbone服务管理系统', 'jbonesmadmin1'), ('3', 'http://jbone-sys-admin.majunwei:20002', '1', 'jbone-sys-admin', '系统管理', '系统管理', '0', null, '2018-01-28 16:32:46', '1', '1', null, null, '20002', null, '1', null, null), ('17', 'test', '-1', '测试系统', '测试系统', 'ffffeeee', '0', '2018-01-28 16:14:08', '2018-01-28 16:30:59', '2', '0', null, null, '0', null, '0', null, null), ('18', 'qwe', '1', 'qwe', 'qwe', 'qwe', '0', '2018-01-29 18:56:57', '2018-01-29 18:56:57', '0', '0', null, null, '0', null, '0', null, null), ('19', 'http://jbone-sm-monitor.majunwei.com/10003', '1', 'jbone-sm-monitor', '服务监控系统', '服务监控系统', '0', '2018-02-24 18:14:55', '2018-02-24 18:14:55', '0', '0', null, null, '0', null, '0', null, null);
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
  `avatar` varchar(150) DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `locked` tinyint(4) DEFAULT NULL COMMENT '状态(0:正常,1:锁定)',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version` int(11) DEFAULT '0' COMMENT '版本号',
  `salt` varchar(20) DEFAULT NULL COMMENT '加密盐，用于加密密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
--  Records of `rbac_user`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user` VALUES ('14', 'test123', 'test', '1231111', '123', '123fff', '123', '1', '1', '2018-02-01 09:31:47', '2018-03-21 09:20:09', '2', null), ('24', 'jbone', '3378289682ebbc6d3ce8adeba389967f', '渔樵', 'http://majunwei.com/logo.png', '1', '1', '1', '1', '2018-02-01 09:31:47', '2018-02-23 17:06:24', '17', 'jbone'), ('25', 'test1', 'eedcca02294e4519f834984df8ec5939', 'test1', '', '111', '', '1', '0', '2018-02-27 21:47:53', '2018-02-27 21:59:54', '3', null), ('28', 'salt', '206003ae5d8284e4515f64b9a64f8b86', '测试Salt', '', '', '', '1', '0', '2018-03-22 22:15:16', '2018-03-22 22:15:24', '1', '1521728115713');
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
) ENGINE=InnoDB AUTO_INCREMENT=2519 DEFAULT CHARSET=utf8 COMMENT='用户-菜单-关系表';

-- ----------------------------
--  Records of `rbac_user_menu`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_menu` VALUES ('2515', '24', '25'), ('2516', '24', '21'), ('2517', '24', '21'), ('2518', '24', '25');
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COMMENT='用户权限关联表';

-- ----------------------------
--  Records of `rbac_user_permission`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_permission` VALUES ('32', '24', '93'), ('33', '24', '96');
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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关联表';

-- ----------------------------
--  Records of `rbac_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `rbac_user_role` VALUES ('4', '1', '1'), ('5', '1', '2'), ('6', '2', '1'), ('7', '2', '2'), ('46', '24', '8'), ('47', '24', '9'), ('48', '24', '10'), ('49', '25', '8'), ('50', '25', '9'), ('51', '25', '10'), ('54', '28', '8'), ('55', '28', '9'), ('56', '28', '10');
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
