package com.ldp.spingboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Return
 * @create 2019-05-23 11:29
 * 该类主要用于作为登录的拦截作用：
 *  1）.首先要实现HandlerInterceptor接口
 */
public class LoginInterceptor implements HandlerInterceptor {


    //该方法是在请求映射前跳转的到的方法，相当于过滤器中的是否放行的一个概念
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //首先获取在session对象的中的user对象，并且判断其是存在
        Object user = request.getSession().getAttribute("username");
        if (user!=null){
            //已登录
            return true;
        }else{
            //未登陆
            request.setAttribute("errorMsg","请先进行登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
    }

    //目标方法执行之后，但是还未进行视图解析之前调用的方法，在此方法可以修改跳转的页面，
    //一般可以用来进行权限的跳转
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在所有解析之后的会执行的方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
