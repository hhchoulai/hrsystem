package com.hhc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AcrossInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        //设置允许跨域访问
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));

        //设置跨域请求允许携带数据 --->cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");

        return true;
    }

}