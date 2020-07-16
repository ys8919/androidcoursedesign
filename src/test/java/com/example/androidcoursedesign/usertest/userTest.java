package com.example.androidcoursedesign.usertest;
import com.example.androidcoursedesign.dao.UsersDao;
import com.example.androidcoursedesign.entity.UsersEntity;
import com.example.androidcoursedesign.services.ClassifyListServicesInterface;
import com.example.androidcoursedesign.services.CommentServicesInterface;
import com.example.androidcoursedesign.services.NewsListServicesInterface;
import com.example.androidcoursedesign.services.UserServicesInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.HashMap;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class userTest {
    @Autowired
    private UsersDao userDao;
    @Autowired
    private UserServicesInterface userServices;
    @Autowired
    private CommentServicesInterface commentServicesInterface;
    @Test
    public void  test(){
        UsersEntity u=new UsersEntity();
        HashMap<String,Object> c=new HashMap<String,Object>();
        c.put("newsId",2);
        c.put("limit",100);
        c.put("page",1);
        //u.setUserId(2);
        System.out.println(commentServicesInterface.queryComment(c));
    }
}
