package cn.jbone.configuration.props;

import java.io.Serializable;

/**
 * Jbone数据源公关配置属性
 */
public class JdbcProperties implements Serializable {
    /**
     * 数据库连接地址
     */
    private String url;
    /**
     * 数据库名字
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 驱动类
     */
    private String driverClassName;
    /**
     * 最大活动连接
     */
    private int maxActive;
    /**
     * 初始化连接数
     */
    private int initialSize;
    /**
     * 获取连接时最大等待时间，单位毫秒
     */
    private int maxWait;

    /**
     * 最小空闲连接数
     */
    private int minIdle;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }

    public int getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(int maxWait) {
        this.maxWait = maxWait;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    @Override
    public String toString() {
        return "JdbcProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", maxActive=" + maxActive +
                ", initialSize=" + initialSize +
                ", maxWait=" + maxWait +
                ", minIdle=" + minIdle +
                '}';
    }
}
