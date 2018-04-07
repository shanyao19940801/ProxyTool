package com.yao.spider;

import com.yao.spider.proxytool.ProxyHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by shanyao on 2018/4/1.
 */
public class AutoStartClass implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(AutoStartClass.class);
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("------开始----");
        ProxyHttpClient.getInstance().startProxy();

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
