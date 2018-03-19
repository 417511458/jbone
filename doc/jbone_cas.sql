CREATE DATABASE  IF NOT EXISTS `jbone_cas` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `jbone_cas`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: jbone_cas
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
-- Table structure for table `RegexRegisteredService`
--

DROP TABLE IF EXISTS `RegexRegisteredService`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegexRegisteredService` (
  `expression_type` varchar(50) NOT NULL DEFAULT 'regex',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access_strategy` longblob,
  `attribute_release` longblob,
  `description` varchar(255) DEFAULT NULL,
  `evaluation_order` int(11) NOT NULL,
  `expiration_policy` longblob,
  `informationUrl` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `logout_type` int(11) DEFAULT NULL,
  `logout_url` varchar(255) DEFAULT NULL,
  `mfa_policy` longblob,
  `name` varchar(255) NOT NULL,
  `privacyUrl` varchar(255) DEFAULT NULL,
  `proxy_policy` longblob,
  `public_key` longblob,
  `required_handlers` longblob,
  `serviceId` varchar(255) NOT NULL,
  `theme` varchar(255) DEFAULT NULL,
  `username_attr` longblob,
  `bypassApprovalPrompt` bit(1) DEFAULT NULL,
  `clientId` varchar(255) DEFAULT NULL,
  `clientSecret` varchar(255) DEFAULT NULL,
  `generateRefreshToken` bit(1) DEFAULT NULL,
  `jsonFormat` bit(1) DEFAULT NULL,
  `supported_grants` longblob,
  `supported_responses` longblob,
  `DYNAMIC_REG_TIME` datetime DEFAULT NULL,
  `dynamicallyRegistered` bit(1) DEFAULT NULL,
  `encryptIdToken` bit(1) DEFAULT NULL,
  `idTokenEncryptionAlg` varchar(255) DEFAULT NULL,
  `idTokenEncryptionEncoding` varchar(255) DEFAULT NULL,
  `implicit` bit(1) DEFAULT NULL,
  `jwks` varchar(255) DEFAULT NULL,
  `scopes` longblob,
  `sectorIdentifierUri` varchar(255) DEFAULT NULL,
  `signIdToken` bit(1) DEFAULT NULL,
  `subjectType` varchar(255) DEFAULT NULL,
  `encryptAssertions` bit(1) DEFAULT NULL,
  `metadataCriteriaDirection` varchar(255) DEFAULT NULL,
  `metadataCriteriaPattern` varchar(255) DEFAULT NULL,
  `metadataCriteriaRemoveEmptyEntitiesDescriptors` bit(1) DEFAULT NULL,
  `metadataCriteriaRemoveRolelessEntityDescriptors` bit(1) DEFAULT NULL,
  `metadataCriteriaRoles` varchar(255) DEFAULT NULL,
  `metadataExpirationDuration` varchar(255) DEFAULT NULL,
  `metadataLocation` varchar(255) DEFAULT NULL,
  `metadataMaxValidity` bigint(20) DEFAULT NULL,
  `metadataSignatureLocation` varchar(255) DEFAULT NULL,
  `nameIdQualifier` varchar(255) DEFAULT NULL,
  `requiredAuthenticationContextClass` varchar(255) DEFAULT NULL,
  `requiredNameIdFormat` varchar(255) DEFAULT NULL,
  `serviceProviderNameIdQualifier` varchar(255) DEFAULT NULL,
  `signAssertions` bit(1) DEFAULT NULL,
  `signResponses` bit(1) DEFAULT NULL,
  `signingCredentialType` varchar(255) DEFAULT NULL,
  `skipGeneratingAssertionNameId` bit(1) DEFAULT NULL,
  `skipGeneratingSubjectConfirmationInResponseTo` bit(1) DEFAULT NULL,
  `skipGeneratingSubjectConfirmationNotBefore` bit(1) DEFAULT NULL,
  `skipGeneratingSubjectConfirmationNotOnOrAfter` bit(1) DEFAULT NULL,
  `skipGeneratingSubjectConfirmationRecipient` bit(1) DEFAULT NULL,
  `addressingNamespace` varchar(255) DEFAULT NULL,
  `appliesTo` varchar(255) DEFAULT NULL,
  `namespace` varchar(255) DEFAULT NULL,
  `policyNamespace` varchar(255) DEFAULT NULL,
  `protocol` varchar(255) DEFAULT NULL,
  `realm` varchar(255) DEFAULT NULL,
  `tokenType` varchar(255) DEFAULT NULL,
  `wsdlEndpoint` varchar(255) DEFAULT NULL,
  `wsdlLocation` varchar(255) DEFAULT NULL,
  `wsdlService` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegexRegisteredService`
--

LOCK TABLES `RegexRegisteredService` WRITE;
/*!40000 ALTER TABLE `RegexRegisteredService` DISABLE KEYS */;
INSERT INTO `RegexRegisteredService` VALUES ('regex',3,'¨\Ì\0sr\0>org.apereo.cas.services.DefaultRegisteredServiceAccessStrategyH\ V(≠\0Z\0caseInsensitiveZ\0enabledI\0orderZ\0requireAllAttributesZ\0\nssoEnabledL\0rejectedAttributest\0Ljava/util/Map;L\0requiredAttributesq\0~\0L\0unauthorizedRedirectUrlt\0Ljava/net/URI;xp\0\0\0\0\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xp','¨\Ì\0sr\0;org.apereo.cas.services.ReturnAllowedAttributeReleasePolicyØ\Áìœ¶\'\0L\0allowedAttributest\0Ljava/util/List;xr\0Gorg.apereo.cas.services.AbstractRegisteredServiceAttributeReleasePolicyI\Á\÷slõ\0Z\0+authorizedToReleaseAuthenticationAttributesZ\0%authorizedToReleaseCredentialPasswordZ\0&authorizedToReleaseProxyGrantingTicketZ\0excludeDefaultAttributesL\0\rconsentPolicyt\08Lorg/apereo/cas/services/RegisteredServiceConsentPolicy;L\0principalAttributesRepositoryt\0GLorg/apereo/cas/authentication/principal/PrincipalAttributesRepository;L\0principalIdAttributet\0Ljava/lang/String;L\0 registeredServiceAttributeFiltert\0:Lorg/apereo/cas/services/RegisteredServiceAttributeFilter;xp\0\0\0sr\0Eorg.apereo.cas.services.consent.DefaultRegisteredServiceConsentPolicyŸâ°‘øI\0Z\0enabledL\0excludedAttributest\0Ljava/util/Set;L\0includeOnlyAttributesq\0~\0	xpppsr\0Lorg.apereo.cas.authentication.principal.DefaultPrincipalAttributesRepository¡+(r_™É\0\0xr\0Sorg.apereo.cas.authentication.principal.cache.AbstractPrincipalAttributesRepositoryX öƒ§0b\0J\0\nexpirationL\0mergingStrategyt\0eLorg/apereo/cas/authentication/principal/cache/AbstractPrincipalAttributesRepository$MergingStrategy;L\0timeUnitq\0~\0xp\0\0\0\0\0\0\0pt\0HOURSppsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','JboneÊúçÂä°ÁõëÊéß',1,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceExpirationPolicyF\ﬁy¨ç<\Ã\0Z\0deleteWhenExpiredZ\0notifyWhenDeletedL\0expirationDatet\0Ljava/lang/String;xp\0\0p',NULL,NULL,1,'http://jbone-sm-monitor.majunwei.com:10003/casLogout','¨\Ì\0sr\0Aorg.apereo.cas.services.DefaultRegisteredServiceMultifactorPolicy\’j\‚›àYs?\0Z\0\rbypassEnabledL\0failureModet\0ILorg/apereo/cas/services/RegisteredServiceMultifactorPolicy$FailureModes;L\0\"multifactorAuthenticationProviderst\0Ljava/util/Set;L\0principalAttributeNameTriggert\0Ljava/lang/String;L\0principalAttributeValueToMatchq\0~\0xp\0~r\0Gorg.apereo.cas.services.RegisteredServiceMultifactorPolicy$FailureModes\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0NOT_SETsr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0xpp','Jbone  Âä°ÁõëÊéß',NULL,'¨\Ì\0sr\0:org.apereo.cas.services.RefuseRegisteredServiceProxyPolicy∞§\0n\√X\ÊT\0\0xp',NULL,'¨\Ì\0sr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0x','^http://jbone-sm-monitor.majunwei.com:10003/cas',NULL,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceUsernameProviderP\“˜F%ôaW\0\0xr\0Forg.apereo.cas.services.BaseRegisteredServiceUsernameAttributeProviderãØ∫úwV8q\0Z\0encryptUsernameL\0canonicalizationModet\0Ljava/lang/String;xp\0t\0NONE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('regex',4,'¨\Ì\0sr\0>org.apereo.cas.services.DefaultRegisteredServiceAccessStrategyH\ V(≠\0Z\0caseInsensitiveZ\0enabledI\0orderZ\0requireAllAttributesZ\0\nssoEnabledL\0rejectedAttributest\0Ljava/util/Map;L\0requiredAttributesq\0~\0L\0unauthorizedRedirectUrlt\0Ljava/net/URI;xp\0\0\0\0\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xp','¨\Ì\0sr\0;org.apereo.cas.services.ReturnAllowedAttributeReleasePolicyØ\Áìœ¶\'\0L\0allowedAttributest\0Ljava/util/List;xr\0Gorg.apereo.cas.services.AbstractRegisteredServiceAttributeReleasePolicyI\Á\÷slõ\0Z\0+authorizedToReleaseAuthenticationAttributesZ\0%authorizedToReleaseCredentialPasswordZ\0&authorizedToReleaseProxyGrantingTicketZ\0excludeDefaultAttributesL\0\rconsentPolicyt\08Lorg/apereo/cas/services/RegisteredServiceConsentPolicy;L\0principalAttributesRepositoryt\0GLorg/apereo/cas/authentication/principal/PrincipalAttributesRepository;L\0principalIdAttributet\0Ljava/lang/String;L\0 registeredServiceAttributeFiltert\0:Lorg/apereo/cas/services/RegisteredServiceAttributeFilter;xp\0\0\0sr\0Eorg.apereo.cas.services.consent.DefaultRegisteredServiceConsentPolicyŸâ°‘øI\0Z\0enabledL\0excludedAttributest\0Ljava/util/Set;L\0includeOnlyAttributesq\0~\0	xpppsr\0Lorg.apereo.cas.authentication.principal.DefaultPrincipalAttributesRepository¡+(r_™É\0\0xr\0Sorg.apereo.cas.authentication.principal.cache.AbstractPrincipalAttributesRepositoryX öƒ§0b\0J\0\nexpirationL\0mergingStrategyt\0eLorg/apereo/cas/authentication/principal/cache/AbstractPrincipalAttributesRepository$MergingStrategy;L\0timeUnitq\0~\0xp\0\0\0\0\0\0\0pt\0HOURSppsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','JboneÊúçÂä°ÁÆ°ÁêÜ',1,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceExpirationPolicyF\ﬁy¨ç<\Ã\0Z\0deleteWhenExpiredZ\0notifyWhenDeletedL\0expirationDatet\0Ljava/lang/String;xp\0\0p',NULL,NULL,1,'http://jbone-sm-admin.majunwei.com:10002/casLogout','¨\Ì\0sr\0Aorg.apereo.cas.services.DefaultRegisteredServiceMultifactorPolicy\’j\‚›àYs?\0Z\0\rbypassEnabledL\0failureModet\0ILorg/apereo/cas/services/RegisteredServiceMultifactorPolicy$FailureModes;L\0\"multifactorAuthenticationProviderst\0Ljava/util/Set;L\0principalAttributeNameTriggert\0Ljava/lang/String;L\0principalAttributeValueToMatchq\0~\0xp\0~r\0Gorg.apereo.cas.services.RegisteredServiceMultifactorPolicy$FailureModes\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0NOT_SETsr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0xpp','JboneÊúçÂä°ÁÆ°ÁêÜ',NULL,'¨\Ì\0sr\0:org.apereo.cas.services.RefuseRegisteredServiceProxyPolicy∞§\0n\√X\ÊT\0\0xp',NULL,'¨\Ì\0sr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0x','^http://jbone-sm-admin.majunwei.com:10002/cas',NULL,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceUsernameProviderP\“˜F%ôaW\0\0xr\0Forg.apereo.cas.services.BaseRegisteredServiceUsernameAttributeProviderãØ∫úwV8q\0Z\0encryptUsernameL\0canonicalizationModet\0Ljava/lang/String;xp\0t\0NONE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('regex',5,'¨\Ì\0sr\0>org.apereo.cas.services.DefaultRegisteredServiceAccessStrategyH\ V(≠\0Z\0caseInsensitiveZ\0enabledI\0orderZ\0requireAllAttributesZ\0\nssoEnabledL\0rejectedAttributest\0Ljava/util/Map;L\0requiredAttributesq\0~\0L\0unauthorizedRedirectUrlt\0Ljava/net/URI;xp\0\0\0\0\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xp','¨\Ì\0sr\0;org.apereo.cas.services.ReturnAllowedAttributeReleasePolicyØ\Áìœ¶\'\0L\0allowedAttributest\0Ljava/util/List;xr\0Gorg.apereo.cas.services.AbstractRegisteredServiceAttributeReleasePolicyI\Á\÷slõ\0Z\0+authorizedToReleaseAuthenticationAttributesZ\0%authorizedToReleaseCredentialPasswordZ\0&authorizedToReleaseProxyGrantingTicketZ\0excludeDefaultAttributesL\0\rconsentPolicyt\08Lorg/apereo/cas/services/RegisteredServiceConsentPolicy;L\0principalAttributesRepositoryt\0GLorg/apereo/cas/authentication/principal/PrincipalAttributesRepository;L\0principalIdAttributet\0Ljava/lang/String;L\0 registeredServiceAttributeFiltert\0:Lorg/apereo/cas/services/RegisteredServiceAttributeFilter;xp\0\0\0sr\0Eorg.apereo.cas.services.consent.DefaultRegisteredServiceConsentPolicyŸâ°‘øI\0Z\0enabledL\0excludedAttributest\0Ljava/util/Set;L\0includeOnlyAttributesq\0~\0	xpppsr\0Lorg.apereo.cas.authentication.principal.DefaultPrincipalAttributesRepository¡+(r_™É\0\0xr\0Sorg.apereo.cas.authentication.principal.cache.AbstractPrincipalAttributesRepositoryX öƒ§0b\0J\0\nexpirationL\0mergingStrategyt\0eLorg/apereo/cas/authentication/principal/cache/AbstractPrincipalAttributesRepository$MergingStrategy;L\0timeUnitq\0~\0xp\0\0\0\0\0\0\0pt\0HOURSppsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','JboneÁ≥ªÁªüÁÆ°ÁêÜ',1,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceExpirationPolicyF\ﬁy¨ç<\Ã\0Z\0deleteWhenExpiredZ\0notifyWhenDeletedL\0expirationDatet\0Ljava/lang/String;xp\0\0p',NULL,NULL,1,'http://jbone-sys-admin.majunwei.com:20002/casLogout','¨\Ì\0sr\0Aorg.apereo.cas.services.DefaultRegisteredServiceMultifactorPolicy\’j\‚›àYs?\0Z\0\rbypassEnabledL\0failureModet\0ILorg/apereo/cas/services/RegisteredServiceMultifactorPolicy$FailureModes;L\0\"multifactorAuthenticationProviderst\0Ljava/util/Set;L\0principalAttributeNameTriggert\0Ljava/lang/String;L\0principalAttributeValueToMatchq\0~\0xp\0~r\0Gorg.apereo.cas.services.RegisteredServiceMultifactorPolicy$FailureModes\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0NOT_SETsr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0xpp','JboneÁ≥ªÁªüÁÆ°ÁêÜ',NULL,'¨\Ì\0sr\0:org.apereo.cas.services.RefuseRegisteredServiceProxyPolicy∞§\0n\√X\ÊT\0\0xp',NULL,'¨\Ì\0sr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0x','^http://jbone-sys-admin.majunwei.com:20002/cas',NULL,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceUsernameProviderP\“˜F%ôaW\0\0xr\0Forg.apereo.cas.services.BaseRegisteredServiceUsernameAttributeProviderãØ∫úwV8q\0Z\0encryptUsernameL\0canonicalizationModet\0Ljava/lang/String;xp\0t\0NONE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('regex',6,'¨\Ì\0sr\0>org.apereo.cas.services.DefaultRegisteredServiceAccessStrategyH\ V(≠\0Z\0caseInsensitiveZ\0enabledI\0orderZ\0requireAllAttributesZ\0\nssoEnabledL\0rejectedAttributest\0Ljava/util/Map;L\0requiredAttributesq\0~\0L\0unauthorizedRedirectUrlt\0Ljava/net/URI;xp\0\0\0\0\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xp','¨\Ì\0sr\0;org.apereo.cas.services.ReturnAllowedAttributeReleasePolicyØ\Áìœ¶\'\0L\0allowedAttributest\0Ljava/util/List;xr\0Gorg.apereo.cas.services.AbstractRegisteredServiceAttributeReleasePolicyI\Á\÷slõ\0Z\0+authorizedToReleaseAuthenticationAttributesZ\0%authorizedToReleaseCredentialPasswordZ\0&authorizedToReleaseProxyGrantingTicketZ\0excludeDefaultAttributesL\0\rconsentPolicyt\08Lorg/apereo/cas/services/RegisteredServiceConsentPolicy;L\0principalAttributesRepositoryt\0GLorg/apereo/cas/authentication/principal/PrincipalAttributesRepository;L\0principalIdAttributet\0Ljava/lang/String;L\0 registeredServiceAttributeFiltert\0:Lorg/apereo/cas/services/RegisteredServiceAttributeFilter;xp\0\0\0sr\0Eorg.apereo.cas.services.consent.DefaultRegisteredServiceConsentPolicyŸâ°‘øI\0Z\0enabledL\0excludedAttributest\0Ljava/util/Set;L\0includeOnlyAttributesq\0~\0	xpppsr\0Lorg.apereo.cas.authentication.principal.DefaultPrincipalAttributesRepository¡+(r_™É\0\0xr\0Sorg.apereo.cas.authentication.principal.cache.AbstractPrincipalAttributesRepositoryX öƒ§0b\0J\0\nexpirationL\0mergingStrategyt\0eLorg/apereo/cas/authentication/principal/cache/AbstractPrincipalAttributesRepository$MergingStrategy;L\0timeUnitq\0~\0xp\0\0\0\0\0\0\0pt\0HOURSppsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','JboneÂçïÁÇπÁôªÂΩïÁÆ°ÁêÜ',1,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceExpirationPolicyF\ﬁy¨ç<\Ã\0Z\0deleteWhenExpiredZ\0notifyWhenDeletedL\0expirationDatet\0Ljava/lang/String;xp\0\0p',NULL,NULL,1,'http://jbone-cas-manager.majunwei.com:30002/casLogout','¨\Ì\0sr\0Aorg.apereo.cas.services.DefaultRegisteredServiceMultifactorPolicy\’j\‚›àYs?\0Z\0\rbypassEnabledL\0failureModet\0ILorg/apereo/cas/services/RegisteredServiceMultifactorPolicy$FailureModes;L\0\"multifactorAuthenticationProviderst\0Ljava/util/Set;L\0principalAttributeNameTriggert\0Ljava/lang/String;L\0principalAttributeValueToMatchq\0~\0xp\0~r\0Gorg.apereo.cas.services.RegisteredServiceMultifactorPolicy$FailureModes\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0NOT_SETsr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0xpp','JboneÂçïÁÇπÁôªÂΩïÁÆ°ÁêÜ',NULL,'¨\Ì\0sr\0:org.apereo.cas.services.RefuseRegisteredServiceProxyPolicy∞§\0n\√X\ÊT\0\0xp',NULL,'¨\Ì\0sr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0x','^http://jbone-cas-manager.majunwei.com:30002/cas',NULL,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceUsernameProviderP\“˜F%ôaW\0\0xr\0Forg.apereo.cas.services.BaseRegisteredServiceUsernameAttributeProviderãØ∫úwV8q\0Z\0encryptUsernameL\0canonicalizationModet\0Ljava/lang/String;xp\0t\0NONE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('regex',7,'¨\Ì\0sr\0>org.apereo.cas.services.DefaultRegisteredServiceAccessStrategyH\ V(≠\0Z\0caseInsensitiveZ\0enabledI\0orderZ\0requireAllAttributesZ\0\nssoEnabledL\0rejectedAttributest\0Ljava/util/Map;L\0requiredAttributesq\0~\0L\0unauthorizedRedirectUrlt\0Ljava/net/URI;xp\0\0\0\0\0sr\0java.util.HashMap\⁄¡\√`\—\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xsq\0~\0?@\0\0\0\0\0\0w\0\0\0\0\0\0\0xp','¨\Ì\0sr\0;org.apereo.cas.services.ReturnAllowedAttributeReleasePolicyØ\Áìœ¶\'\0L\0allowedAttributest\0Ljava/util/List;xr\0Gorg.apereo.cas.services.AbstractRegisteredServiceAttributeReleasePolicyI\Á\÷slõ\0Z\0+authorizedToReleaseAuthenticationAttributesZ\0%authorizedToReleaseCredentialPasswordZ\0&authorizedToReleaseProxyGrantingTicketZ\0excludeDefaultAttributesL\0\rconsentPolicyt\08Lorg/apereo/cas/services/RegisteredServiceConsentPolicy;L\0principalAttributesRepositoryt\0GLorg/apereo/cas/authentication/principal/PrincipalAttributesRepository;L\0principalIdAttributet\0Ljava/lang/String;L\0 registeredServiceAttributeFiltert\0:Lorg/apereo/cas/services/RegisteredServiceAttributeFilter;xp\0\0\0sr\0Eorg.apereo.cas.services.consent.DefaultRegisteredServiceConsentPolicyŸâ°‘øI\0Z\0enabledL\0excludedAttributest\0Ljava/util/Set;L\0includeOnlyAttributesq\0~\0	xpppsr\0Lorg.apereo.cas.authentication.principal.DefaultPrincipalAttributesRepository¡+(r_™É\0\0xr\0Sorg.apereo.cas.authentication.principal.cache.AbstractPrincipalAttributesRepositoryX öƒ§0b\0J\0\nexpirationL\0mergingStrategyt\0eLorg/apereo/cas/authentication/principal/cache/AbstractPrincipalAttributesRepository$MergingStrategy;L\0timeUnitq\0~\0xp\0\0\0\0\0\0\0pt\0HOURSppsr\0java.util.ArrayListxÅ\“ô\«aù\0I\0sizexp\0\0\0\0w\0\0\0\0x','Services Management Web Application',0,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceExpirationPolicyF\ﬁy¨ç<\Ã\0Z\0deleteWhenExpiredZ\0notifyWhenDeletedL\0expirationDatet\0Ljava/lang/String;xp\0\0p',NULL,NULL,1,NULL,'¨\Ì\0sr\0Aorg.apereo.cas.services.DefaultRegisteredServiceMultifactorPolicy\’j\‚›àYs?\0Z\0\rbypassEnabledL\0failureModet\0ILorg/apereo/cas/services/RegisteredServiceMultifactorPolicy$FailureModes;L\0\"multifactorAuthenticationProviderst\0Ljava/util/Set;L\0principalAttributeNameTriggert\0Ljava/lang/String;L\0principalAttributeValueToMatchq\0~\0xp\0~r\0Gorg.apereo.cas.services.RegisteredServiceMultifactorPolicy$FailureModes\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0NOT_SETsr\0java.util.LinkedHashSet\ÿl\◊Zï\›*\0\0xr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0xpp','Services Management Web Application',NULL,'¨\Ì\0sr\0:org.apereo.cas.services.RefuseRegisteredServiceProxyPolicy∞§\0n\√X\ÊT\0\0xp',NULL,'¨\Ì\0sr\0java.util.HashSet∫DÖïñ∏∑4\0\0xpw\0\0\0?@\0\0\0\0\0\0x','^https://jbone-cas-manager.majunwei.com:30002/cas-management/manage.html',NULL,'¨\Ì\0sr\0@org.apereo.cas.services.DefaultRegisteredServiceUsernameProviderP\“˜F%ôaW\0\0xr\0Forg.apereo.cas.services.BaseRegisteredServiceUsernameAttributeProviderãØ∫úwV8q\0Z\0encryptUsernameL\0canonicalizationModet\0Ljava/lang/String;xp\0t\0NONE',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `RegexRegisteredService` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RegexRegisteredServiceProperty`
--

