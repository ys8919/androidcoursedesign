package com.example.androidcoursedesign.dao;

import com.example.androidcoursedesign.entity.ClassifyListEntity;
import com.example.androidcoursedesign.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 杨
 */
@Mapper
@Component
public interface ClassifyListDao {
    public ArrayList<ClassifyListEntity> queryClassifyList(HashMap<String,Object> u);
    public int insertClassify(ClassifyListEntity u);
    public int modifyClassify(ClassifyListEntity u);
    public int deleteClassify(ClassifyListEntity u);
}
