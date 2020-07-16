package com.example.androidcoursedesign.services.impl;

import com.alibaba.fastjson.JSON;
import com.example.androidcoursedesign.dao.NewsListDao;
import com.example.androidcoursedesign.entity.ClassifyListEntity;
import com.example.androidcoursedesign.entity.NewsListEntity;
import com.example.androidcoursedesign.services.NewsListServicesInterface;
import com.example.androidcoursedesign.util.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 杨
 */
@Service
public class NewsListServicesInterfaceImpl implements NewsListServicesInterface {

    @Autowired
    private NewsListDao newsListDao;
    @Override
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:11
     * @param newsListEntity: newsTitle，newsInfo，newsClassifyId，newsPhoto，authorId，newsDate
     * @return: java.lang.String
     * @Info: 增加新闻
     **/
    public String insertNewsList(NewsListEntity newsListEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        newsListEntity.setNewsDate(TimeUtil.getTime());
        if(newsListDao.insertNewsList(newsListEntity)>0)
        {
            msg.put("msg","添加成功");
            msg.put("flag",true);

        }else
        {
            msg.put("msg","添加失败，请重新尝试");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:21
     * @param newsListEntity: 可选：newsTitle，newsInfo，newsClassifyId，newsPhoto，authorId
     * @return: java.lang.String
     * @Info: 修改新闻
     **/
    @Override
    public String modifyNewsList(NewsListEntity newsListEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(newsListDao.modifyNewsList(newsListEntity)>0)
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

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:22
     * @param newsListEntity: newsId
     * @return: java.lang.String
     * @Info: 删除新闻
     **/
    @Override
    public String deleteNewsList(NewsListEntity newsListEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(newsListDao.deleteNewsList(newsListEntity)>0)
        {
            msg.put("msg","删除成功");
            msg.put("flag",true);

        }else
        {
            msg.put("msg","删除失败，请重新尝试");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:23
     * @param hashMap: 可选：classifyName classifyId userName authorId newsId newsDate newsTitle state 必选：limit，page
     * @return: java.lang.String
     * @Info: 分页查询新闻(无详细新闻)
     **/
    @Override
    public String queryNewsList(HashMap<String, Object> hashMap) {
        int limit=Integer.parseInt((String)hashMap.get("limit").toString());
        int page=Integer.parseInt((String)hashMap.get("page").toString());
        PageHelper.startPage(page,limit);
        ArrayList<NewsListEntity> Classify=newsListDao.queryNewsList(hashMap);
        PageInfo<NewsListEntity> pageInfo=new PageInfo<NewsListEntity>(Classify);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg","");
        msg.put("flag",true);
        msg.put("code",0);
        msg.put("data",pageInfo.getList());
        msg.put("count",pageInfo.getTotal());
        return JSON.toJSONString(msg);
    }

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/14 23:56
     * @param hashMap: hashMap: 可选：classifyName classifyId userName authorId newsId newsDate newsTitle state 必选：limit，page
     * @return: java.lang.String
     * @Info: 分页查询新闻(有详细新闻)
     **/
    @Override
    public String queryNewsInfoList(HashMap<String, Object> hashMap) {
        int limit=Integer.parseInt((String)hashMap.get("limit").toString());
        int page=Integer.parseInt((String)hashMap.get("page").toString());
        System.out.println("limit"+limit+";;;page"+page);

        PageHelper.startPage(page,limit);
        ArrayList<NewsListEntity> Classify=newsListDao.queryNewsInfoList(hashMap);
        PageInfo<NewsListEntity> pageInfo=new PageInfo<NewsListEntity>(Classify);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg","");
        msg.put("flag",true);
        msg.put("code",0);
        msg.put("data",pageInfo.getList());
        msg.put("count",pageInfo.getTotal());
        return JSON.toJSONString(msg);
    }
    @Override
    public String queryNewsInfo(HashMap<String, Object> hashMap) {
        ArrayList<NewsListEntity> Classify=newsListDao.queryNewsInfoList(hashMap);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(Classify.size()>0){
            //NewsListEntity newsListEntity=Classify.get(0);

            msg.put("msg","");
            msg.put("flag",true);
            msg.put("data",Classify);
        }else{
            msg.put("msg","新闻不存在");
            msg.put("flag",false);

        }

        return JSON.toJSONString(msg);
    }
}
