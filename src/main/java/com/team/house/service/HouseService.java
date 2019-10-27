package com.team.house.service;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.util.HouseCondition;
import com.team.house.util.PageUtil;

import java.util.List;

public interface HouseService {

    int insertSelective(House record);

    List<House> getByUserId(Integer id);

    House getById(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByIsdel(String id,Integer isdel);

    PageInfo<House> selectByIspass(Integer ispass, PageUtil pageUtil);

    int updateByIspass(String id,Integer ispass);

    PageInfo<House> selectByPage(HouseCondition houseCondition);
}
