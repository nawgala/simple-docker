package com.example.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DBConfig {
    @Bean
    public DataSource createDataSource(C3P0DataSourceProperties dsp) throws Exception {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl(dsp.getUrl());
        ds.setDriverClass(dsp.getDriverClass());
        ds.setUser(dsp.getUsername());
        ds.setPassword(dsp.getPassword());
        ds.setMaxIdleTime(dsp.getMaxIdleTime());
        ds.setAcquireIncrement(dsp.getAcquireIncrement());
        ds.setInitialPoolSize(dsp.getInitialPoolSize());
        ds.setMaxPoolSize(dsp.getMaxPoolSize());
        ds.setMinPoolSize(dsp.getMinPoolSize());

        return ds;}
}
