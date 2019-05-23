package com.ldp.spingboot.config;

import com.ldp.spingboot.filter.Myfilter;
import com.ldp.spingboot.listener.Mylistener;
import com.ldp.spingboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Return
 * @create 2019-05-23 19:39
 */
//定义一个关于服务器的配置的类
@Configuration
public class MyServerConfig {

    //servlet容器注册三大组件
    //向容器当中添加servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myservlet");
        return registrationBean;
    }

    //向容器当中添加过滤器
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean  registrationBean= new FilterRegistrationBean();
        //添加自己定义的过滤器
        registrationBean.setFilter(new Myfilter());
        //添加需要拦截的路径
        registrationBean.setUrlPatterns(Arrays.asList("/test","/myservlet"));
        return registrationBean;
    }

    
    //向容器当中添加监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<Mylistener>  listener = new ServletListenerRegistrationBean<Mylistener>(new Mylistener());
        return listener;
    }
}
