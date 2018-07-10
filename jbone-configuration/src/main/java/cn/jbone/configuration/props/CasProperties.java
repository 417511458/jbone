package cn.jbone.configuration.props;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.LinkedHashMap;

/**
 * CAS属性配置
 */
public class CasProperties implements Serializable {
    /**
     * CAS服务端URL
     */
    private String casServerUrl = "https://cas.majunwei.com:8443/cas";
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
     * CASFilter
     */
    private String casFilterUrlPattern = "/cas";

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
    private long clientSessionTimeout = 1000 * 60 * 3;

    /**
     * 权限过滤规则，限制需要CAS过滤的请求路径
     */
    private LinkedHashMap<String,String> filterChainDefinition = new LinkedHashMap<String,String>();

    public String getCasServerUrl() {
        return casServerUrl;
    }

    public void setCasServerUrl(String casServerUrl) {
        this.casServerUrl = casServerUrl;
    }

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

    public String getCasFilterUrlPattern() {
        return casFilterUrlPattern;
    }

    public void setCasFilterUrlPattern(String casFilterUrlPattern) {
        this.casFilterUrlPattern = casFilterUrlPattern;
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
            return casServerUrl + loginUrl + "?service=" + URLEncoder.encode(currentServerUrlPrefix + casFilterUrlPattern + "?client_name=CasClient", "utf-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getEncodedLogoutUrl(){
        try {
            return casServerUrl + logoutUrl + "?service=" + URLEncoder.encode(currentServerUrlPrefix + casFilterUrlPattern, "utf-8");
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

    @Override
    public String toString() {
        return "CasProperties{" +
                "casServerUrl='" + casServerUrl + '\'' +
                ", loginUrl='" + loginUrl + '\'' +
                ", logoutUrl='" + logoutUrl + '\'' +
                ", currentServerUrlPrefix='" + currentServerUrlPrefix + '\'' +
                ", casFilterUrlPattern='" + casFilterUrlPattern + '\'' +
                ", successUrl='" + successUrl + '\'' +
                ", unauthorizedUrl='" + unauthorizedUrl + '\'' +
                ", clientSessionTimeout=" + clientSessionTimeout +
                ", filterChainDefinition=" + filterChainDefinition +
                '}';
    }
}
