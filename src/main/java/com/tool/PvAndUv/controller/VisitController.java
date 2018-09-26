package com.tool.PvAndUv.controller;

import com.tool.PvAndUv.service.GetCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 */
@RestController
public class VisitController {



    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String sayHello(){
        return "hello";
    }

    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String sayTest(){
        return "test";
    }
}
