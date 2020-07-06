package com.example.androidcoursedesign.services.impl;

import com.alibaba.fastjson.JSON;
import com.example.androidcoursedesign.dao.UsersDao;
import com.example.androidcoursedesign.entity.UsersEntity;
import com.example.androidcoursedesign.services.UserServicesInterface;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserServicesInterfaceImpl implements UserServicesInterface {
    @Autowired
    private UsersDao usersDao;
    @Override
    public String Login(UsersEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        UsersEntity user=usersDao.login(u);
        if(user!=null)
        {
            msg.put("msg","登录成功");
            msg.put("flag",true);
            msg.put("userId",user.getUserId());
            msg.put("userName",u.getUserName());
        }else
        {
            msg.put("msg","登录失败");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String queryUser(UsersEntity u) {
        UsersEntity users=usersDao.queryUser(u);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(users!=null){
            msg.put("msg","用户存在");
            msg.put("flag",true);
            msg.put("data",users);
        }else{
            msg.put("msg","用户不存在");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String queryList() {
        return null;
    }

    @Override
    public String queryUserList(HashMap<String, Object> u) {
        return null;
    }

    @Override
    public String insertUser(UsersEntity u) {
        return null;
    }

    @Override
    public String modifyUser(UsersEntity u) {
        return null;
    }

}
