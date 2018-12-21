## 配置CAS证书

### 配置方式一

1、生成证书
sudo keytool -genkey -alias jbonekeystore -keyalg RSA -keystore /etc/cas/jbonekeystore

注意：要把jbone-cas.majunwei.com填进去；

输入口令：123456

2、导出证书

sudo keytool -export -file /etc/cas/jbonekeystore.crt -alias jbonekeystore -keystore /etc/cas/jbonekeystore

注意：这里输入到是上面设置的密码：123456

3、导入证书到本地JDK（客户端认证）

sudo keytool -import -keystore /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/security/cacerts -file /etc/cas/jbonekeystore.crt -alias jbonekeystore

注意：

1、这里要找到自己的JDK位置

2、这里的密码输入changeit，信任证书

常见错误：

keytool 错误: java.io.IOException: Keystore was tampered with, or password was incorrect

原因：

输入密码的时候输入changeit

4、配置tomcat SSL

找到server.xml中配置SSL的位置，填写如下内容：
```xml
<Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol" SSLEnabled="true"
               maxThreads="150" scheme="https" secure="true"
               clientAuth="false" sslProtocol="TLS"
               keystoreFile="/etc/cas/jbonekeystore"
               keystorePass="123456" />
```

注意：这里是tomcat8，其他版本的配置方式可能不同，主要表现在protocol属性上。

5、将jbone-cas-server添加到tomcat中，可使用idea部署，或单独启动tomcat部署

常见问题：

Open quote is expected for attribute "keystorePass" associated with an  element type  "Connector".

原因有可能是配置的属性符号问题，比如中文的引号

### 配置方式二：

为了方便开发人员配置证书，我们提供了脚本形式的部署。

- bat脚本： [gencertCasKey.bat](/jbone-cas/jbone-cas-server/src/main/resources/gencertCasKey.bat)
- shell脚本： gencertCasKey.sh 待写

进入到脚本所在路径：
> jbone/jbone-cas/jbone-cas-server/src/main/resources/

找到 `gencertCasKey.bat` 或 `gencertCasKey.sh`

替换脚本中本地JDK密钥库路径

```sh
:: "设置JDK密钥库路径"
set keystoreJDKPath="C:\devSpace\Java\jdk1.8.0_131\jre\lib\security\cacerts "
```

然后执行脚本，根据提示操作即可完成导入。

## 配置应用

配置jbone-cas-server：使用application.yml.https.bk覆盖application.yml
其他应用配置：将casServerUrl配置为jbone-cas-server的地址(https://jbone-cas.majunwei.com:8443/cas)

## 启动应用
依次启动：

1. jbone-sm-register

2. jbone-sm-admin

3. jbone-sys-server

4. jbone-sys-admin

5. jbone-cas-server (支持两种部署方式)

> 单独部署方式：在tomcat单独部署（https端口号8443）

> SpringBootApp方式：将 `jbonekeystore` 放入 `resources` 目录下，直接运行 `CasWebApplication` 主程序

6. jbone-cas-manager(tomcat中运行,http端口号30002)