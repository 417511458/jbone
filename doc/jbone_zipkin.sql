CREATE DATABASE  IF NOT EXISTS `jbone_zipkin` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `jbone_zipkin`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: jbone_zipkin
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `zipkin_annotations`
--

DROP TABLE IF EXISTS `zipkin_annotations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zipkin_annotations` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint(20) NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int(11) NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint(20) DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int(11) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint(6) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_4` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_7` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_10` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_13` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_16` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_19` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_22` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_25` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_28` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_5` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_6` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_2` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_2` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_2` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_2` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_8` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_9` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_3` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_3` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_3` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_3` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_11` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_12` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_4` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_4` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_4` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_4` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_14` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_15` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_5` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_5` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_5` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_5` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_17` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_18` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_6` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_6` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_6` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_6` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_20` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_21` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_7` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_7` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_7` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_7` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_23` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_24` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_8` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_8` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_8` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_8` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job',
  KEY `trace_id_high_26` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_27` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name_9` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type_9` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key_9` (`a_key`) COMMENT 'for getTraces',
  KEY `trace_id_9` (`trace_id`,`span_id`,`a_key`) COMMENT 'for dependencies job'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `zipkin_dependencies`
--

DROP TABLE IF EXISTS `zipkin_dependencies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zipkin_dependencies` (
  `day` date NOT NULL,
  `parent` varchar(255) NOT NULL,
  `child` varchar(255) NOT NULL,
  `call_count` bigint(20) DEFAULT NULL,
  `error_count` bigint(20) DEFAULT NULL,
  UNIQUE KEY `day` (`day`,`parent`,`child`),
  UNIQUE KEY `day_2` (`day`,`parent`,`child`),
  UNIQUE KEY `day_3` (`day`,`parent`,`child`),
  UNIQUE KEY `day_4` (`day`,`parent`,`child`),
  UNIQUE KEY `day_5` (`day`,`parent`,`child`),
  UNIQUE KEY `day_6` (`day`,`parent`,`child`),
  UNIQUE KEY `day_7` (`day`,`parent`,`child`),
  UNIQUE KEY `day_8` (`day`,`parent`,`child`),
  UNIQUE KEY `day_9` (`day`,`parent`,`child`),
  UNIQUE KEY `day_10` (`day`,`parent`,`child`),
  UNIQUE KEY `day_11` (`day`,`parent`,`child`),
  UNIQUE KEY `day_12` (`day`,`parent`,`child`),
  UNIQUE KEY `day_13` (`day`,`parent`,`child`),
  UNIQUE KEY `day_14` (`day`,`parent`,`child`),
  UNIQUE KEY `day_15` (`day`,`parent`,`child`),
  UNIQUE KEY `day_16` (`day`,`parent`,`child`),
  UNIQUE KEY `day_17` (`day`,`parent`,`child`),
  UNIQUE KEY `day_18` (`day`,`parent`,`child`),
  UNIQUE KEY `day_19` (`day`,`parent`,`child`),
  UNIQUE KEY `day_20` (`day`,`parent`,`child`),
  UNIQUE KEY `day_21` (`day`,`parent`,`child`),
  UNIQUE KEY `day_22` (`day`,`parent`,`child`),
  UNIQUE KEY `day_23` (`day`,`parent`,`child`),
  UNIQUE KEY `day_24` (`day`,`parent`,`child`),
  UNIQUE KEY `day_25` (`day`,`parent`,`child`),
  UNIQUE KEY `day_26` (`day`,`parent`,`child`),
  UNIQUE KEY `day_27` (`day`,`parent`,`child`),
  UNIQUE KEY `day_28` (`day`,`parent`,`child`),
  UNIQUE KEY `day_29` (`day`,`parent`,`child`),
  UNIQUE KEY `day_30` (`day`,`parent`,`child`),
  UNIQUE KEY `day_31` (`day`,`parent`,`child`),
  UNIQUE KEY `day_32` (`day`,`parent`,`child`),
  UNIQUE KEY `day_33` (`day`,`parent`,`child`),
  UNIQUE KEY `day_34` (`day`,`parent`,`child`),
  UNIQUE KEY `day_35` (`day`,`parent`,`child`),
  UNIQUE KEY `day_36` (`day`,`parent`,`child`),
  UNIQUE KEY `day_37` (`day`,`parent`,`child`),
  UNIQUE KEY `day_38` (`day`,`parent`,`child`),
  UNIQUE KEY `day_39` (`day`,`parent`,`child`),
  UNIQUE KEY `day_40` (`day`,`parent`,`child`),
  UNIQUE KEY `day_41` (`day`,`parent`,`child`),
  UNIQUE KEY `day_42` (`day`,`parent`,`child`),
  UNIQUE KEY `day_43` (`day`,`parent`,`child`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `zipkin_spans`
--

DROP TABLE IF EXISTS `zipkin_spans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zipkin_spans` (
  `trace_id_high` bigint(20) NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `debug` bit(1) DEFAULT NULL,
  `start_ts` bigint(20) DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint(20) DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_4` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_7` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_10` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_13` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_16` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_19` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_22` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_25` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_28` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_31` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_34` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  UNIQUE KEY `trace_id_high_37` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_5` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_6` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_2` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_2` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_8` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_9` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_3` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_3` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_11` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_12` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_4` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_4` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_14` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_15` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_5` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_5` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_17` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_18` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_6` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_6` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_20` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_21` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_7` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_7` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_23` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_24` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_8` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_8` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_26` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_27` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_9` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_9` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_29` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_30` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_10` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_10` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_32` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_33` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_11` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_11` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_35` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_36` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_12` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts_12` (`start_ts`) COMMENT 'for getTraces ordering and range',
  KEY `trace_id_high_38` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_39` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name_13` (`name`) COMMENT 'for getTraces and getSpanNames'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-12 13:16:21
