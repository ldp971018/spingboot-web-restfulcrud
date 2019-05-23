package com.ldp.spingboot.controller;

import com.ldp.spingboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Return
 * @create 2019-05-22 16:42
 */
@Controller
public class HelloController {

    /**
     * 设置跳转首页 不管是访问项目根目录，还是的index.html都跳转到templates文件下的首页
     * @return
     */
   /* @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }*/
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h2>这是我第一次使用模板引擎<h2>");
        map.put("users",Arrays.asList("刘东平",22,"男",true));
        return "success";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(@RequestParam("user") String user){

        if ("admin".equals(user)){
           throw  new UserNotExistException();
        }
        return "测试成功";
    }
}
