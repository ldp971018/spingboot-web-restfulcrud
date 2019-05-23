package com.ldp.spingboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Return
 * @create 2019-05-23 19:56
 */
//定义一个自己的监听器
public class Mylistener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("正在启动.....contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("正在销毁....contextDestroyed");
    }
}
