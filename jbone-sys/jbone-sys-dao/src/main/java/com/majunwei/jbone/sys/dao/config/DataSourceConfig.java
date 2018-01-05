package com.majunwei.jbone.sys.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.majunwei.jbone.configuration.JboneConfiguration;
import com.majunwei.jbone.configuration.sys.JdbcProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private JboneConfiguration jboneConfiguration;

    @Bean(name="dataSource",initMethod="init",destroyMethod="destroy")
    public DataSource shopDataSource(){
        JdbcProperties jdbc = jboneConfiguration.getSys().getJdbc();

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(jdbc.getUrl());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setPassword(jdbc.getPassword());
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        dataSource.setMaxActive(jdbc.getMaxActive());
        dataSource.setInitialSize(jdbc.getInitialSize());
        dataSource.setMaxWait(jdbc.getMaxWait());
        dataSource.setMinIdle(jdbc.getMinIdle());

        return dataSource;
    }
}
