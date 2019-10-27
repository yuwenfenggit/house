package com.team.house.controller;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class TypeController {
    @Autowired
    private TypeService TypeService;

    @RequestMapping("getAllType")
    public List<Type> getAllType(){
        return TypeService.getAllType();
    }

    @RequestMapping("getTypeByPage")
    public Map<String,Object> getTypeByPage(PageUtil pageUtil){
        PageInfo<Type> TypeByPage = TypeService.getTypeByPage(pageUtil);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rows",TypeByPage.getList());
        map.put("total",TypeByPage.getTotal());
        return map;
    }

    @RequestMapping("addType")
    public Map<String,Object> addType(Type type){
        Map<String,Object> map = new HashMap<String, Object>();
        int i = TypeService.addinsert(type);
        map.put("result",i);
        return map;
    }


    @RequestMapping("getType")
    public Type getType(Integer id){
        Type type = TypeService.selectByPrimaryKey(id);
        return type;
    }


    @RequestMapping("upType")
    public Map<String,Object> upType(Type type){
        Map<String,Object> map = new HashMap<String, Object>();
        int i = TypeService.updateByPrimaryKeySelective(type);
        map.put("result",i);
        return map;
    }


    @RequestMapping("delType")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String,Object> delType(Integer id){
        int i = TypeService.delType(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("result",i);
        return map;
    }


    @RequestMapping("delMoreType")
    @Transactional(propagation = Propagation.REQUIRED)
    public Map<String, Object> delMoreType(String ids){
        String[] list = ids.split(",");
        Integer[] ary = new Integer[list.length];
        for (int i = 0; i <ary.length ; i++) {
            ary[i] = Integer.parseInt(list[i]);
        }
        int i = TypeService.delMoreType(ary);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("result",i);
        return map;
    }

}