DROP TABLE IF EXISTS `RegexRegisteredServiceProperty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegexRegisteredServiceProperty` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `property_values` longblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegexRegisteredServiceProperty`
--

LOCK TABLES `RegexRegisteredServiceProperty` WRITE;
/*!40000 ALTER TABLE `RegexRegisteredServiceProperty` DISABLE KEYS */;
/*!40000 ALTER TABLE `RegexRegisteredServiceProperty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RegisteredServiceImplContact`
--

DROP TABLE IF EXISTS `RegisteredServiceImplContact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegisteredServiceImplContact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegisteredServiceImplContact`
--

LOCK TABLES `RegisteredServiceImplContact` WRITE;
/*!40000 ALTER TABLE `RegisteredServiceImplContact` DISABLE KEYS */;
/*!40000 ALTER TABLE `RegisteredServiceImplContact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RegisteredServiceImpl_Props`
--

DROP TABLE IF EXISTS `RegisteredServiceImpl_Props`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegisteredServiceImpl_Props` (
  `AbstractRegisteredService_id` bigint(20) NOT NULL,
  `properties_id` bigint(20) NOT NULL,
  `properties_KEY` varchar(255) NOT NULL,
  PRIMARY KEY (`AbstractRegisteredService_id`,`properties_KEY`),
  UNIQUE KEY `UK_i2mjaqjwxpvurc6aefjkx5x97` (`properties_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegisteredServiceImpl_Props`
--

LOCK TABLES `RegisteredServiceImpl_Props` WRITE;
/*!40000 ALTER TABLE `RegisteredServiceImpl_Props` DISABLE KEYS */;
/*!40000 ALTER TABLE `RegisteredServiceImpl_Props` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RegisteredService_Contacts`
--

DROP TABLE IF EXISTS `RegisteredService_Contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RegisteredService_Contacts` (
  `AbstractRegisteredService_id` bigint(20) NOT NULL,
  `contacts_id` bigint(20) NOT NULL,
  `contacts_ORDER` int(11) NOT NULL,
  PRIMARY KEY (`AbstractRegisteredService_id`,`contacts_ORDER`),
  UNIQUE KEY `UK_s7mf4a23wejqx62tt4vh3tgwi` (`contacts_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RegisteredService_Contacts`
--

LOCK TABLES `RegisteredService_Contacts` WRITE;
/*!40000 ALTER TABLE `RegisteredService_Contacts` DISABLE KEYS */;
/*!40000 ALTER TABLE `RegisteredService_Contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SERVICETICKET`
--

DROP TABLE IF EXISTS `SERVICETICKET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SERVICETICKET` (
  `TYPE` varchar(31) NOT NULL,
  `ID` varchar(255) NOT NULL,
  `NUMBER_OF_TIMES_USED` int(11) DEFAULT NULL,
  `CREATION_TIME` datetime DEFAULT NULL,
  `EXPIRATION_POLICY` longblob NOT NULL,
  `LAST_TIME_USED` datetime DEFAULT NULL,
  `PREVIOUS_LAST_TIME_USED` datetime DEFAULT NULL,
  `FROM_NEW_LOGIN` bit(1) NOT NULL,
  `TICKET_ALREADY_GRANTED` bit(1) NOT NULL,
  `SERVICE` longblob NOT NULL,
  `ticketGrantingTicket_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK60oigifivx01ts3n8vboyqs38` (`ticketGrantingTicket_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SERVICETICKET`
--

LOCK TABLES `SERVICETICKET` WRITE;
/*!40000 ALTER TABLE `SERVICETICKET` DISABLE KEYS */;
/*!40000 ALTER TABLE `SERVICETICKET` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TICKETGRANTINGTICKET`
--

DROP TABLE IF EXISTS `TICKETGRANTINGTICKET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TICKETGRANTINGTICKET` (
  `TYPE` varchar(31) NOT NULL,
  `ID` varchar(255) NOT NULL,
  `NUMBER_OF_TIMES_USED` int(11) DEFAULT NULL,
  `CREATION_TIME` datetime DEFAULT NULL,
  `EXPIRATION_POLICY` longblob NOT NULL,
  `LAST_TIME_USED` datetime DEFAULT NULL,
  `PREVIOUS_LAST_TIME_USED` datetime DEFAULT NULL,
  `AUTHENTICATION` longblob NOT NULL,
  `DESCENDANT_TICKETS` longblob NOT NULL,
  `EXPIRED` bit(1) NOT NULL,
  `PROXIED_BY` longblob,
  `PROXY_GRANTING_TICKETS` longblob NOT NULL,
  `SERVICES_GRANTED_ACCESS_TO` longblob NOT NULL,
  `ticketGrantingTicket_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKiqyu3qw2fxf5qaqin02mox8r4` (`ticketGrantingTicket_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TICKETGRANTINGTICKET`
--

LOCK TABLES `TICKETGRANTINGTICKET` WRITE;
/*!40000 ALTER TABLE `TICKETGRANTINGTICKET` DISABLE KEYS */;
/*!40000 ALTER TABLE `TICKETGRANTINGTICKET` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locks`
--

DROP TABLE IF EXISTS `locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locks` (
  `application_id` varchar(255) NOT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `unique_id` varchar(255) DEFAULT NULL,
  `lockVer` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`application_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locks`
--

LOCK TABLES `locks` WRITE;
/*!40000 ALTER TABLE `locks` DISABLE KEYS */;
INSERT INTO `locks` VALUES ('cas-ticket-registry-cleaner',NULL,NULL,117);
/*!40000 ALTER TABLE `locks` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-19 21:33:09
