package com.yao.spider.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shanyao on 2018/4/1.
 * 用于打印代理信息
 */
public class ProxyInfoPrintTask implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(ProxyInfoPrintTask.class);
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 * 30);
                logger.info("当前可用代理：");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
