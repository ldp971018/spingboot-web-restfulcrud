package com.ldp.spingboot.config;

import com.ldp.spingboot.component.LoginInterceptor;
import com.ldp.spingboot.component.MyLocalResolver;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Return
 * @create 2019-05-23 8:18
 */

/**
 * 如果需要自己定义配置类，来进行扩展功能，
 * @EnableWebMvc 添加了此注解，那么将全面接管springboot中的springmvc的配置，一般不建议这么做
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {



    /*添加视图解析器*/
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ldp").setViewName("success");
    }

    //在springboot容器中所有的WebMvcConfigurerAdapter都会同时起作用
    //public abstract class WebMvcConfigurerAdapter implements WebMvcConfigurer
    //由于WebMvcConfigurerAdapter是一个抽象类，所以我们使用匿名对象
    @Bean   //将组件添加到容器当中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter(){
            //重写里面的方法
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //实现跳转项目根目录以及访问index.html跳转到首页
                //registry
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                //设置登录之后定向，避免刷新页面，重复提交表单信息
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册登录拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //拦截所有请求
                //其中 / /index.html /user/login 不能被拦截
                //静态资源 .css .js 不需要拦截 因为springboot已经帮我做好的了
               registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                      .excludePathPatterns("/","/index.html","/asserts/**","/user/login");
            }
        };
        return  webMvcConfigurerAdapter;
    }

    //向容器当中添加自己定义的localResolver组件
    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocalResolver();
    }


}
