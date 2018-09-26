package com.tool.PvAndUv.DataStructure;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 */
@Component
public class AppIdData {

    /**
     * 统计appId的数量
     */
    private static ConcurrentHashMap<String,AtomicInteger> appIdCount = new ConcurrentHashMap<String,AtomicInteger>();

    /**
     * 统计url的访问量
     * @param url
     */
    public static void addUrlCount(String url){
        if(appIdCount.contains(url)){
            AtomicInteger urlValue = appIdCount.get(url);
            urlValue = new AtomicInteger(urlValue.getAndIncrement());
            appIdCount.put(url,urlValue);
        }else{
            appIdCount.put(url,new AtomicInteger(1));
        }
    }

    /**
     * 获得url的访问量数据
     * @param url
     * @return
     */
    public static int getAddUrlCount(String url){
        if(appIdCount.contains(url)){
            return appIdCount.get(url).get();
        }else{
            return 0;
        }
    }
}
