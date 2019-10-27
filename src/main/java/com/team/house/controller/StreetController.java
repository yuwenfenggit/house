package com.team.house.controller;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/admin/")
@RestController
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreetByPage")
    public Map<String,Object> getStreetByPage(PageUtil pageUtil,Integer id){
        PageInfo<Street> streetByPage = streetService.getStreetByPage(pageUtil,id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rows",streetByPage.getList());
        map.put("total",streetByPage.getTotal());
        return map;
    }
}
