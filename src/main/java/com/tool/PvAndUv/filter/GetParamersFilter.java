package com.tool.PvAndUv.filter;

import ch.qos.logback.classic.ViewStatusMessagesServlet;
import com.tool.PvAndUv.DataStructure.UrlData;
import com.tool.PvAndUv.DataStructure.VisitorsData;
import com.tool.PvAndUv.Entity.Client;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Map;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 * 过滤器获取请求和URL
 */
@Component
//@ServletComponentScan
//@WebFilter(urlPatterns = "/*", filterName = "getParamersFilter")
public class GetParamersFilter implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用，该方法只有返回true才能继续，
     * 执行后面的拦截器和controller
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、计算url的访问量
        getProcess(request);
        String url = request.getRequestURL().toString();
        UrlData.addUrlCount(url);

        //2、加入客户端
        Client client = getProcess(request);
        VisitorsData.addClient(client);
        return true;
    }

    /**
     * 请求处理之后，DispatcherServlet进行视图渲染之前进行调用，
     * 可以在这个方法中对Controller处理之后的ModelAndView进行操作
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束之后，
     * 也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 处理请求数据，并将请求中的内容封装成Client
     *
     * @param request
     * @return
     */
    private Client getProcess(HttpServletRequest request) {
        System.out.println("========GET PROCESS=======");
        System.out.println(request.getRequestURL());

        Map<String, String[]> requestMsg = request.getParameterMap();
        Enumeration<String> requestHeader = request.getHeaderNames();
        Client client = new Client();

        System.out.println("=========Header=========");
        while (requestHeader.hasMoreElements()) {
            String headerKey = requestHeader.nextElement().toString();
            if(headerKey.equals("host")){
                client.setHost(request.getHeader(headerKey));
            }
            System.out.println("headerKey = " + headerKey + "; value=" + request.getHeader(headerKey));
        }

        System.out.println("--------parameter--------");
        for (Map.Entry<String, String[]> entry : requestMsg.entrySet()) {
            for (int i = 0; i < entry.getValue().length; i++) {
                System.out.println(entry.getKey() + ":" + entry.getValue()[i]);
            }
        }

        System.out.println(request.getRemoteAddr()+"======="+request.getRemoteHost()+"=========");

        client.setAccessTime(String.valueOf(System.currentTimeMillis()));
        client.setIpAddress(request.getRemoteAddr());
        client.setUrl(request.getRequestURL().toString());
        client.setPath(request.getServletPath());
        return client;
    }
}
