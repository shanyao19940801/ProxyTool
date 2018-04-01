package com.yao.spider;

import com.yao.spider.proxytool.ProxyHttpClient;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by shanyao on 2018/4/1.
 */
public class AutoStartClass implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ProxyHttpClient.getInstance().startProxy();

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
