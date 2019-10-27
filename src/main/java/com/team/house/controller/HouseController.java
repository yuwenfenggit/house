package com.team.house.controller;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("getNoIspassBypage")
    public Map<String,Object> getNoIspassBypage(PageUtil pageUtil){
        PageInfo<House> house = houseService.selectByIspass(0,pageUtil);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rows",house.getList());
        map.put("total",house.getTotal());
        return map;
    }

    @RequestMapping("goHouseIpass")
    public String goHouseIpass(String id){
        int i = houseService.updateByIspass(id,1);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("getIspassBypage")
    public Map<String,Object> getIspassBypage(PageUtil pageUtil){
        PageInfo<House> house = houseService.selectByIspass(1,pageUtil);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("rows",house.getList());
        map.put("total",house.getTotal());
        return map;
    }

    @RequestMapping("goNoHouseIpass")
    public String goNoHouseIpass(String id){
        int i = houseService.updateByIspass(id,0);
        return "{\"result\":"+i+"}";
    }
}
