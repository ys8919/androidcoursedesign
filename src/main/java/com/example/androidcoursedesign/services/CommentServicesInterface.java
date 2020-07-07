package com.example.androidcoursedesign.services;

import com.example.androidcoursedesign.entity.CommentEntity;


import java.util.HashMap;

public interface CommentServicesInterface {
    public String insertComment(CommentEntity n);
    public String modifyComment(CommentEntity n);
    public String deleteComment(CommentEntity n);
    public String queryComment(HashMap<String,Object> u);
}
