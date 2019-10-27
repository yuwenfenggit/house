package com.team.house.mapper;


import com.team.house.entity.House;
import com.team.house.util.HouseCondition;
import com.team.house.entity.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> getByUserId(Integer id);

    House getById(String id);

    List<House> selectByIspass(Integer ispass);

    List<House>  selectByPage(HouseCondition houseCondition);
}