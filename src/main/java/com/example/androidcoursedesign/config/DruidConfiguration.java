package com.example.androidcoursedesign.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DruidConfiguration {

    @Bean(name = "dataSource")
    @Primary // 用 @Primary 区分主数据源
    @ConfigurationProperties(prefix = "druid") // 指定配置文件中，前缀为 druid 的属性值
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .type(DruidDataSource.class).build();
    }
}
