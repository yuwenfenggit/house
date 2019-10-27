package com.team.house.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("getUsersByPage")
    public Map<String,Object> getTypeByPage(Condition condition){
        PageInfo<Users> users = usersService.getUsersByPage(condition);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rows",users.getList());
        map.put("total",users.getTotal());
        return map;
    }

    @RequestMapping("delUsers")
    public Map<String, Object> delUsers(Integer id){
        int i = usersService.deleteByPrimaryKey(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("result",i);
        return map;
    }
}
