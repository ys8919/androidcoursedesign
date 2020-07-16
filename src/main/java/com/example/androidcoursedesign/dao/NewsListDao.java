package com.example.androidcoursedesign.dao;

import com.example.androidcoursedesign.entity.NewsListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Component
public interface NewsListDao {
    public int insertNewsList(NewsListEntity n);
    public int modifyNewsList(NewsListEntity n);
    public int deleteNewsList(NewsListEntity n);
    public ArrayList<NewsListEntity> queryNewsList(HashMap<String,Object> u);
    public ArrayList<NewsListEntity> queryNewsInfoList(HashMap<String,Object> u);
}

