package com.team.house.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }

    public PageInfo<Type> getTypeByPage(PageUtil pageInfo) {
        PageHelper.startPage(pageInfo.getPage(),pageInfo.getRows());
        TypeExample type = new TypeExample();
        List<Type> TypeList = typeMapper.selectByExample(type);
        PageInfo<Type> pageInfo1 = new PageInfo(TypeList);
        return pageInfo1;
    }

    public int addinsert(Type type) {
        return typeMapper.insertSelective(type);
    }

    public Type selectByPrimaryKey(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    public int delType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }


    public int delMoreType(Integer[] ids) {
        return typeMapper.delMoreType(ids);
    }

}
