package com.example.androidcoursedesign.controller;

import com.example.androidcoursedesign.entity.UsersEntity;
import com.example.androidcoursedesign.services.UserServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@ResponseBody
@CrossOrigin
public class UsersController {

    @Autowired
    private UserServicesInterface userServices;

  /**
   * @Description:
   * @Author: yx8991
   * @Date: 2020/7/6 18:55
   * @param u:(userName，password)
   * @return: java.lang.String ：msg("提示消息")，flag（是否成功），data(UsersEntity)
   * @Info: 登录验证
   **/
    @RequestMapping("login")
    public  String login(@RequestBody UsersEntity u){
        return userServices.login(u);
    }

   /**
    * @Description:
    * @Author: yx8991
    * @Date: 2020/7/7 8:14
    * @param u: userId
    * @return: java.lang.String :msg("提示消息")，flag（是否成功），data(UsersEntity)
    * @Info: 根据用户id查询用户
    **/
    @RequestMapping("queryUser")

    public  String queryUser(@RequestBody UsersEntity u){
        return userServices.queryUser(u);
    }

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 8:31
     *
     * @return: java.lang.String : msg("提示消息")，flag（是否成功），data(UsersEntity)
     * @Info: 返回所有用户信息
     **/
    @RequestMapping("queryList")
    public  String queryList(@RequestBody HashMap<String,Object> u){
        return userServices.queryList(u);
    }
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 8:44
     * @param u: 可选择：userName userId email state userId
     * @return: java.lang.String msg("提示消息")，flag（是否成功），data(UsersEntity)
     * @Info: 根据用户信息模糊查询用户
     **/
    @RequestMapping("queryUserList")
    public  String queryUserList(@RequestBody HashMap<String,Object> u){
        return userServices.queryUserList(u);
    }

    /**
     * @Description:
     * @Author: y1x8991
     * @Date: 2020/7/7 8:32
     * @param u: userId userName password email
     * @return: java.lang.String msg("提示消息")，flag（是否成功）
     * @Info: 用户注册
     **/
    @RequestMapping("insertUser")
    public  String insertUser(@RequestBody UsersEntity u){
        return userServices.insertUser(u);
    }

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 8:34
     * @param u: 可选择：userName userId email state
     * @return: java.lang.String msg("提示消息")，flag（是否成功）
     * @Info: 修改用户信息
     **/
    @RequestMapping("modifyUser")
    public  String modifyUser(@RequestBody UsersEntity u){
        return userServices.modifyUser(u);
    }
}
