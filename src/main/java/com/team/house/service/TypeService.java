package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Type;
import com.team.house.util.PageUtil;

import java.util.List;

public interface TypeService {

    List<Type> getAllType();

    PageInfo<Type> getTypeByPage(PageUtil pageInfo);

    int addinsert(Type type);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type type);

    int delType(Integer id);

    int delMoreType(Integer[] ids);

}
