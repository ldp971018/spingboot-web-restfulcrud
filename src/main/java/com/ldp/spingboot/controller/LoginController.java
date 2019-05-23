package com.ldp.spingboot.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Return
 * @create 2019-05-23 10:55
 */
@RequestMapping("/user")
@Controller
public class LoginController {

    /**
     * 进行用户登录并且请求方式必须为的post请求的方法
     * 并且我们指定了参数的参数名必须是我们指定的参数名称
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = {"/login"})
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpServletRequest request){
        //判断传输过的参数是否为空
        if (!StringUtils.isEmpty(username)&& "admin".equals(password)){
            //如果传输过来的用户名不为空，并且密码输入未123456，那么登录成功
            request.getSession().setAttribute("username",username);
            return "redirect:/main.html";
        }else{
            //添加错误信息
            String error="用户名或密码错误,请重新登录";
            model.addAttribute("errorMsg",error);
            return "login";
        }
    }
}
