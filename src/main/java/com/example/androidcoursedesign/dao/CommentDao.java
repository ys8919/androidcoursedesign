package com.example.androidcoursedesign.dao;

import com.example.androidcoursedesign.entity.CommentEntity;
import com.example.androidcoursedesign.entity.NewsListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Component
public interface CommentDao {

    public int insertComment(CommentEntity commentEntity);
    public int modifyComment(CommentEntity commentEntity);
    public int deleteComment(CommentEntity commentEntity);
    public ArrayList<CommentEntity> queryCommentList(HashMap<String,Object> u);
}
