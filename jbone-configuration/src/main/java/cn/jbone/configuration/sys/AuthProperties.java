package cn.jbone.configuration.sys;

/**
 * 授权服务配置
 */
public class AuthProperties {
    /**
     * 授权服务名字
     */
    private String serverName;

    /**
     * 协议
     */
    private String serverProtocol = "http://";

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerProtocol() {
        return serverProtocol;
    }

    public void setServerProtocol(String serverProtocol) {
        this.serverProtocol = serverProtocol;
    }

    @Override
    public String toString() {
        return "AuthProperties{" +
                "serverName='" + serverName + '\'' +
                ", serverProtocol='" + serverProtocol + '\'' +
                '}';
    }
}
