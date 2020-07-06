package com.example.androidcoursedesign.services;

import com.example.androidcoursedesign.entity.UsersEntity;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserServicesInterface {
    public  String Login(UsersEntity u);
    public  String queryUser(UsersEntity u);
    public String queryList();
    public String queryUserList(HashMap<String,Object> u);
    public String insertUser(UsersEntity u);
    public String modifyUser(UsersEntity u);
}
