package com.ldp.spingboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author Return
 * @create 2019-05-23 19:09
 */
//给容器添加一个我们自己定义的异常处理数据的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    //返回的map就是页面能够获取到的数据或者是json数据
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("zuozhe","刘东平");
        webRequest.getAttribute("exc",0);
        return map;
    }
}
