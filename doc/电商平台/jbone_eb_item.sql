/*
 Navicat MySQL Data Transfer

 Source Server         : jbone_root
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : 121.42.174.77
 Source Database       : jbone_eb_item

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 04/21/2018 16:45:30 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `item_attr`
-- ----------------------------
DROP TABLE IF EXISTS `item_attr`;
CREATE TABLE `item_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `item_sku_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品SKU ID，0代表不是SKU属性',
  `property_id` int(11) NOT NULL COMMENT '属性ID',
  `value_id` int(11) NOT NULL COMMENT '属性值ID',
  `is_sku` int(11) NOT NULL DEFAULT '0' COMMENT '是否SKU属性；\n1:是\n0:不是',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品属性表（item_attr）包含SKU属性';

-- ----------------------------
--  Table structure for `item_category`
-- ----------------------------
DROP TABLE IF EXISTS `item_category`;
CREATE TABLE `item_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `name` varchar(100) NOT NULL COMMENT '分类名',
  `pid` bigint(20) NOT NULL DEFAULT '0' COMMENT '父分类ID',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态\n1:可用\n0:不可用\n',
  `sort_num` int(11) NOT NULL DEFAULT '0' COMMENT '序号，自大到小',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30000000 DEFAULT CHARSET=utf8 COMMENT='商品分类表';

-- ----------------------------
--  Table structure for `item_category_relation`
-- ----------------------------
DROP TABLE IF EXISTS `item_category_relation`;
CREATE TABLE `item_category_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `item_category_id` bigint(20) NOT NULL COMMENT '商品分类ID,0为未分类',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品-分类关系表';

-- ----------------------------
--  Table structure for `item_detail`
-- ----------------------------
DROP TABLE IF EXISTS `item_detail`;
CREATE TABLE `item_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `detail_content` text NOT NULL COMMENT '商品详情',
  `status` int(11) NOT NULL COMMENT '状态：\n1：可用\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情表（富文本单独存储）';

-- ----------------------------
--  Table structure for `item_info`
-- ----------------------------
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `back_category_id` int(11) NOT NULL COMMENT '后端类目ID（叶子节点）',
  `brand_id` int(11) DEFAULT NULL COMMENT '品牌ID',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID',
  `name` varchar(200) NOT NULL COMMENT '商品名字',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '商品价格,单位为分',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存量',
  `sold` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `img_head` varchar(200) NOT NULL COMMENT '商品主图',
  `imgs` varchar(4096) DEFAULT NULL COMMENT '商品图片列表',
  `description` varchar(500) DEFAULT NULL COMMENT '描述/备注',
  `status` int(11) NOT NULL COMMENT '状态：\n1：可用\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20000000 DEFAULT CHARSET=utf8 COMMENT='商品基本信息表';

-- ----------------------------
--  Table structure for `item_sku`
-- ----------------------------
DROP TABLE IF EXISTS `item_sku`;
CREATE TABLE `item_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID（冗余字段）',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID ',
  `title` varchar(200) NOT NULL COMMENT '型号标题\n默认为属性值的组合，用户可修改',
  `property_values` varchar(4096) DEFAULT NULL COMMENT '属性ID集合；\n属性ID：ValueId；属性ID：ValueId',
  `img` varchar(200) DEFAULT NULL COMMENT 'SKU图片',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：\n1：可用\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品SKU信息表';

-- ----------------------------
--  Table structure for `item_sku_stock`
-- ----------------------------
DROP TABLE IF EXISTS `item_sku_stock`;
CREATE TABLE `item_sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `item_sku_id` bigint(20) NOT NULL COMMENT '商品SKU ID，如果商品没有SKU，则为0，并将价格、库存、销量同步过来',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID（冗余）',
  `shop_id` bigint(20) NOT NULL COMMENT '店铺ID（冗余）',
  `price` int(11) NOT NULL COMMENT '价格，单位为分\n价格，单位为分\n价格，单位为分',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存量',
  `sold` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '状态：\n1：可用\n0:不可用',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品SKU库存表';

-- ----------------------------
--  Table structure for `item_sku_stock_status`
-- ----------------------------
DROP TABLE IF EXISTS `item_sku_stock_status`;
CREATE TABLE `item_sku_stock_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单ID',
  `item_stock_id` bigint(20) NOT NULL COMMENT '商品库存ID',
  `stock_status` int(11) NOT NULL DEFAULT '0' COMMENT '库存状态\n0:初始值\n1:已预知\n2:已扣减\n3:已回滚',
  `sold_status` int(11) NOT NULL DEFAULT '0' COMMENT '销量状态\n0:初始值\n1:已加量\n2:已回退\n',
  `num` int(11) NOT NULL DEFAULT '0' COMMENT '增量库存数，用于预扣、扣减、回滚读取',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品SKU库存记录表';

-- ----------------------------
--  Table structure for `item_tag`
-- ----------------------------
DROP TABLE IF EXISTS `item_tag`;
CREATE TABLE `item_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `tag_id` int(11) NOT NULL COMMENT '标签ID',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `operator` varchar(100) NOT NULL COMMENT '最后更新者，当前登录名',
  `add_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `version` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品-标签关系表';

SET FOREIGN_KEY_CHECKS = 1;
