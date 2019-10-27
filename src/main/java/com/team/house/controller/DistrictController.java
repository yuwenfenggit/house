package com.team.house.controller;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
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
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getAllDistrict1")
    public List<District> getAllDistrict(){
        return districtService.getAllDistrict();
    }

    @RequestMapping("getDistrictByPage")
    public Map<String,Object> getDistrictByPage(PageUtil pageUtil){
        PageInfo<District> disrictByPage = districtService.getDisrictByPage(pageUtil);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rows",disrictByPage.getList());
        map.put("total",disrictByPage.getTotal());
        return map;
    }

    @RequestMapping("addDistrit")
    public Map<String,Object> addDistrit(District district){
        Map<String,Object> map = new HashMap<String, Object>();
        int i = districtService.addinsert(district);
        map.put("result",i);
        return map;
    }


    @RequestMapping("getDistrit")
    public District getDistrit(Integer id){
        District district = districtService.selectByPrimaryKey(id);
        return district;
    }


    @RequestMapping("upDistrit")
    public Map<String,Object> upDistrit(District district){
        Map<String,Object> map = new HashMap<String, Object>();
        int i = districtService.updateByPrimaryKeySelective(district);
        map.put("result",i);
        return map;
    }


    @RequestMapping("delDistrit")
    @Transactional(propagation = Propagation.REQUIRED)
    public int delDistrit(Integer id){
        districtService.removeStreet(id);
        districtService.delDistrict(id);
        return 1;
    }


    @RequestMapping("delMoreDistrit")
    @Transactional(propagation = Propagation.REQUIRED)
    public int delMoreDistrit(String ids){
        String[] list = ids.split(",");
        Integer[] ary = new Integer[list.length];
        for (int i = 0; i <ary.length ; i++) {
            ary[i] = Integer.parseInt(list[i]);
        }
        districtService.delMoreStreet(ary);
        districtService.delMoreDistrict(ary);
        return 1;
    }

}
