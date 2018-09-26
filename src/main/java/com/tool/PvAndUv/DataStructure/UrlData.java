package com.tool.PvAndUv.DataStructure;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 */
@Component
public class UrlData {

    /**
     * 统计url的数量
     */
    private static ConcurrentHashMap<String,AtomicInteger> urlCount = new ConcurrentHashMap<String,AtomicInteger>();

//    private static ConcurrentHashMap<Map<String,String>,AtomicInteger> = new ConcurrentHashMap<Map<String,String>,AtomicInteger>();

    /**
     * 统计url的访问量
     * @param url
     */
    public static void addUrlCount(String url){
        if(urlCount.containsKey(url)){
            urlCount.get(url).getAndIncrement();
        }else{
            urlCount.put(url,new AtomicInteger(1));
        }
    }

    /**
     * 获得url的访问量数据
     * @param url
     * @return
     */
    public static int getAddUrlCount(String url){
        if(urlCount.containsKey(url)){
            return urlCount.get(url).get();
        }else{
            return 0;
        }
    }

    /**
     * 列出所有的url数量信息
     */
    public static void listUrlInfo(){
        for(Map.Entry<String,AtomicInteger> entry:urlCount.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

    /**
     * 获得所有url的访问数量
     */
    public static Map<String,Integer> getUrlInfo(){
        Map<String,Integer> result = new HashMap<String,Integer>();
        for(Map.Entry<String,AtomicInteger> entry:urlCount.entrySet()){
            result.put(entry.getKey(),entry.getValue().get());
        }
        return result;
    }
}