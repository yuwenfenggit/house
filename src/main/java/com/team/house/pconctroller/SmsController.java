package com.team.house.pconctroller;

import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.util.sms.SentMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

public class SmsController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("sendCode")
    @ResponseBody
    public String sendCode(String sendPhone,HttpSession session){
        int i = (int)(Math.random() * 10000);
        String msg="登入的验证码是:"+i;
        int sendMsg = SentMsgUtil.sendMsg(sendPhone, msg);
        session.setAttribute("saveocde",i);
        return "{\"result\":"+sendMsg+"}";
    }


    @RequestMapping("loginByPhone")
    public String loginByPhone(String telephone,String code,HttpSession session){
        Object saveocde = session.getAttribute("saveocde");
        Users login = usersService.loginUser(telephone);
        if (login!=null && code.equals(saveocde.toString())){
            session.setAttribute("userinfo",login);
            return "redirect:showHouse";
        }else {
            return "login";
        }
    }
}
