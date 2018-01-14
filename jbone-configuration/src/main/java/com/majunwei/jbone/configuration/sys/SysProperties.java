package com.majunwei.jbone.configuration.sys;

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

    /**
     * 协议
     */
    private String serverProtol = "http://";

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

    public String getServerProtol() {
        return serverProtol;
    }

    public void setServerProtol(String serverProtol) {
        this.serverProtol = serverProtol;
    }

    @Override
    public String toString() {
        return "SysProperties{" +
                "jdbc=" + jdbc +
                ", serverName='" + serverName + '\'' +
                ", serverProtol='" + serverProtol + '\'' +
                '}';
    }
}
