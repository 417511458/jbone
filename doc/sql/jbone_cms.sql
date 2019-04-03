/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost
 Source Database       : jbone_cms

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : utf-8

 Date: 04/03/2019 16:43:55 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `allow_comment` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `front_cover` varchar(255) DEFAULT NULL,
  `hits` int(11) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `template_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_index_orders` (`orders`),
  KEY `article_index_hits` (`hits`),
  KEY `article_index_add_time` (`add_time`),
  KEY `FKy5kkohbk00g0w88fi05k2hcw` (`category_id`),
  KEY `FK26lqedi5u7vniut2s75qwc54k` (`template_id`)
) ENGINE=MyISAM AUTO_INCREMENT=86 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `article`
-- ----------------------------
BEGIN;
INSERT INTO `article` VALUES ('1', '2019-03-22 16:10:49', '24', '2019-03-29 16:54:15', '17', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '16', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('2', '2019-03-23 16:10:49', null, '2019-03-29 16:54:07', '3', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '2', '', '0', 'PUBLISH', '前Eureka内部实现原理', '19', null), ('3', '2019-03-21 16:10:49', null, '2019-03-29 18:28:08', '5', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '4', '', '0', 'PUBLISH', '后Eureka内部实现原理', '19', null), ('4', '2019-03-22 16:10:49', '24', '2019-03-29 16:54:01', '3', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '1', '', '0', 'DELETE', 'Eureka内部实现原理', '19', null), ('5', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('6', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('7', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('8', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('9', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('10', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('11', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('12', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('13', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('14', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('15', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('16', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('17', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('18', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('19', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('20', '2019-03-22 16:10:49', '25', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('21', '2019-03-22 16:10:49', '24', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('22', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('23', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('24', '2019-03-22 16:10:49', '24', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('25', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('26', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('27', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('28', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('29', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('30', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('31', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('32', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('33', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('34', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('35', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('36', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('37', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('38', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('39', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('40', '2019-03-22 16:10:49', '25', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('41', '2019-03-22 16:10:49', '24', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('42', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('43', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('44', '2019-03-22 16:10:49', '24', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('45', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('46', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('47', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('48', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('49', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('50', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('51', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('52', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('53', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('54', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('55', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('56', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('57', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('58', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('59', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('60', '2019-03-22 16:10:49', '25', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('61', '2019-03-22 16:10:49', '24', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('62', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('63', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('64', '2019-03-22 16:10:49', '24', '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('65', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('66', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('67', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('68', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('69', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('70', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('71', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('72', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('73', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('74', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('75', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('76', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('77', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('78', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('79', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '1', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '0', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('80', '2019-03-22 16:10:49', '25', '2019-03-29 14:53:26', '2', '1', '本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png', '1', '', '0', 'PUBLISH', 'Eureka内部实现原理', '19', null), ('81', '2019-03-26 14:36:14', null, '2019-03-26 14:36:14', '1', '1', '123', '', '0', '123', '0', 'PUBLISH', '测试文章', '18', null), ('82', '2019-03-26 14:55:03', null, '2019-03-26 14:55:03', '0', '1', '', '', '0', '', '0', 'PUBLISH', 'asdf', '20', null), ('84', '2019-03-28 12:56:08', '24', '2019-03-29 14:53:33', '8', '1', '', '', '8', '', '0', 'PUBLISH', '测试文章', '5', null), ('85', '2019-03-29 14:54:52', '24', '2019-03-29 14:54:52', '1', '1', '阿斯顿发生地方', '', '0', '阿斯顿发生地方', '0', 'PUBLISH', '阿斯顿发生地方', '5', null);
COMMIT;

-- ----------------------------
--  Table structure for `article_data`
-- ----------------------------
DROP TABLE IF EXISTS `article_data`;
CREATE TABLE `article_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `content` longtext,
  `table_of_contents` text,
  `article_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcg6yewcu9rjoh6ngmeujikdy4` (`article_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `article_data`
-- ----------------------------
BEGIN;
INSERT INTO `article_data` VALUES ('1', '2019-03-22 16:10:49', null, '2019-03-22 16:10:49', '0', '<p>微服务架构中最核心的部分是服务治理，服务治理最基础的组件是注册中心。随着微服务架构的发展，出现了很多微服务架构的解决方案，其中包括我们熟知的Dubbo和Spring Cloud。</p><p>关于注册中心的解决方案，dubbo支持了Zookeeper、Redis、Multicast和Simple，官方推荐Zookeeper。Spring Cloud支持了Zookeeper、Consul和Eureka，官方推荐Eureka。</p><p>两者之所以推荐不同的实现方式，原因在于组件的特点以及适用场景不同。简单来说：</p><p>ZK的设计原则是CP，即强一致性和分区容错性。他保证数据的强一致性，但舍弃了可用性，<strong>如果出现网络问题可能会影响ZK的选举，导致ZK注册中心的不可用</strong>。</p><p>Eureka的设计原则是AP，即可用性和分区容错性。他保证了注册中心的可用性，但舍弃了数据一致性，<strong>各节点上的数据有可能是不一致的（会最终一致）</strong>。</p><p>&nbsp;</p><p>Eureka采用纯Java实现，除实现了注册中心基本的服务注册和发现之外，极大的满足注册中心的可用性，即使只有一台服务可用，也可以保证注册中心的可用性。</p><p>本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。</p>\n<p>微服务架构中最核心的部分是服务治理，服务治理最基础的组件是注册中心。随着微服务架构的发展，出现了很多微服务架构的解决方案，其中包括我们熟知的Dubbo和Spring Cloud。</p><p>关于注册中心的解决方案，dubbo支持了Zookeeper、Redis、Multicast和Simple，官方推荐Zookeeper。Spring Cloud支持了Zookeeper、Consul和Eureka，官方推荐Eureka。</p><p>两者之所以推荐不同的实现方式，原因在于组件的特点以及适用场景不同。简单来说：</p><p>ZK的设计原则是CP，即强一致性和分区容错性。他保证数据的强一致性，但舍弃了可用性，<strong>如果出现网络问题可能会影响ZK的选举，导致ZK注册中心的不可用</strong>。</p><p>Eureka的设计原则是AP，即可用性和分区容错性。他保证了注册中心的可用性，但舍弃了数据一致性，<strong>各节点上的数据有可能是不一致的（会最终一致）</strong>。</p><p>&nbsp;</p><p>Eureka采用纯Java实现，除实现了注册中心基本的服务注册和发现之外，极大的满足注册中心的可用性，即使只有一台服务可用，也可以保证注册中心的可用性。</p><p>本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。</p>\n<p>微服务架构中最核心的部分是服务治理，服务治理最基础的组件是注册中心。随着微服务架构的发展，出现了很多微服务架构的解决方案，其中包括我们熟知的Dubbo和Spring Cloud。</p><p>关于注册中心的解决方案，dubbo支持了Zookeeper、Redis、Multicast和Simple，官方推荐Zookeeper。Spring Cloud支持了Zookeeper、Consul和Eureka，官方推荐Eureka。</p><p>两者之所以推荐不同的实现方式，原因在于组件的特点以及适用场景不同。简单来说：</p><p>ZK的设计原则是CP，即强一致性和分区容错性。他保证数据的强一致性，但舍弃了可用性，<strong>如果出现网络问题可能会影响ZK的选举，导致ZK注册中心的不可用</strong>。</p><p>Eureka的设计原则是AP，即可用性和分区容错性。他保证了注册中心的可用性，但舍弃了数据一致性，<strong>各节点上的数据有可能是不一致的（会最终一致）</strong>。</p><p>&nbsp;</p><p>Eureka采用纯Java实现，除实现了注册中心基本的服务注册和发现之外，极大的满足注册中心的可用性，即使只有一台服务可用，也可以保证注册中心的可用性。</p><p>本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。</p>\n<p>微服务架构中最核心的部分是服务治理，服务治理最基础的组件是注册中心。随着微服务架构的发展，出现了很多微服务架构的解决方案，其中包括我们熟知的Dubbo和Spring Cloud。</p><p>关于注册中心的解决方案，dubbo支持了Zookeeper、Redis、Multicast和Simple，官方推荐Zookeeper。Spring Cloud支持了Zookeeper、Consul和Eureka，官方推荐Eureka。</p><p>两者之所以推荐不同的实现方式，原因在于组件的特点以及适用场景不同。简单来说：</p><p>ZK的设计原则是CP，即强一致性和分区容错性。他保证数据的强一致性，但舍弃了可用性，<strong>如果出现网络问题可能会影响ZK的选举，导致ZK注册中心的不可用</strong>。</p><p>Eureka的设计原则是AP，即可用性和分区容错性。他保证了注册中心的可用性，但舍弃了数据一致性，<strong>各节点上的数据有可能是不一致的（会最终一致）</strong>。</p><p>&nbsp;</p><p>Eureka采用纯Java实现，除实现了注册中心基本的服务注册和发现之外，极大的满足注册中心的可用性，即使只有一台服务可用，也可以保证注册中心的可用性。</p><p>本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。</p>\n<p>微服务架构中最核心的部分是服务治理，服务治理最基础的组件是注册中心。随着微服务架构的发展，出现了很多微服务架构的解决方案，其中包括我们熟知的Dubbo和Spring Cloud。</p><p>关于注册中心的解决方案，dubbo支持了Zookeeper、Redis、Multicast和Simple，官方推荐Zookeeper。Spring Cloud支持了Zookeeper、Consul和Eureka，官方推荐Eureka。</p><p>两者之所以推荐不同的实现方式，原因在于组件的特点以及适用场景不同。简单来说：</p><p>ZK的设计原则是CP，即强一致性和分区容错性。他保证数据的强一致性，但舍弃了可用性，<strong>如果出现网络问题可能会影响ZK的选举，导致ZK注册中心的不可用</strong>。</p><p>Eureka的设计原则是AP，即可用性和分区容错性。他保证了注册中心的可用性，但舍弃了数据一致性，<strong>各节点上的数据有可能是不一致的（会最终一致）</strong>。</p><p>&nbsp;</p><p>Eureka采用纯Java实现，除实现了注册中心基本的服务注册和发现之外，极大的满足注册中心的可用性，即使只有一台服务可用，也可以保证注册中心的可用性。</p><p>本文将聚焦到Eureka的内部实现原理，先从微服务架构的部署图介绍Eureka的总体架构，然后剖析服务信息的存储结构，最后探究跟服务生命周期相关的服务注册机制、服务续约机制、服务注销机制、服务剔除机制、服务获取机制、和服务同步机制。</p>', null, '1'), ('2', '2019-03-26 14:36:14', null, '2019-03-26 14:36:14', '0', '<h1>阿斯顿发史蒂夫</h1><div>阿斯顿发史蒂夫sdasdf</div><div><span style=\"font-style: italic;\">阿斯顿发史蒂夫</span></div><ol><li>sadfasdfasdfasdf</li><li>asdf</li><li>sdfa是否</li></ol><div><h1>asdf</h1></div><div>阿斯顿发<br></div><p><br></p><p><br></p><p><br></p><p><br></p>', null, '81'), ('3', '2019-03-26 14:55:03', null, '2019-03-26 14:55:03', '0', '<pre><code>sdfasdf</code></pre><p>asdfasdf</p>', null, '82'), ('4', '2019-03-27 17:59:08', null, '2019-03-27 18:00:42', '1', '<p>asdfasdfasdf</p>', null, '83'), ('5', '2019-03-28 12:56:08', null, '2019-03-28 12:56:08', '0', '<p>测试文章</p><p>测试文章</p><p>测试文章</p><p>测试文章</p><p>测试文章</p><p>测试文章</p><p>测试文章</p>', null, '84'), ('6', '2019-03-29 14:54:52', null, '2019-03-29 14:54:52', '0', '<p>阿斯顿发生地方</p><p>阿斯顿发</p><p>阿斯顿发</p><p>阿斯顿发</p><p>asdf asdf asdf&nbsp;</p>', null, '85');
COMMIT;

-- ----------------------------
--  Table structure for `article_tag`
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag` (
  `article_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  KEY `FKesqp7s9jj2wumlnhssbme5ule` (`tag_id`),
  KEY `FKenqeees0y8hkm7x1p1ittuuye` (`article_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `article_tag`
-- ----------------------------
BEGIN;
INSERT INTO `article_tag` VALUES ('1', '1'), ('81', '1'), ('85', '1');
COMMIT;

-- ----------------------------
--  Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `front_cover` varchar(255) DEFAULT NULL,
  `in_menu` int(11) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `template_id` bigint(20) DEFAULT NULL,
  `show_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_index_orders` (`orders`),
  KEY `FKq4l2ui5eff75oyckpmxj3weju` (`template_id`),
  KEY `FKeiel7nqjxu4kmefso9tm9qcsu` (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `category`
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES ('1', '2019-01-31 18:12:25', '1', '2019-03-26 11:49:44', '9', '说明qweqwe', '111', '1', 'ewer', '1', '0', 'PUBLISH', '', '测试标签栏目', 'TAG', '', null, 'LIST'), ('2', '2019-01-31 18:13:24', '1', '2019-01-31 18:13:30', '1', '说明而', '111', '0', '2312313', '1', '1', 'PUBLISH', '111', '标题儿', 'CATEGORY', '1111', null, null), ('5', '2019-02-12 18:45:44', null, '2019-02-12 18:45:44', '0', '撒地方', null, '0', '撒地方', '0', '0', 'PUBLISH', '撒地方', '阿斯顿发史蒂夫', 'CATEGORY', 'sad方', null, null), ('8', '2019-02-13 09:26:59', null, '2019-02-13 09:26:59', '0', 'asdf', null, '0', 'asdf', '0', '0', 'PUBLISH', 'asdf', 'asdf', 'CATEGORY', 'asdf', null, null), ('11', '2019-02-13 09:38:46', null, '2019-03-22 11:44:18', '2', '', '', '1', '', '5', '0', 'PUBLISH', '_blank', '百度', 'CATEGORY', 'http://www.baidu.com', null, 'LIST'), ('10', '2019-02-13 09:27:16', null, '2019-03-26 11:19:27', '2', 'asdf', null, '0', 'asdf', '0', '0', 'AUDIT', 'asdf', 'asdf', 'TAG', 'asdf', null, null), ('12', '2019-02-13 09:38:55', null, '2019-02-13 09:38:55', '0', 'fff', null, '0', 'ff', '0', '10', 'PUBLISH', 'f', 'ff', 'CATEGORY', 'ff', null, null), ('16', '2019-02-13 22:12:31', null, '2019-03-22 11:42:57', '5', '联系我', '', '1', '联系我', '3', '0', 'PUBLISH', '', '联系我', 'CATEGORY', '', null, 'LIST'), ('17', '2019-03-19 17:17:07', null, '2019-03-22 11:42:21', '2', '首页', null, '1', '', '0', '0', 'PUBLISH', '', '首页', 'CATEGORY', '', null, 'LIST'), ('18', '2019-03-21 16:52:07', null, '2019-03-21 16:52:07', '0', '学习', '', '1', '学习', '2', '0', 'PUBLISH', '', '学习', 'CATEGORY', '', null, 'LIST'), ('19', '2019-03-21 17:17:59', null, '2019-03-21 17:17:59', '0', '', '', '1', 'Spring Cloud', '1', '18', 'PUBLISH', '', 'Spring Cloud', 'CATEGORY', '', null, 'LIST'), ('20', '2019-03-25 17:40:09', null, '2019-03-25 17:40:09', '0', '', '', '1', '', '0', '0', 'PUBLISH', '', '测试专题栏目', 'SPECIAL', '', null, 'LIST'), ('21', '2019-03-26 14:04:53', null, '2019-03-26 14:04:53', '0', '测试父子栏目', '', '1', '测试父子栏目', '0', '0', 'PUBLISH', '', '测试父子栏目', 'CATEGORY', '', null, 'LIST'), ('22', '2019-03-26 14:06:10', null, '2019-03-26 14:06:10', '0', '', '', '1', '', '0', '21', 'PUBLISH', '', '子栏目一', 'CATEGORY', '', null, 'LIST'), ('23', '2019-03-26 14:06:10', null, '2019-03-26 14:06:30', '1', '', '', '0', '', '0', '21', 'PUBLISH', '', '子栏目一（不展示）', 'CATEGORY', '', null, 'LIST'), ('24', '2019-03-26 14:06:43', null, '2019-03-26 14:06:43', '0', '', '', '1', '', '0', '21', 'PUBLISH', '', '子栏目二', 'CATEGORY', '', null, 'LIST'), ('25', '2019-03-26 14:07:02', null, '2019-03-26 14:07:02', '0', '', '', '1', '', '0', '24', 'PUBLISH', '', '子栏目二-1', 'CATEGORY', '', null, 'LIST'), ('26', '2019-03-27 11:16:16', null, '2019-03-27 11:16:16', '0', '', '', '1', '', '0', '19', 'PUBLISH', '', '测试展示自标题', 'CATEGORY', '', null, 'LIST');
COMMIT;

-- ----------------------------
--  Table structure for `category_tag`
-- ----------------------------
DROP TABLE IF EXISTS `category_tag`;
CREATE TABLE `category_tag` (
  `category_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  KEY `FK7ajcceshl0yansk0i3kkiv53l` (`tag_id`),
  KEY `FKa87fb70v74ldqt14lmsm68j73` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `category_tag`
-- ----------------------------
BEGIN;
INSERT INTO `category_tag` VALUES ('1', '27'), ('1', '10'), ('1', '1'), ('1', '3'), ('1', '6'), ('10', '43'), ('10', '6'), ('10', '3'), ('1', '12'), ('1', '14'), ('1', '25'), ('1', '17');
COMMIT;

-- ----------------------------
--  Table structure for `category_toc`
-- ----------------------------
DROP TABLE IF EXISTS `category_toc`;
CREATE TABLE `category_toc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `front_cover` varchar(255) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpqb4qoq8x0rvigug0sh8d63jn` (`article_id`),
  KEY `FKjh9h26aphbot81fq555amyapy` (`category_id`),
  KEY `FK1wh4mw2l2eika78s0nw7ane85` (`pid`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `category_toc`
-- ----------------------------
BEGIN;
INSERT INTO `category_toc` VALUES ('1', '2019-03-18 10:25:14', '1', '2019-03-18 10:25:18', '1', '1', '1', '0', null, '标题', 'url', null, '13'), ('3', '2019-03-18 10:26:22', '1', '2019-03-18 10:26:25', '1', '1', '3', '1', null, '自标题', 'url', null, '13'), ('4', '2019-03-19 15:57:13', null, '2019-03-19 16:21:04', '3', null, '6', '0', '_self', '撒地方', '123', '4', '13'), ('5', '2019-03-19 15:57:20', null, '2019-03-19 15:57:20', '0', null, '2', '0', '_self', '123', '123', '6', '13'), ('7', '2019-03-19 15:58:11', null, '2019-03-19 15:58:11', '0', null, '0', '5', '_self', '123', '123', '6', '13'), ('8', '2019-03-19 15:58:18', null, '2019-03-19 15:58:18', '0', null, '0', '5', '_self', '123', '123', '6', '13'), ('10', '2019-03-19 16:30:20', null, '2019-03-19 17:23:33', '2', null, '1', '0', '_self', 'ffff', '', null, '13'), ('15', '2019-03-19 16:30:21', null, '2019-03-19 16:30:21', '0', null, '0', '0', '_self', '333', '333', null, '13'), ('27', '2019-03-19 16:49:27', null, '2019-03-19 16:49:27', '0', null, '0', '0', '_self', 'wefqwef', 'qfeqfe', null, '13'), ('17', '2019-03-19 16:30:22', null, '2019-03-19 16:30:22', '0', null, '0', '0', '_self', '333', '333', null, '13'), ('18', '2019-03-19 16:30:22', null, '2019-03-19 16:56:12', '1', null, '0', '0', '_self', '333', '333', '8', '13'), ('19', '2019-03-19 16:30:22', null, '2019-03-19 16:30:22', '0', null, '0', '0', '_self', '333', '333', null, '13'), ('20', '2019-03-19 16:30:22', null, '2019-03-19 16:30:22', '0', null, '0', '0', '_self', '333', '333', null, '13'), ('23', '2019-03-19 16:42:05', null, '2019-03-19 16:42:05', '0', null, '2', '0', '_self', '444', '444', null, '13'), ('24', '2019-03-19 16:42:19', null, '2019-03-19 16:42:19', '0', null, '2', '0', '_self', '444', '444', null, '13'), ('25', '2019-03-19 16:44:07', null, '2019-03-19 16:44:07', '0', null, '0', '0', '_self', 'ffff', '', null, '13'), ('26', '2019-03-19 16:47:50', null, '2019-03-19 16:47:50', '0', null, '0', '0', '_self', 'sadfasd', '', null, '13'), ('29', '2019-03-28 12:54:47', null, '2019-03-28 12:54:47', '0', null, '-3', '0', '_self', '目录一', '', '1', '20'), ('30', '2019-03-28 12:55:01', null, '2019-03-28 12:55:01', '0', null, '0', '0', '_self', '目录二', '', '1', '20'), ('31', '2019-03-28 12:56:28', null, '2019-03-28 12:56:28', '0', null, '0', '29', '_self', '子目录一', '', '84', '20'), ('33', '2019-03-28 17:45:39', null, '2019-03-28 17:55:03', '1', null, '0', '0', '_self', '百度', 'http://www.baidu.com', null, '20'), ('34', '2019-03-28 17:45:43', null, '2019-03-28 17:45:43', '0', null, '0', '0', '_self', 'aaaa', '', null, '20'), ('35', '2019-03-28 17:45:45', null, '2019-03-28 17:45:49', '1', null, '0', '0', '_self', 'ccc', '', null, '20'), ('36', '2019-03-28 17:45:52', null, '2019-03-28 17:45:52', '0', null, '0', '0', '_self', 'ddd', '', null, '20'), ('37', '2019-03-28 17:45:55', null, '2019-03-28 17:45:55', '0', null, '0', '0', '_self', 'eee', '', null, '20'), ('38', '2019-03-28 17:45:58', null, '2019-03-28 17:45:58', '0', null, '0', '0', '_self', 'fff', '', null, '20'), ('39', '2019-03-28 17:46:02', null, '2019-03-28 17:46:02', '0', null, '0', '0', '_self', 'gggg', '', null, '20'), ('40', '2019-03-28 17:46:05', null, '2019-03-28 17:46:05', '0', null, '0', '0', '_self', 'hhhh', '', null, '20'), ('41', '2019-03-28 17:46:08', null, '2019-03-28 17:46:08', '0', null, '0', '0', '_self', 'iiiii', '', null, '20'), ('42', '2019-03-28 17:46:12', null, '2019-03-28 17:46:12', '0', null, '0', '0', '_self', 'jjjjj', '', null, '20'), ('50', '2019-03-28 17:53:56', null, '2019-03-28 17:54:02', '1', null, '0', '0', '_self', 'lllll', '', null, '20'), ('51', '2019-03-28 17:54:06', null, '2019-03-28 17:54:10', '1', null, '0', '0', '_self', 'mmmm', '', null, '20'), ('52', '2019-03-28 17:54:13', null, '2019-03-28 17:54:13', '0', null, '0', '0', '_self', 'nnnn', '', null, '20'), ('53', '2019-03-28 17:54:18', null, '2019-03-28 17:54:18', '0', null, '0', '0', '_self', 'oooo', '', null, '20'), ('54', '2019-03-28 17:54:21', null, '2019-03-28 17:54:21', '0', null, '0', '0', '_self', 'pppp', '', null, '20'), ('55', '2019-03-28 17:57:24', null, '2019-03-28 17:57:24', '0', null, '0', '31', '_self', 'asdfsdf', '', null, '20'), ('56', '2019-03-28 17:57:29', null, '2019-03-28 17:57:29', '0', null, '0', '55', '_self', 'asdfasdf', '', null, '20'), ('57', '2019-03-28 17:57:51', null, '2019-03-28 17:57:51', '0', null, '0', '56', '_self', '是的发送到发生地方阿迪舒服阿迪发顺丰阿迪舒服', '', null, '20'), ('58', '2019-03-28 17:58:00', null, '2019-03-28 17:58:00', '0', null, '0', '57', '_self', '撒地方阿迪发的发送啊', '', null, '20');
COMMIT;

-- ----------------------------
--  Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `article_id` bigint(20) DEFAULT NULL,
  `content` text,
  `ip` varchar(255) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `comment`
-- ----------------------------
BEGIN;
INSERT INTO `comment` VALUES ('1', '2019-03-25 14:05:38', '24', '2019-03-25 14:05:42', '2', '1', '123123', null, null, null, null), ('2', '2019-03-27 16:39:06', null, '2019-03-27 16:39:06', '0', '1', null, null, '0', '1', null), ('3', '2019-03-27 16:41:56', null, '2019-03-27 16:41:56', '0', '1', null, null, '0', '1', null), ('4', '2019-03-27 16:44:07', '24', '2019-03-27 16:44:07', '0', '1', 'fffff', '127.0.0.1', '0', '1', null), ('5', '2019-03-27 16:47:25', '24', '2019-03-27 16:47:25', '0', '1', 'asdfasdfasdf', '127.0.0.1', '0', '1', null);
COMMIT;

-- ----------------------------
--  Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `front_cover` varchar(255) DEFAULT NULL,
  `orders` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `link`
-- ----------------------------
BEGIN;
INSERT INTO `link` VALUES ('15', '2019-01-30 23:08:33', null, '2019-01-30 23:08:33', '0', 'werwer', null, '0', 'ewer', 'wer'), ('16', '2019-01-31 10:27:52', null, '2019-01-31 10:27:52', '0', 'asf', null, '0', 'asdf', 'asdf'), ('6', '2019-01-29 23:30:08', null, '2019-01-29 23:30:08', '0', '闻气味', null, '0', '肉肉肉', '肉肉肉'), ('11', '2019-01-30 09:59:09', null, '2019-01-30 09:59:09', '0', 'asdfasdf', null, '0', 'asdfasdf', 'asdf'), ('10', '2019-01-30 09:59:03', null, '2019-01-30 09:59:03', '0', '123123', null, '0', 'rrrrr', 'rrrrrr'), ('14', '2019-01-30 22:12:32', null, '2019-01-30 22:12:32', '0', 'wewer', null, '0', 'efwe', 'wewe'), ('17', '2019-01-31 17:59:36', null, '2019-01-31 17:59:36', '0', '123', null, '0', '123', '123'), ('18', '2019-01-31 18:01:34', null, '2019-01-31 18:01:34', '0', '请问', null, '0', '闻气味', '请问'), ('19', '2019-02-12 15:52:32', null, '2019-02-12 15:52:32', '0', 'qer', null, '0', 'erq', 'qert'), ('20', '2019-02-13 15:11:22', null, '2019-02-13 22:17:44', '1', 'sdfb', null, '0', 'dfb俄文额外 v', 'sdfb');
COMMIT;

-- ----------------------------
--  Table structure for `settings`
-- ----------------------------
DROP TABLE IF EXISTS `settings`;
CREATE TABLE `settings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `setting_key` varchar(255) DEFAULT NULL,
  `setting_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `settings`
-- ----------------------------
BEGIN;
INSERT INTO `settings` VALUES ('1', '2019-03-21 18:51:54', null, '2019-03-21 18:51:54', '0', 'Cms标题', 'title', 'Jbone - 专注于微服务架构的技术交流和实践'), ('2', '2019-03-21 18:52:15', null, '2019-03-21 18:52:15', '0', '首页中间的大标题', 'home_title', 'Jbone'), ('3', '2019-03-21 18:52:33', null, '2019-03-21 18:52:33', '0', '首页的副标题', 'home_description', '专注于微服务架构的技术交流和实践'), ('4', '2019-03-21 18:52:57', null, '2019-03-21 18:52:57', '0', '网站说明', 'description', '基于spring cloud实现的微服务框架，更重在技术交流。'), ('5', '2019-03-21 18:53:16', null, '2019-03-21 18:53:16', '0', '网站关键字', 'keywords', '微服务,Spring Cloud,分布式,单点登陆'), ('6', '2019-03-21 18:53:33', null, '2019-03-21 18:53:33', '0', '网站导航左上角商标文字', 'brand', 'Jbone'), ('7', '2019-03-21 18:53:50', null, '2019-03-21 18:53:50', '0', 'github联系方式', 'contact_github', 'https://github.com/417511458/jbone'), ('8', '2019-03-21 18:54:07', null, '2019-03-21 18:54:07', '0', '版权信息', 'copyright', 'Copyright @ 马军伟 2019'), ('9', '2019-03-22 16:55:27', null, '2019-03-22 16:55:27', '0', '是否开启广告位', 'ads', 'true'), ('10', '2019-03-22 16:56:00', null, '2019-03-22 16:56:00', '0', '广告位图片', 'ads_img', 'http://static.majunwei.com/userfiles/201610292143075020/images/cms/article/2018/12/eureka_01.png'), ('11', '2019-03-22 16:56:57', null, '2019-03-22 16:56:57', '0', '广告位跳转链接', 'ads_url', 'https://github.com/417511458/jbone'), ('12', '2019-03-24 08:55:12', null, '2019-03-24 08:55:12', '0', '关于我', 'aboutme', 'Jbone');
COMMIT;

-- ----------------------------
--  Table structure for `tag`
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tag`
-- ----------------------------
BEGIN;
INSERT INTO `tag` VALUES ('1', '2019-01-30 23:13:43', '1', '2019-01-30 23:13:48', '1', 'Spring'), ('3', '2019-01-31 11:15:02', null, '2019-01-31 11:15:02', '0', '仿佛过'), ('6', '2019-01-31 14:19:04', null, '2019-01-31 14:19:04', '0', '23123'), ('7', '2019-01-31 14:19:54', null, '2019-01-31 14:19:54', '0', '5555'), ('43', '2019-02-13 22:12:13', null, '2019-02-13 22:12:13', '0', 'f'), ('9', '2019-01-31 14:28:52', null, '2019-02-12 18:28:57', '1', 'asdfasdf'), ('10', '2019-01-31 14:28:58', null, '2019-01-31 14:28:58', '0', '挖坟'), ('11', '2019-01-31 14:30:26', null, '2019-01-31 14:30:26', '0', '阿斯顿发'), ('12', '2019-01-31 14:36:21', null, '2019-01-31 14:36:21', '0', '阿斯顿发'), ('13', '2019-01-31 14:36:24', null, '2019-01-31 14:36:24', '0', '玩儿'), ('14', '2019-01-31 14:36:27', null, '2019-01-31 14:36:27', '0', '果然额头'), ('15', '2019-01-31 14:36:29', null, '2019-01-31 14:36:29', '0', '沃尔特'), ('16', '2019-01-31 14:36:31', null, '2019-01-31 14:36:31', '0', '儿童'), ('17', '2019-01-31 14:36:33', null, '2019-01-31 14:36:33', '0', '儿童'), ('18', '2019-01-31 14:36:36', null, '2019-01-31 14:36:36', '0', '而儿童'), ('19', '2019-01-31 14:36:38', null, '2019-01-31 14:36:38', '0', '请问'), ('20', '2019-02-12 15:11:07', null, '2019-02-12 15:11:07', '0', 'qweqwe'), ('21', '2019-02-12 15:52:17', null, '2019-02-12 15:52:17', '0', 'wqer'), ('22', '2019-02-12 15:54:40', null, '2019-02-12 15:54:40', '0', 'wrwer'), ('23', '2019-02-12 16:14:39', null, '2019-02-12 16:14:39', '0', 'asdf'), ('24', '2019-02-12 16:15:52', null, '2019-02-12 16:15:52', '0', 'sefwef'), ('25', '2019-02-12 16:20:28', null, '2019-02-12 16:20:28', '0', 'asdf'), ('26', '2019-02-12 16:23:54', null, '2019-02-12 16:23:54', '0', 'asdf'), ('27', '2019-02-12 16:26:57', null, '2019-02-12 16:26:57', '0', 'sdfsdf'), ('28', '2019-02-12 17:18:18', null, '2019-02-12 17:18:18', '0', 'asdfasdf'), ('29', '2019-02-12 17:19:13', null, '2019-02-12 17:19:13', '0', 'sdfasdf'), ('30', '2019-02-12 17:21:56', null, '2019-02-12 17:21:56', '0', 'asdf'), ('31', '2019-02-12 17:23:21', null, '2019-02-12 17:23:21', '0', 'sadf'), ('32', '2019-02-12 17:36:29', null, '2019-02-12 17:36:29', '0', 'asdf'), ('33', '2019-02-12 17:36:29', null, '2019-02-12 17:36:29', '0', 'asdf'), ('34', '2019-02-12 17:36:29', null, '2019-02-12 17:36:29', '0', 'asdf'), ('35', '2019-02-12 17:37:53', null, '2019-02-12 17:37:53', '0', 'sadf'), ('36', '2019-02-12 17:57:42', null, '2019-02-12 17:57:42', '0', 'asdf'), ('37', '2019-02-12 18:00:13', null, '2019-02-12 18:00:13', '0', 'asfd'), ('38', '2019-02-12 18:14:54', null, '2019-02-12 18:14:54', '0', 'asdf'), ('39', '2019-02-12 18:20:20', null, '2019-02-12 18:20:20', '0', 'asdf'), ('42', '2019-02-13 22:05:16', null, '2019-02-13 22:05:16', '0', 'asdfasdf');
COMMIT;

-- ----------------------------
--  Table structure for `template`
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `front_cover` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
