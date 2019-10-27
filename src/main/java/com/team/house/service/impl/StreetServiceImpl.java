package com.team.house.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.StreetService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    
    @Autowired
    private StreetMapper streetMapper;


    public PageInfo<Street> getStreetByPage(PageUtil pageInfo,Integer id) {
        PageHelper.startPage(pageInfo.getPage(),pageInfo.getRows());
        StreetExample district = new StreetExample();
        StreetExample.Criteria criteria = district.createCriteria();
        criteria.andDistrictIdEqualTo(id);
        List<Street> districtList = streetMapper.selectByExample(district);
        PageInfo<Street> pageInfo1 = new PageInfo(districtList);
        return pageInfo1;
    }

    public List<Street> selectByExample(Integer did) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        return streetMapper.selectByExample(streetExample);
    }
}
