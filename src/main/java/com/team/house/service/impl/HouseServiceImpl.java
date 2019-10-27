package com.team.house.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.util.HouseCondition;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    public int insertSelective(House record) {
        return houseMapper.insertSelective(record);
    }

    public List<House> getByUserId(Integer id) {
        return houseMapper.getByUserId(id);
    }

    public House getById(String id) {
        return houseMapper.getById(id);
    }

    public int updateByPrimaryKeySelective(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public int updateByIsdel(String id, Integer isdel) {
        House house = new House();
        house.setId(id);
        house.setIsdel(isdel);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public PageInfo<House> selectByIspass(Integer ispass, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<House> houses = houseMapper.selectByIspass(ispass);
        PageInfo<House> pageInfo = new PageInfo(houses);
        return pageInfo;
    }


    public int updateByIspass(String id, Integer ispass) {
        House house = new House();
        house.setId(id);
        house.setIspass(ispass);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    public PageInfo<House> selectByPage(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getRows());
        List<House> houses = houseMapper.selectByPage(houseCondition);
        PageInfo<House> pageInfo = new PageInfo<House>(houses);
        return pageInfo;
    }
}
