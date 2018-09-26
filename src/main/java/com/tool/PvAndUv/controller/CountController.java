package com.tool.PvAndUv.controller;

import com.tool.PvAndUv.service.GetCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      获得访问数量数据，异步的方式
 */
@RestController
public class CountController {
    @Autowired
    private GetCountService getCountService;

    @RequestMapping(value="/getUrlCount",method = RequestMethod.GET)
    public Map<String,Integer> getUrlCount(){
        return getCountService.getUrlCount();
    }

}
