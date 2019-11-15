package cn.jbone.configuration.props;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

/**
 * SSO属性配置
 */
public class SsoProperties implements Serializable {
    /**
     * SSO服务端URL
     */
    private String ssoServerUrl = "https://sso.local.jbone.cn";
    /**
     * 登录URL
     */
    private String loginUrl =  "/login";;
    /**
     * 推出登录URL
     */
    private String logoutUrl =  "/logout";
    /**
     * 当前服务URL
     */
    private String currentServerUrlPrefix = "";
    /**
     * SSOFilter
     */
    private String ssoFilterUrlPattern = "/sso";

    /**
     * 成功后跳转的默认路径
     */
    private String successUrl = "/";

    /**
     * 没有权限的路径
     */
    private String unauthorizedUrl = "/403";

    /**
     * 客户端Session超时时间
     */
    private long clientSessionTimeout = 1000 * 60 * 3 * 10;

    /**
     * 登录需要的角色
     */
    private String requiredRole = "sso";

    /**
     * 权限过滤规则，限制需要SSO过滤的请求路径
     */
    private LinkedHashMap<String,String> filterChainDefinition = new LinkedHashMap<String,String>();


    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getCurrentServerUrlPrefix() {
        return currentServerUrlPrefix;
    }

    public void setCurrentServerUrlPrefix(String currentServerUrlPrefix) {
        this.currentServerUrlPrefix = currentServerUrlPrefix;
    }


    public LinkedHashMap<String, String> getFilterChainDefinition() {
        return filterChainDefinition;
    }

    public void setFilterChainDefinition(LinkedHashMap<String, String> filterChainDefinition) {
        this.filterChainDefinition = filterChainDefinition;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl) {
        this.unauthorizedUrl = unauthorizedUrl;
    }

    public String getEncodedLoginUrl(){
        try {
            return ssoServerUrl + loginUrl + "?service=" + URLEncoder.encode(currentServerUrlPrefix + ssoFilterUrlPattern + "?client_name=CasClient", "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getEncodedLogoutUrl(){
        try {
            return ssoServerUrl + logoutUrl + "?service=" + URLEncoder.encode(currentServerUrlPrefix + ssoFilterUrlPattern, "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public long getClientSessionTimeout() {
        return clientSessionTimeout;
    }

    public void setClientSessionTimeout(long clientSessionTimeout) {
        this.clientSessionTimeout = clientSessionTimeout;
    }

    public String getRequiredRole() {
        return requiredRole;
    }

    public void setRequiredRole(String requiredRole) {
        this.requiredRole = requiredRole;
    }

    public String getSsoServerUrl() {
        return ssoServerUrl;
    }

    public void setSsoServerUrl(String ssoServerUrl) {
        this.ssoServerUrl = ssoServerUrl;
    }

    public String getSsoFilterUrlPattern() {
        return ssoFilterUrlPattern;
    }

    public void setSsoFilterUrlPattern(String ssoFilterUrlPattern) {
        this.ssoFilterUrlPattern = ssoFilterUrlPattern;
    }

    @Override
    public String toString() {
        return "SsoProperties{" +
                "ssoServerUrl='" + ssoServerUrl + '\'' +
                ", loginUrl='" + loginUrl + '\'' +
                ", logoutUrl='" + logoutUrl + '\'' +
                ", currentServerUrlPrefix='" + currentServerUrlPrefix + '\'' +
                ", ssoFilterUrlPattern='" + ssoFilterUrlPattern + '\'' +
                ", successUrl='" + successUrl + '\'' +
                ", unauthorizedUrl='" + unauthorizedUrl + '\'' +
                ", clientSessionTimeout=" + clientSessionTimeout +
                ", requiredRole='" + requiredRole + '\'' +
                ", filterChainDefinition=" + filterChainDefinition +
                '}';
    }
}
