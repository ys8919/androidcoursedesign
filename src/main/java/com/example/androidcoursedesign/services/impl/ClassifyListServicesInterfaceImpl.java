package com.example.androidcoursedesign.services.impl;

import com.alibaba.fastjson.JSON;
import com.example.androidcoursedesign.dao.ClassifyListDao;
import com.example.androidcoursedesign.entity.ClassifyListEntity;
import com.example.androidcoursedesign.entity.UsersEntity;
import com.example.androidcoursedesign.services.ClassifyListServicesInterface;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ClassifyListServicesInterfaceImpl implements ClassifyListServicesInterface {

    @Autowired
    private ClassifyListDao classifyListDao;

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 16:59
     * @param u: 可选：classifyName classifyId
     * @return: java.lang.String
     * @Info: 查询所有分类信息（不分页）
     **/
    @Override
    public String queryAllClassifyList(HashMap<String, Object> u) {
        ArrayList<ClassifyListEntity> Classify=classifyListDao.queryClassifyList(u);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg","");
        msg.put("flag",true);
        msg.put("data",Classify);
        msg.put("count",Classify.size());
        return JSON.toJSONString(msg);
    }

    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 13:48
     * @param u:可选：classifyName classifyId 必选：limit，page
     * @return: java.lang.String
     * @Info: 查询分类信息
     **/
    @Override
    public String queryClassifyList(HashMap<String, Object> u) {
        int limit=Integer.parseInt((String)u.get("limit").toString());
        int page=Integer.parseInt((String)u.get("page").toString());
        PageHelper.startPage(page,limit);
        ArrayList<ClassifyListEntity> Classify=classifyListDao.queryClassifyList(u);
        PageInfo<ClassifyListEntity> pageinfo=new PageInfo<ClassifyListEntity>(Classify);
        HashMap<String,Object> msg=new HashMap<String,Object>();
        msg.put("msg","");
        msg.put("flag",true);
        msg.put("data",pageinfo.getList());
        msg.put("count",pageinfo.getTotal());

        return JSON.toJSONString(msg);
    }
    /**
     * @Description:
     * @Author: yx8991
     * @Date: 2020/7/7 13:49
     * @param u:  classifyId  classifyName
     * @return: java.lang.String
     * @Info: 插入新的分类
     **/
    @Override
    public String insertClassify(ClassifyListEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(classifyListDao.insertClassify(u)>0)
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
     * @Date: 2020/7/7 13:50
     * @param u: classifyId   classifyName
     * @return: java.lang.String
     * @Info: 修改分类
     **/
    @Override
    public String modifyClassify(ClassifyListEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(classifyListDao.modifyClassify(u)>0)
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
     * @Date: 2020/7/7 13:50
     * @param u: classifyId
     * @return: java.lang.String
     * @Info: 删除分类
     **/
    @Override
    public String deleteClassify(ClassifyListEntity u) {
        HashMap<String,Object> msg=new HashMap<String,Object>();
        if(classifyListDao.deleteClassify(u)>0)
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
}
