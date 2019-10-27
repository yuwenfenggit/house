package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UsersService;
import com.team.house.util.Condition;
import com.team.house.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public PageInfo<Users> getUsersByPage(Condition condition) {
        UsersExample users = new UsersExample();
        UsersExample.Criteria criteria = users.createCriteria();
        if (condition.getName()!=null){
            criteria.andNameLike("%"+condition.getName()+"%");
        }
        if (condition.getTelephone()!=null){
            criteria.andTelephoneLike("%"+condition.getTelephone()+"%");
        }
        List<Users> list = usersMapper.selectByExample(users);
        PageInfo<Users> pageInfo = new PageInfo(list);
        return pageInfo;
    }

    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(Users users) {
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        users.setIsadmin(0);
        return usersMapper.insertSelective(users);
    }

    public int checkByName(String name) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users.size();
    }

    public Users login(String name, String pwd) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(pwd));
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }
}
