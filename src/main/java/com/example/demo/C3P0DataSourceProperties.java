package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.Resource;

@Configuration
@Resource(name = "c3p0")
//@PropertySource("classpath:application.properties")
public class C3P0DataSourceProperties {
    @Value( "${c3p0.spring.datasource.url}" )
    private String url;
    @Value( "${c3p0.spring.datasource.username}" )
    private String username;
    @Value( "${c3p0.spring.datasource.password}" )
    private String password;
    @Value( "${c3p0.spring.datasource.driver-class}" )
    private String driverClass;
    @Value( "${c3p0.spring.datasource.initialPoolSize}" )
    private int initialPoolSize;
    @Value( "${c3p0.spring.datasource.acquireIncrement}" )
    private int acquireIncrement;
    @Value( "${c3p0.spring.datasource.maxIdleTime}" )
    private int maxIdleTime;
    @Value( "${c3p0.spring.datasource.maxPoolSize}" )
    private int maxPoolSize;
    @Value( "${c3p0.spring.datasource.minPoolSize}" )
    private int minPoolSize;
    @Value( "${c3p0.spring.datasource.maxStatements}" )
    private int maxStatements;


    public int getAcquireIncrement() {
        return acquireIncrement;
    }

    public void setAcquireIncrement(int acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }

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

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public int getInitialPoolSize() {
        return initialPoolSize;
    }

    public void setInitialPoolSize(int initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public int getMaxIdleTime() {
        return maxIdleTime;
    }

    public void setMaxIdleTime(int maxIdleTime) {
        this.maxIdleTime = maxIdleTime;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getMinPoolSize() {
        return minPoolSize;
    }

    public void setMinPoolSize(int minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public int getMaxStatements() {
        return maxStatements;
    }

    public void setMaxStatements(int maxStatements) {
        this.maxStatements = maxStatements;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("C3P0DataSourceProperties{");
        sb.append("driverClass='").append(driverClass).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", driverClass='").append(driverClass).append('\'');
        sb.append(", initialPoolSize=").append(initialPoolSize);
        sb.append(", acquireIncrement=").append(acquireIncrement);
        sb.append(", maxIdleTime=").append(maxIdleTime);
        sb.append(", maxPoolSize=").append(maxPoolSize);
        sb.append(", minPoolSize=").append(minPoolSize);
        sb.append(", maxStatements=").append(maxStatements);
        sb.append('}');
        return sb.toString();
    }
}
