/*
 Navicat MySQL Data Transfer

 Source Server         : jbone_root
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : 121.42.174.77
 Source Database       : jbone_eb_shop

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 04/21/2018 16:45:04 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `shop_gps`
-- ----------------------------
DROP TABLE IF EXISTS `shop_gps`;
CREATE TABLE `shop_gps` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID',
  `guid` varchar(100) NOT NULL COMMENT '设备ID',
  `lon` double NOT NULL COMMENT '经度',
  `lat` double NOT NULL COMMENT '纬度',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺GPS定位表';

-- ----------------------------
--  Table structure for `shop_info`
-- ----------------------------
DROP TABLE IF EXISTS `shop_info`;
CREATE TABLE `shop_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键，店铺ID',
  `shop_name` varchar(200) NOT NULL COMMENT '店铺名',
  `shop_logo` varchar(200) DEFAULT NULL COMMENT '店铺Logo',
  `qrcode` varchar(200) DEFAULT NULL COMMENT '店铺二维码',
  `nick_name` varchar(200) DEFAULT NULL COMMENT '店长昵称',
  `seller_logo` varchar(200) DEFAULT NULL COMMENT '店长头像',
  `weixin` varchar(200) DEFAULT NULL COMMENT '微信号',
  `front_cover` varchar(200) NOT NULL COMMENT '店招',
  `note` varchar(2000) DEFAULT NULL COMMENT '店铺公告',
  `status` int(11) NOT NULL COMMENT '状态；\n1:可用\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000000 DEFAULT CHARSET=utf8 COMMENT='店铺基本信息表';

-- ----------------------------
--  Table structure for `shop_tag`
-- ----------------------------
DROP TABLE IF EXISTS `shop_tag`;
CREATE TABLE `shop_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `tag_id` int(11) NOT NULL COMMENT '标签ID',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺-标签关系表';

SET FOREIGN_KEY_CHECKS = 1;
