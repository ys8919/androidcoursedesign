package com.example.androidcoursedesign.services;

import com.example.androidcoursedesign.entity.UsersEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 杨
 */
public interface UserServicesInterface {
    public  String login(UsersEntity u);
    public  String queryUser(UsersEntity u);
    public String queryList(HashMap<String, Object> u);
    public String queryUserList(HashMap<String,Object> u);
    public String insertUser(UsersEntity u);
    public String modifyUser(UsersEntity u);
}
