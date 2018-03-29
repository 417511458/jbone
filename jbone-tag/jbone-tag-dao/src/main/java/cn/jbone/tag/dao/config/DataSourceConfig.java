package cn.jbone.tag.dao.config;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.configuration.props.JdbcProperties;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private JboneConfiguration jboneConfiguration;

    @Bean(name="dataSource",initMethod="init",destroyMethod="close")
    public DataSource shopDataSource(){
        JdbcProperties jdbc = jboneConfiguration.getSys().getJdbc();

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(jdbc.getUrl());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setPassword(jdbc.getPassword());
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        if(jdbc.getMaxActive() <= 0){
            dataSource.setMaxActive(jdbc.getMaxActive());
        }
        if(jdbc.getInitialSize() <= 0){
            dataSource.setInitialSize(jdbc.getInitialSize());
        }
        if(jdbc.getMaxWait() <= 0){
            dataSource.setMaxWait(jdbc.getMaxWait());
        }
        if(jdbc.getMinIdle() <= 0){
            dataSource.setMinIdle(jdbc.getMinIdle());
        }
        return dataSource;
    }
}
