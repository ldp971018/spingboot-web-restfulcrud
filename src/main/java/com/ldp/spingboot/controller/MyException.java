package com.ldp.spingboot.controller;

import com.ldp.spingboot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Return
 * @create 2019-05-23 18:50
 */
@ControllerAdvice
public class MyException {

    //在浏览器显示了json数据，无法自适应
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> test(Exception e){
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("status","200");
//        map.put("message","用户不存在");
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String test(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        //我们需要传入自己的错误状态码 4xx 5xx ，不然进入不了我们自己定义错误信息的页面
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user notexist");
        map.put("message",e.getMessage());
        request.setAttribute("exc",map);
        return "forward:/error";
    }
}
