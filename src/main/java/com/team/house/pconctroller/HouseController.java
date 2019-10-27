package com.team.house.pconctroller;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.util.HouseCondition;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller(value = "HouseController2")
@RequestMapping("/page/")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping("insertHouse")
    public String insertHouse(House house,
                              @RequestParam(value = "mfile",required = false)MultipartFile mfile,
                              HttpSession session) {
        String originalFilename = mfile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String s = System.currentTimeMillis() + "";
        String fileName = s + substring;
        String path = "G:/image/" + fileName;
        File file = new File(path);
        try {
            mfile.transferTo(file);
            house.setId(s);
            house.setPath(fileName);
            Users users =(Users) session.getAttribute("userinfo");
            house.setUserId(users.getId());
            houseService.insertSelective(house);
            return "redirect:showHouse";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fabu";
    }

    @RequestMapping("showHouse")
    public String showHouse(HttpSession session, Model model){
        Users userinfo =(Users) session.getAttribute("userinfo");
        List<House> byUserId = houseService.getByUserId(userinfo.getId());
        model.addAttribute("list",byUserId);
        return "guanli";
    }

    @RequestMapping("showHouseById")
    public String showHouseById(String id,Model model){
        House byId = houseService.getById(id);
        model.addAttribute("house",byId);
        return "updateHouse";
    }

    @RequestMapping("upHouse")
    public String updateHouse(House house,String oldFile,
                              @RequestParam(value = "mfile",required = false)MultipartFile mfile){
        try {
            if (!mfile.isEmpty()){
                String originalFilename = mfile.getOriginalFilename();
                String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
                String s = System.currentTimeMillis() + "";
                String fileName = s + substring;
                String path = "G:/image/" + fileName;
                File file = new File(path);
                mfile.transferTo(file);
                house.setPath(fileName);
            }
            houseService.updateByPrimaryKeySelective(house);
            if (!mfile.isEmpty()){
                File file = new File("G:\\image\\"+oldFile);
                file.delete();
            }
            return "redirect:showHouse";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }


    @RequestMapping("delHouse")
    @ResponseBody
    public String delHouse(String id){
        int i = houseService.updateByIsdel(id, 1);
        return "{\"result\":"+i+"}";
    }

    @RequestMapping("selectHouse")
    public String selectHouse(HouseCondition houseCondition,Model model){
        PageInfo<House> pageInfo = houseService.selectByPage(houseCondition);
        model.addAttribute("houses",pageInfo);
        model.addAttribute("condition",houseCondition);
        return "list";
    }
}
