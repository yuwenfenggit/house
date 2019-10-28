package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.util.Condition;

public interface UsersService {

    PageInfo<Users> getUsersByPage(Condition condition);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Users users);

    int checkByName(String name);

    Users login(String name,String pwd);

    Users loginUser(String telephone);
}
