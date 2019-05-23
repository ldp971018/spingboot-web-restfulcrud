package com.ldp.spingboot.component;

/**
 * @author Return
 * @create 2019-05-23 10:27
 */

import org.omg.CORBA.Object;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 * 可以在请求的时候携带区域信息，我们这里设置的变量的时候local
 *  1）、需要有这种效果，那么就必须实现LocalResolver接口
 */
public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求路径中传输的带有区域信息的参数local
        String local = httpServletRequest.getParameter("local");
        //定义一个Locale对象
        Locale locale =Locale.getDefault();
        //判断请求路径的信息是否为空
        if (!StringUtils.isEmpty(local)){
            //如果不为空那么，获取区域信息 en_US 通过split截取
            String[] split = local.split("_");
            //将获取到的信息赋值给locale
            //public Locale(String language, String country)
            //第一个表示语言 第二个表示国家信息
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }


    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
