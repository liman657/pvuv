package com.tool.PvAndUv.service.impl;

import com.tool.PvAndUv.DataStructure.UrlData;
import com.tool.PvAndUv.service.GetCountService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.Map;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 */
@Service("GetCountService")
public class GetCountServiceImpl implements GetCountService {

    @Override
    @Scheduled(fixedRate = 5000)
    public Map<String, Integer> getUrlCount() {
        System.out.println("每5秒获取一次访问统计数据，当前时间："+System.currentTimeMillis());
        Map<String, Integer> urlInfoCount = UrlData.getUrlInfo();
        for(Map.Entry<String,Integer> entry:urlInfoCount.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        return urlInfoCount;
    }
}
