package com.team.house.pconctroller;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/page/")
@RestController(value = "StreetController2")
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getAllStreet")
    public List<Street> getAllStreet(Integer did){
        return streetService.selectByExample(did);
    }

}
