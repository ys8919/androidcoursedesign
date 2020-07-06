package com.example.androidcoursedesign;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@MapperScan("com.example.androidcoursedesign.dao")
class AndroidcoursedesignApplicationTests {

    @Test
    void contextLoads() {
    }

}
