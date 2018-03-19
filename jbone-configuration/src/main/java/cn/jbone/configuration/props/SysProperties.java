package cn.jbone.configuration.props;

import java.io.Serializable;

public class SysProperties implements Serializable {
    /**
     * jdbc配置
     */
    private JdbcProperties jdbc = new JdbcProperties();

    /**
     * 系统名字（注册中心）
     * @return
     */
    private String serverName;

    public JdbcProperties getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcProperties jdbc) {
        this.jdbc = jdbc;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String toString() {
        return "SysProperties{" +
                "jdbc=" + jdbc +
                ", serverName='" + serverName + '\'' +
                '}';
    }
}
