package com.example.androidcoursedesign.controller;

import com.example.androidcoursedesign.entity.CommentEntity;
import com.example.androidcoursedesign.entity.NewsListEntity;
import com.example.androidcoursedesign.services.CommentServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@ResponseBody
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentServicesInterface commentServices;
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 23:18
     * @param commentEntity: newsId userId commentInfo
     * @return: java.lang.String msg("提示消息")，flag（是否成功）
     * @Info: 添加评论
     **/
    @RequestMapping("insertComment")
    public String insertComment(CommentEntity commentEntity){return commentServices.insertComment(commentEntity);}
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 23:18
     * @param commentEntity:  commentInfo state
     * @return: java.lang.String msg("提示消息")，flag（是否成功）
     * @Info: 修改评论信息
     **/
    @RequestMapping("modifyComment")
    public String modifyComment(CommentEntity commentEntity){return commentServices.modifyComment(commentEntity);}
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 23:19
     * @param commentEntity: id
     * @return: java.lang.String msg ("提示消息")，flag（是否成功）
     * @Info: 删除评论
     **/
    @RequestMapping("deleteComment")
    public String deleteComment(CommentEntity commentEntity){return commentServices.deleteComment(commentEntity);}
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 23:19
     * @param hashMap: 可选：userName userId newsId commentDate id newsTitle  state 必选：limit，page
     * @return: java.lang.String msg("提示消息")，flag（是否成功） data(commentEntity) count(数据量)
     * @Info: 查询评论
     **/
    @RequestMapping("queryComment")
    public String queryComment(HashMap<String,Object> hashMap){return commentServices.queryComment(hashMap);}
}
