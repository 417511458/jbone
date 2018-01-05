package com.majunwei.jbone.configuration.sys;

import java.io.Serializable;

public class SysProperties implements Serializable {
    /**
     * jdbc配置
     */
    private JdbcProperties jdbc = new JdbcProperties();

    public JdbcProperties getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcProperties jdbc) {
        this.jdbc = jdbc;
    }
}
