package com.team.house.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.service.DistrictService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    public List<District> getAllDistrict() {
        return districtMapper.selectByExample(new DistrictExample());
    }

    public PageInfo<District> getDisrictByPage(PageUtil pageInfo) {
        PageHelper.startPage(pageInfo.getPage(),pageInfo.getRows());
        DistrictExample district = new DistrictExample();
        List<District> districtList = districtMapper.selectByExample(district);
        PageInfo<District> pageInfo1 = new PageInfo(districtList);
        return pageInfo1;
    }

    public int addinsert(District district) {
        return districtMapper.insertSelective(district);
    }

    public District selectByPrimaryKey(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    public int delDistrict(Integer id) {
        return districtMapper.deleteByPrimaryKey(id);
    }

    public int removeStreet(Integer id) {
        return districtMapper.delStreet(id);
    }

    public int delMoreDistrict(Integer[] ids) {
        return districtMapper.delMoreDistrict(ids);
    }

    public int delMoreStreet(Integer[] ids) {
        return districtMapper.delMoreStreet(ids);
    }
}
