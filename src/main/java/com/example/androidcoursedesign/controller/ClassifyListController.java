package com.example.androidcoursedesign.controller;

import com.example.androidcoursedesign.entity.ClassifyListEntity;
import com.example.androidcoursedesign.services.ClassifyListServicesInterface;
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
public class ClassifyListController {
    @Autowired
    private ClassifyListServicesInterface classifyListServices;
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 17:01
     * @param c: 可选：classifyName classifyId
     * @return: java.lang.String msg("提示消息")，flag（是否成功），data(ClassifyListEntity) count 总数
     * @Info: 查询所有分类信息（不分页）
     **/
    @RequestMapping("queryAllClassifyList")
    public String queryAllClassifyList(@RequestBody HashMap<String,Object> c){return classifyListServices.queryAllClassifyList(c);}
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 13:45
     * @param c: 可选择查询 classifyName classifyId 必选：limit，page
     * @return: java.lang.String：msg("提示消息")，flag（是否成功），data(ClassifyListEntity) count 总数
     * @Info: 返回分类信息(分页)
     **/
    @RequestMapping("queryClassifyList")
    public String queryClassifyList(@RequestBody HashMap<String,Object> c){return classifyListServices.queryClassifyList(c);}

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 13:49
     * @param c:  classifyId  classifyName
     * @return: java.lang.String msg ("提示消息")，flag（是否成功）
     * @Info: 插入新的分类
     **/
    @RequestMapping("insertClassify")
    public String insertClassify(@RequestBody  ClassifyListEntity c){return classifyListServices.insertClassify(c);}
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 13:53
     * @param c:classifyId   classifyName
     * @return: java.lang.String msg ("提示消息")，flag（是否成功）
     * @Info: 修改分类
     **/
    @RequestMapping("modifyClassify")
    public String modifyClassify(@RequestBody  ClassifyListEntity c){return classifyListServices.modifyClassify(c);}
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 13:54
     * @param c:classifyId
     * @return: java.lang.String msg ("提示消息")，flag（是否成功）
     * @Info:删除分类
     **/
    @RequestMapping("deleteClassify")
    public String deleteClassify(@RequestBody  ClassifyListEntity c){return classifyListServices.deleteClassify(c);}
}
