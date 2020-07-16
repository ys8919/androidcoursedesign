package com.example.androidcoursedesign.controller;

import com.example.androidcoursedesign.entity.NewsListEntity;
import com.example.androidcoursedesign.services.NewsListServicesInterface;
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
public class NewsListController {
    @Autowired
    private NewsListServicesInterface newsListServices;
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:40
     * @param n:  newsTitle，newsInfo，newsClassifyId，newsPhoto，authorId，newsDate
     * @return: java.lang.String msg("提示消息")，flag（是否成功）
     * @Info: 增加新闻
     **/
    @RequestMapping("insertNewsList")
    public String insertNewsList(@RequestBody NewsListEntity n){return newsListServices.insertNewsList(n);};

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:41
     * @param n: 可选：newsTitle，newsInfo，newsClassifyId，newsPhoto，authorId
     * @return: java.lang.String msg("提示消息")，flag（是否成功）
     * @Info: 修改新闻
     **/
    @RequestMapping("modifyNewsList")
    public String modifyNewsList(@RequestBody NewsListEntity n){return newsListServices.modifyNewsList(n);};
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:41
     * @param n: newsId
     * @return: java.lang.String msg("提示消息")，flag（是否成功）
     * @Info: 删除新闻
     **/
    @RequestMapping("deleteNewsList")
    public String deleteNewsList(@RequestBody NewsListEntity n){return newsListServices.deleteNewsList(n);};
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 22:41
     * @param n: 可选：classifyName classifyId userName authorId newsId newsDate newsTitle state 必选：limit，page，code
     * @return: java.lang.String msg("提示消息")，flag（是否成功） data（NewsListEntity ）  count （总数）
     * @Info:  分页查询新闻列表
     **/
    @RequestMapping("queryNewsList")
    public String queryNewsList(@RequestBody HashMap<String,Object> n){return newsListServices.queryNewsList(n);};

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/14 23:58
     * @param n: 可选：classifyName classifyId userName authorId newsId newsDate newsTitle state 必选：limit，page，code
     * @return: java.lang.String msg("提示消息")，flag（是否成功） data（NewsListEntity ）  count （总数）
     * @Info:  分页查询新闻详细信息
     **/
    @RequestMapping("queryNewsInfoList")
    public String queryNewsInfoList(@RequestBody HashMap<String,Object> n){return newsListServices.queryNewsInfoList(n);};
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/15 16:38
     * @param n:  可选：classifyName classifyId userName authorId newsId newsDate newsTitle state 必选：limit，page，code
     * @return: java.lang.String msg("提示消息")，flag（是否成功） data（NewsListEntity ）
     * @Info: 返回单个新闻详细信息
     **/
    @RequestMapping("queryNewsInfo")
    public String queryNewsInfo(@RequestBody HashMap<String,Object> n){return newsListServices.queryNewsInfo(n);};
}
