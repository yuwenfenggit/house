package com.team.house.pconctroller;


import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller(value = "UsersController2")
@RequestMapping("/page/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("addUsre")
    public String addUsre(Users users){
        int i = usersService.insertSelective(users);
        if (i>0){
            return "login";
        }else {
            return "regs";
        }
    }


    @RequestMapping("checkUser")
    @ResponseBody
    public String checkUser(String name){
        int i = usersService.checkByName(name);
        return "{\"result\":"+i+"}";
    }


    @RequestMapping("loginUser")
    public String loginUser(String name, String password, HttpSession session){
        Users login = usersService.login(name, password);
        if (login!=null){
            session.setAttribute("userinfo",login);
            return "redirect:showHouse";
        }else {
            return "login";
        }
    }

}
