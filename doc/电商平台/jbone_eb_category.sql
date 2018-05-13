/*
 Navicat MySQL Data Transfer

 Source Server         : jbone_root
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : 121.42.174.77
 Source Database       : jbone_eb_category

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 04/21/2018 16:45:20 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `back_category`
-- ----------------------------
DROP TABLE IF EXISTS `back_category`;
CREATE TABLE `back_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(200) NOT NULL COMMENT '类目名字',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '父级类目',
  `cids` varchar(4096) DEFAULT NULL COMMENT '子类目ID，逗号隔开，方便查询该类型下所有子类目包含的商品',
  `description` varchar(500) DEFAULT NULL COMMENT '类目描述',
  `sort_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1:可用，0: 不可用',
  `features` varchar(4096) DEFAULT NULL COMMENT '预留类目扩展字段（JSON格式）',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台类目表';

-- ----------------------------
--  Table structure for `back_category_brand_relation`
-- ----------------------------
DROP TABLE IF EXISTS `back_category_brand_relation`;
CREATE TABLE `back_category_brand_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `back_category_id` int(11) NOT NULL COMMENT '后台类目ID（叶子节点）',
  `brand_id` int(11) NOT NULL COMMENT '品牌ID',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌-类目关系表；\n管理品牌，通过关系表维护类目下有哪些品牌';

-- ----------------------------
--  Table structure for `back_category_property`
-- ----------------------------
DROP TABLE IF EXISTS `back_category_property`;
CREATE TABLE `back_category_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `back_category_id` int(11) NOT NULL COMMENT '后端类目ID（叶子节点）',
  `property_id` int(11) NOT NULL COMMENT '属性ID',
  `is_must` int(11) NOT NULL DEFAULT '1' COMMENT '是否必填\n1:必填（默认）\n0:非必填',
  `is_multi` int(11) NOT NULL DEFAULT '0' COMMENT '是否多值\n1:多值\n0:非多值（默认）',
  `is_input_prop` int(11) NOT NULL DEFAULT '0' COMMENT '是否可输入\n0:不可（默认）\n1:可以',
  `is_sku` int(11) NOT NULL DEFAULT '0' COMMENT '是否商品型号；\n1:是\n0:否（默认）',
  `description` varchar(500) DEFAULT NULL COMMENT '描述/备注',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：\n1：可用(默认)\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后端类目-属性关系表;\n此表用来存储类目下有哪些属性，比如颜色、型号等；注意只有叶子节点才拥有属性，和属性进行关联';

-- ----------------------------
--  Table structure for `back_category_property_value`
-- ----------------------------
DROP TABLE IF EXISTS `back_category_property_value`;
CREATE TABLE `back_category_property_value` (
  `id` int(11) NOT NULL COMMENT '自增主键',
  `back_category_id` int(11) NOT NULL COMMENT '后端类目ID（叶子节点）',
  `property_id` int(11) NOT NULL COMMENT '属性ID',
  `value_id` int(11) NOT NULL COMMENT '属性值ID',
  `description` varchar(500) DEFAULT NULL COMMENT '描述/备注',
  `status` int(11) NOT NULL COMMENT '状态：\n1：可用\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后端类目-属性-值关系表；\n此表用来存储类目下属性有哪些值，比如iphone有颜色为白色的。也就是有白色的Iphone手机';

-- ----------------------------
--  Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `chinese_name` varchar(100) NOT NULL COMMENT '中文名字',
  `english_name` varchar(100) NOT NULL COMMENT '英文名字',
  `description` varchar(1000) DEFAULT NULL COMMENT '品牌描述',
  `logo` varchar(200) DEFAULT NULL COMMENT '品牌Logo',
  `website` varchar(200) DEFAULT NULL COMMENT '官网网址',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态\n1:可用\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品牌表;\n管理品牌，通过关系表维护类目下有哪些品牌';

-- ----------------------------
--  Table structure for `front_back_category_relation`
-- ----------------------------
DROP TABLE IF EXISTS `front_back_category_relation`;
CREATE TABLE `front_back_category_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `front_category_id` int(11) NOT NULL COMMENT '前台类目ID',
  `back_category_id` int(11) NOT NULL COMMENT '后台类目ID',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前后台类目关系表;\n用于在前台导航映射到后台类目';

-- ----------------------------
--  Table structure for `front_category`
-- ----------------------------
DROP TABLE IF EXISTS `front_category`;
CREATE TABLE `front_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(200) NOT NULL COMMENT '类目名字',
  `pid` int(11) NOT NULL DEFAULT '0' COMMENT '父级类目',
  `cids` varchar(4096) DEFAULT NULL COMMENT '子类目ID，逗号隔开，方便查询该类型下所有子类目包含的商品',
  `description` varchar(500) DEFAULT NULL COMMENT '类目描述',
  `sort_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1:可用，0: 不可用',
  `img_url` varchar(200) DEFAULT NULL COMMENT '类目导航图',
  `min_price` int(11) DEFAULT '-1' COMMENT '价格区间最小值',
  `max_price` int(11) DEFAULT '-1' COMMENT '价格区间最大值',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='前台类目表';

-- ----------------------------
--  Table structure for `industry`
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(200) NOT NULL COMMENT '行业名字',
  `business_type` int(11) NOT NULL DEFAULT '1' COMMENT '业务类型；\n1：普通',
  `description` varchar(500) DEFAULT NULL COMMENT '行业描述',
  `sort_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序号',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态，1:可用，0: 不可用',
  `features` varchar(4096) DEFAULT NULL COMMENT '预留行业扩展字段',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行业表;\n行业实际上是一级类目的集合，比方说健身行业，后面可能会有健身器材、运动服等一级类目';

-- ----------------------------
--  Table structure for `industry_back_category`
-- ----------------------------
DROP TABLE IF EXISTS `industry_back_category`;
CREATE TABLE `industry_back_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `industry_id` int(11) NOT NULL COMMENT '行业ID',
  `back_category_id` int(11) NOT NULL COMMENT '一级类目ID，行业只跟一级类目产生关联，子类目同属于本行业',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='行业-类目关系;\n行业只和一级类目关联';

-- ----------------------------
--  Table structure for `public_property`
-- ----------------------------
DROP TABLE IF EXISTS `public_property`;
CREATE TABLE `public_property` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(100) NOT NULL COMMENT '属性名字',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：\n1：可用\n0:不可用',
  `description` varchar(500) DEFAULT NULL COMMENT '属性描述/备注',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性表；\n比如颜色、国家、语言、品牌等';

-- ----------------------------
--  Table structure for `public_property_value`
-- ----------------------------
DROP TABLE IF EXISTS `public_property_value`;
CREATE TABLE `public_property_value` (
  `id` int(11) NOT NULL COMMENT '自增主键',
  `property_id` int(11) NOT NULL COMMENT '属性ID',
  `value_id` int(11) NOT NULL COMMENT '属性值ID',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：\n1：可用\n0:不可用',
  `description` varchar(500) DEFAULT NULL COMMENT '描述/备注',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性-值关系表；\n维护属性有哪些值，比如颜色有白色、黑色、等等';

-- ----------------------------
--  Table structure for `public_value`
-- ----------------------------
DROP TABLE IF EXISTS `public_value`;
CREATE TABLE `public_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `content` varchar(1024) NOT NULL COMMENT '属性值',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：\n1：可用\n0:不可用',
  `description` varchar(500) DEFAULT NULL COMMENT '描述/备注',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性值表；\n确定的值，如白色、中国、苹果、等等';

SET FOREIGN_KEY_CHECKS = 1;
