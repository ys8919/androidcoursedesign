package com.example.androidcoursedesign.controller;

import com.example.androidcoursedesign.entity.UsersEntity;
import com.example.androidcoursedesign.services.UserServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UsersController {

    @Autowired
    private UserServicesInterface userServices;

  /**
   * @Description:
   * @Author: yx8991
   * @Date: 2020/7/6 18:55
   * @param u:
   * @return: java.lang.String
   * @Info: 登录验证
   **/
    @RequestMapping("login")
    public  String login(@RequestBody UsersEntity u){
        return userServices.Login(u);
    }
   /**
    * @Description:
    * @Author: yx8991
    * @Date: 2020/7/6 18:55

    * @return: java.lang.String
    * @Info: 返回所有登录信息
    **/
    @RequestMapping("Query")

    public  String Query(@RequestBody UsersEntity u){
        return userServices.queryUser(u);
    }
}
