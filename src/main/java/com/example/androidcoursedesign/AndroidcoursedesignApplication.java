package com.example.androidcoursedesign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.androidcoursedesign.dao")
public class AndroidcoursedesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidcoursedesignApplication.class, args);
    }

}
