![Jbone功能架构图](doc/images/logo-text.png)

[项目官网](http://jbone.cn)（基于jbone cms构建)

[作者简历](http://majunwei.jbone.cn)（基于jbone cms构建)

[开发文档](http://jbone.cn/category/development_document)

[部署文档](http://jbone.cn/category/deployment_document)

jbone主要关注两个方面，一个是微服务架构的落地实现，另一个更重要的是进行深入的技术探究。

# jbone定位
## 学习交流探技术
随着微服务的发展，出现了很多微服务架构的解决方案，Spring Cloud就是其中的典型代表。jbone是基于Spring Cloud搭建的微服务项目，包括服务注册与发现、服务监控、服务管理、服务网关、服务熔断等常见微服务组件。 除Spring Cloud以外，会根据业务特点选择合适的解决方案，如单点登录的CAS、安全框架Shiro等。具体参考《技术选型》。

jbone项目主要关注两个方面的技术交流：
* 功能实现：了解技术组件并落地实现，为相同技术选型的项目，提供实现参考。
* 技术探究：实现功能的同时，针对选择的技术框架进行深入探究，使用的同时获得技术提升。知道How to use,更要知道How it works。（技术探究文章会以专题文章的形式发表到jbone官网）
## 落地实现造轮子
造轮子的成本非常高，企业快速的业务发展，更想拿来即用。jbone在技术交流的过程中会沉淀出很多轮子，如服务治理、系统管理、内容管理、电商平台等解决方案。使中小企业花最少的成本建立自己的服务治理体系、电商平台、企业管理平台、支付平台等。
# 交流方式

项目官网：[http://jbone.cn](http://jbone.cn)（基于jbone cms构建)

QQ群：992113778（2群）、547104190（1群）

公众号：writebugs

作者QQ：417511458

作者微信：dreamming_now

微信群：先添加作者好友再加入

# 系统简介
## 系统要求
**JDK11+**


## 系统设计
### jbone功能架构图
![Jbone功能架构图](doc/images/features.png)

### 项目模块划分
* jbone-cas : 用户单点登录模块
    * jbone-cas-client：客户端jar包，用于系统集成单点登录
    * jbone-cas-server：CAS服务端，单独部署，用于单点登录、服务授权、找回密码等
* jbone-sm : 服务管理模块
    * jbone-sm-admin : 服务管理系统，包括服务监控、服务管理等
    * jbone-sm-gateway: 服务网关
    * jbone-sm-monitor: 服务监控
    * jbone-sm-register : 服务注册中心，原则上所有服务都要注册进来
    * jbone-sm-zipkinserver : 基于zipkin的调用链跟踪系统
* jbone-sys : 系统管理模块
    * jbone-sys-admin ： 系统管理后台
    * jbone-sys-api : 系统服务对外接口定义
    * jbone-sys-api-starter : 系统服务接口启动器，引入jar包即可调用系统服务
    * jbone-sys-core : 系统管理核心
    * jbone-sys-common : 系统管理公共模块
    * jbone-sys-server : 系统管理服务
* jbone-cms ：内容管理模块
    * jbone-cms-admin: cms后台管理
    * jbone-cms-api: cms对外接口定义
    * jbone-cms-api-starter: cms对外接口启动器，引入jar包接口调用cms服务
    * jbone-cms-common: cms公共模块
    * jbone-cms-core: cms核心模块
    * jbone-cms-portal: cms前端
    * jbone-cms-server: cms后端服务
* jbone-bpm : 工作流模块(未完成)
* jbone-common : 公共模块
* jbone-configuration : 公共配置模块
* jbone-b2b2c : 多店铺电商平台模块 (未完成)
* jbone-ui : 以webjars形式管理前端静态资源，所有包含页面的工程需要依赖此模块。

### 技术选型
技术 | 简介 | 网址
---- | ------ | ----
Spring Boot | 基础构建框架，用于快速整合各资源 | [https://projects.spring.io/spring-boot/](https://projects.spring.io/spring-boot/)
Spring Framework | 底层容器 |  [https://projects.spring.io/spring-framework/](https://projects.spring.io/spring-framework/)
Spring Cloud | 微服务框架 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)
Spring Cloud Eureka | 服务注册中心 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)
Spring Cloud Zuul | 服务网关 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)
Spring Cloud Hystrix | 服务容错框架 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)
Spring Cloud Feign | 微服务声明式调用框架 | [https://projects.spring.io/spring-cloud/](https://projects.spring.io/spring-cloud/)
Spring Boot Admin | 服务管理中心 | [https://github.com/codecentric/spring-boot-admin](https://github.com/codecentric/spring-boot-admin)
Spring Data Jpa | 持久化框架 | [https://projects.spring.io/spring-data-jpa/](https://projects.spring.io/spring-data-jpa/)
Spring Data Redis | 缓存框架 | [https://projects.spring.io/spring-data-redis/](https://projects.spring.io/spring-data-redis/)
Apache Shiro | 安全框架 | [http://shiro.apache.org/](http://shiro.apache.org/)
thymeleaf-extras-shiro | thymeleaf的shiro标签 | [https://github.com/theborakompanioni/thymeleaf-extras-shiro](https://github.com/theborakompanioni/thymeleaf-extras-shiro)
Apereo CAS | 单点登陆框架 | [https://github.com/apereo/cas](https://github.com/apereo/cas)
Spring Validator | 后端验证框架 | [https://projects.spring.io/spring-framework/](https://projects.spring.io/spring-framework/)
Hibernate Validator | Hibernate验证框架 | [http://hibernate.org/](http://hibernate.org/)
lombok | 一个通过注解自动生成get/set方法的类库 | [https://projectlombok.org/](https://projectlombok.org/)
webjars | 以jars的形式管理前端静态资源 | [http://www.webjars.org/](http://www.webjars.org/)
Thymeleaf | 模板引擎  | [http://www.thymeleaf.org/](http://www.thymeleaf.org/)
Maven | 项目构建管理  | [http://maven.apache.org/](http://maven.apache.org/)
Redis | 分布式缓存数据库 | [https://redis.io/](https://redis.io/)
Mysql | 对象关系数据库 | [https://www.mysql.com/](https://www.mysql.com/)

## 功能预览
### Jbone CAS(认证中心)
![CAS登录](doc/images/loginview.png)
### Jbone SM Admin(服务管理中心)
**系统监控墙**

![系统监控墙](doc/images/bootadmin-wallboard.png)

**系统详情**

![系统详情](doc/images/bootadmin-instancedetails.png)

**JVM线程监控**

![JVM线程监控](doc/images/bootadmin-instancethread.png)

**Hystrix流量和熔断监控**
![Hystrix流量和熔断监控](doc/images/hystrix监控.png)

### 调用链跟踪
![trace](doc/images/zipkin_01.png)

### Jbone系统管理
**系统管理**
![Jbone系统管理](doc/images/systemManager.png)
**用户管理**
![用户管理](doc/images/userManager.png)
**角色管理**
![角色管理](doc/images/roleManager.png)
**菜单管理**
![菜单管理](doc/images/menuManager.png)
**权限管理**
![权限管理](doc/images/permissionManager.png)

### Jbone CMS（内容管理系统）
**首页**
![Jbone CMS首页](doc/images/cms_index.png)
**文章详情页**
![Jbone CMS文章](doc/images/cms_article.png)
**专题页**
![Jbone CMS专题](doc/images/cms_special.png)
**后台管理**
![Jbone CMS后台管理](doc/images/cms_admin.png)
