package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.util.PageUtil;

import java.util.List;

public interface StreetService {

    PageInfo<Street> getStreetByPage(PageUtil pageInfo,Integer id);

    List<Street> selectByExample(Integer did);

}
