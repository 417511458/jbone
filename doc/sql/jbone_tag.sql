/*
 Navicat MySQL Data Transfer

 Source Server         : jbone_root
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : 121.42.174.77
 Source Database       : jbone_tag

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 03/30/2018 17:34:24 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tag_info`
-- ----------------------------
DROP TABLE IF EXISTS `tag_info`;
CREATE TABLE `tag_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物理主键ID',
  `name` varchar(100) CHARACTER SET utf8mb4 NOT NULL COMMENT '标签名',
  `target` int(11) NOT NULL COMMENT '作用域。有限枚举，一旦新增，不能修改\n1-店铺\n2-商品\n3-CMS文章\n4-CMS专题\n5-CMS栏目',
  `status` int(11) NOT NULL COMMENT '状态。\n0：删除\n1：正常',
  `is_show` int(11) NOT NULL COMMENT '是否前台展示。一旦新增，不能修改\n0：不展示\n1：展示',
  `icon` varchar(200) DEFAULT NULL COMMENT '标签图标',
  `icon_type` int(11) DEFAULT NULL COMMENT 'icon类型，如果设置为2，则展示图片，否则展示加CSS图片的name\n1：CSS图标\n2：图片',
  `click_target` varchar(200) NOT NULL COMMENT '点击后的跳转链接，如jbone-cms.majunwei.com/topic/111',
  `time_validity` int(11) NOT NULL COMMENT '是否设置标签有效期。一旦新增，不能修改\n0：不设置有效期\n1：设置有效期',
  `start_time` timestamp NULL DEFAULT NULL COMMENT '当设置”time_validity”为1时，该值必填。有效期的开始时间。',
  `end_time` timestamp NULL DEFAULT NULL COMMENT '当设置”time_validity”为1时，该值必填。有效期的结束时间。',
  `extend` varchar(2048) DEFAULT NULL COMMENT '预留扩展信息,json格式',
  `applier` varchar(100) DEFAULT NULL COMMENT '申请人',
  `apply_reason` varchar(200) DEFAULT NULL COMMENT '申请说明',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '记录添加时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '记录最后一次修改时间',
  `version` bigint(20) DEFAULT NULL COMMENT '版本号，乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tag_info`
-- ----------------------------
BEGIN;
INSERT INTO `tag_info` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', null, null, null, null, null, null, null, null), ('2', 'tagName', '1', '1', '1', '', '1', '1', '1', null, null, '', '', '', null, null, '1'), ('4', 'tagName', '1', '1', '1', '', '1', '1', '1', null, null, '', '', '', null, null, '1'), ('5', 'tagName', '1', '1', '1', '', '1', '1', '1', null, null, '', '', '', null, null, '1'), ('6', 'tagName', '1', '1', '1', '', '1', '1', '1', null, null, '', '', '', null, null, '1'), ('9', '3333', '1', '1', '1', '333', '1', '3333', '1', '2018-03-30 00:00:00', '2018-03-30 00:00:00', null, null, null, '2018-03-30 16:22:13', '2018-03-30 16:22:13', '0'), ('10', '123', '1', '1', '1', '123', '1', '123', '1', '2018-03-30 00:00:00', '2018-03-30 00:00:00', null, null, null, '2018-03-30 16:24:08', '2018-03-30 16:24:08', '0'), ('11', '123', '1', '1', '1', '123', '1', '123', '1', '2018-03-30 00:00:00', '2018-03-30 00:00:00', null, null, null, '2018-03-30 17:20:50', '2018-03-30 17:20:50', '0'), ('12', '3333', '1', '0', '0', '33', '1', '123', '1', '2018-03-30 00:00:00', '2018-03-30 00:00:00', null, null, null, '2018-03-30 17:27:24', '2018-03-30 17:27:24', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
