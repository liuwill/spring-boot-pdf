package com.liuwill.text.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "data")
public class DataController {
    
    @RequestMapping(value = "")
    public Map index(){
        Map<String,Object> resultMap = new HashMap<>();

        resultMap.put("status",true);
        resultMap.put("code","data");
        resultMap.put("message","data");
        return resultMap;
    }

}
