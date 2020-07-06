package com.example.androidcoursedesign.test;

import com.example.androidcoursedesign.dao.UsersDao;
import com.example.androidcoursedesign.entity.UsersEntity;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class Test {
    @Autowired
    private UsersDao userDao;
    @org.junit.Test
    public void  test(){
        UsersEntity u=new UsersEntity();
        u.setUserName("1001");
        u.setPassword("123456");

        System.out.println(userDao.login(u));
    }

}
