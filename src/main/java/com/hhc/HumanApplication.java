package com.hhc;

import com.hhc.interceptor.AcrossInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan(basePackages = {"com.hhc.mapper"})
public class HumanApplication implements WebMvcConfigurer {
//    解决跨域
    @Autowired
    private AcrossInterceptor acrossInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(acrossInterceptor).addPathPatterns("/**");
    }

    public static void main(String[] args) {
        SpringApplication.run(HumanApplication.class, args);
    }

}
