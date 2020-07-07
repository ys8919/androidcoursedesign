package com.example.androidcoursedesign.services;

import com.example.androidcoursedesign.entity.ClassifyListEntity;

import java.util.HashMap;

public interface ClassifyListServicesInterface {
    public String queryAllClassifyList(HashMap<String,Object> u);
    public String queryClassifyList(HashMap<String,Object> u);
    public String insertClassify(ClassifyListEntity u);
    public String modifyClassify(ClassifyListEntity u);
    public String deleteClassify(ClassifyListEntity u);
}
