package com.example.androidcoursedesign.services;

import com.example.androidcoursedesign.entity.NewsListEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 杨
 */
public interface NewsListServicesInterface {

    public String insertNewsList(NewsListEntity newsListEntity);
    public String modifyNewsList(NewsListEntity newsListEntity);
    public String deleteNewsList(NewsListEntity newsListEntity);
    public String queryNewsList(HashMap<String,Object> hashMap);
    public String queryNewsInfoList(HashMap<String,Object> hashMap);
    public String queryNewsInfo(HashMap<String,Object> hashMap);
}
