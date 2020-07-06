package com.example.androidcoursedesign.dao;

import com.example.androidcoursedesign.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;


@Mapper
@Component
public interface UsersDao {
    public UsersEntity login(UsersEntity u);
    public UsersEntity queryUser(UsersEntity u);
    public ArrayList<UsersEntity> queryList();
    public ArrayList<UsersEntity> queryUserList(HashMap<String,Object> u);
    public int insertUser(UsersEntity u);
    public int modifyUser(UsersEntity u);
}
