package com.example.androidcoursedesign.services.impl;

import com.alibaba.fastjson.JSON;
import com.example.androidcoursedesign.dao.CommentDao;
import com.example.androidcoursedesign.entity.CommentEntity;
import com.example.androidcoursedesign.entity.NewsListEntity;
import com.example.androidcoursedesign.services.CommentServicesInterface;
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
public class CommentServicesInterfaceImpl implements CommentServicesInterface {

    @Autowired
    private CommentDao commentDao;

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 23:07
     * @param commentEntity: newsId userId commentInfo
     * @return: java.lang.String
     * @Info: 添加评论
     **/
    @Override
    public String insertComment(CommentEntity commentEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        commentEntity.setCommentDate(TimeUtil.getTime());
        if(commentDao.insertComment(commentEntity)>0)
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
     * @Date: 2020/7/7 23:09
     * @param commentEntity:  commentInfo state
     * @return: java.lang.String
     * @Info:修改评论信息
     **/
    @Override
    public String modifyComment(CommentEntity commentEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(commentDao.modifyComment(commentEntity)>0)
        {
            msg.put("msg","更新成功");
            msg.put("flag",true);

        }else
        {
            msg.put("msg","更新失败，请重新尝试");
            msg.put("flag",false);
        }
        return JSON.toJSONString(msg);
    }

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 23:10
     * @param commentEntity: id
     * @return: java.lang.String
     * @Info: 删除评论
     **/
    @Override
    public String deleteComment(CommentEntity commentEntity) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(commentDao.deleteComment(commentEntity)>0)
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
     * @Date: 2020/7/7 23:11
     * @param hashMap: 可选：userName userId newsId commentDate id newsTitle  state 必选：limit，page
     * @return: java.lang.String
     * @Info: 查询评论
     **/
    @Override
    public String queryComment(HashMap<String, Object> hashMap) {
        int limit=Integer.parseInt((String)hashMap.get("limit").toString());
        int page=Integer.parseInt((String)hashMap.get("page").toString());
        PageHelper.startPage(page,limit);
        ArrayList<CommentEntity> classify =commentDao.queryCommentList(hashMap);
        PageInfo<CommentEntity> pageinfo=new PageInfo<CommentEntity>(classify );
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg","");
        msg.put("flag",true);
        msg.put("data",pageinfo.getList());
        msg.put("count",pageinfo.getTotal());
        return JSON.toJSONString(msg);
    }
}
