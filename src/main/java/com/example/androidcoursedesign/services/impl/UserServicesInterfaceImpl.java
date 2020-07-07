package com.example.androidcoursedesign.services.impl;

import com.alibaba.fastjson.JSON;
import com.example.androidcoursedesign.dao.UsersDao;
import com.example.androidcoursedesign.entity.UsersEntity;
import com.example.androidcoursedesign.services.UserServicesInterface;
import com.example.androidcoursedesign.util.RandIdUtil;
import com.example.androidcoursedesign.util.UserTokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserServicesInterfaceImpl implements UserServicesInterface {
    @Autowired
    private UsersDao usersDao;
    @Override
    public String login(UsersEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        UsersEntity user=usersDao.login(u);
        if(user!=null)
        {

            String token= RandIdUtil.rangId();
            HashMap<String, Object> userinfomaintion=new HashMap<String, Object>();
            userinfomaintion.put("userId", u.getUserId());
            userinfomaintion.put("state", user.getState());
            UserTokenUtil.setUserSession(token,userinfomaintion);
            msg.put("token",token);
            msg.put("msg","登录成功");
            msg.put("flag",true);
            msg.put("userId",user.getUserId());
            msg.put("userName",user.getUserName());
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
    public String queryList(HashMap<String, Object> u) {
        int limit=Integer.parseInt((String)u.get("limit").toString());
        int page=Integer.parseInt((String)u.get("page").toString());
        PageHelper.startPage(page,limit);
        ArrayList<UsersEntity> users=usersDao.queryList();
        PageInfo<UsersEntity> pageinfo=new PageInfo<UsersEntity>(users);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg","查询成功");
        msg.put("flag",true);
        msg.put("data",pageinfo.getList());
        msg.put("count",pageinfo.getTotal());

        return JSON.toJSONString(msg);
    }

    @Override
    public String queryUserList(HashMap<String, Object> u) {
        int limit=Integer.parseInt((String)u.get("limit").toString());
        int page=Integer.parseInt((String)u.get("page").toString());
        PageHelper.startPage(page,limit);
        ArrayList<UsersEntity> users=usersDao.queryUserList(u);
        PageInfo<UsersEntity> pageinfo=new PageInfo<UsersEntity>(users);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg","");
        msg.put("flag",true);
        msg.put("data",pageinfo.getList());
        msg.put("count",pageinfo.getTotal());
        return JSON.toJSONString(msg);
    }

    @Override
    public String insertUser(UsersEntity u) {

        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(usersDao.insertUser(u)>0)
        {
            msg.put("msg","注册成功");
            msg.put("flag",true);

        }else
        {
            msg.put("msg","注册成功，请重新尝试");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    @Override
    public String modifyUser(UsersEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(usersDao.modifyUser(u)>0)
        {
            msg.put("msg","修改成功");
            msg.put("flag",true);

        }else
        {
            msg.put("msg","修改失败，请重新尝试");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

}
