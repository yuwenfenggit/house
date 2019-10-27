package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.util.PageUtil;

import java.util.List;

public interface DistrictService {

    List<District> getAllDistrict();

    PageInfo<District> getDisrictByPage(PageUtil pageInfo);

    int addinsert(District district);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District district);

    int delDistrict(Integer id);

    int removeStreet(Integer id);

    int delMoreDistrict(Integer[] ids);

    int delMoreStreet(Integer[] id);
}
