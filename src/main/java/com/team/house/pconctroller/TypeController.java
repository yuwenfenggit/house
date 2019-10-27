package com.team.house.pconctroller;

import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "TypeController2")
@RequestMapping("/page/")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("getAllType")
    public List<Type> getAllType(){
        return typeService.getAllType();
    }
}
