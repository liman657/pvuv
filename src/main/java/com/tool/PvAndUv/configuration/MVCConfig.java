package com.tool.PvAndUv.configuration;

import com.tool.PvAndUv.filter.GetParamersFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528 * email:657271181@qq.com
 */
@SpringBootConfiguration
public class MVCConfig extends WebMvcConfigurationSupport {

    @Autowired
    private GetParamersFilter getParamersFilter;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getParamersFilter).addPathPatterns("/**").excludePathPatterns("/getUrlCount");
    }

}
