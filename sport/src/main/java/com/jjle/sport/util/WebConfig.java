package com.jjle.sport.util;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//处理跨域问题
@Configurable
public class WebConfig extends WebMvcConfigurerAdapter {
    //跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
                 .allowedOrigins("http://localhost:9000,null")       //允许的跨域的域名
                 .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")     //允许的跨域方法
                 .maxAge(3600)    //最大相应时间
                 .allowCredentials(true);
    }
}
