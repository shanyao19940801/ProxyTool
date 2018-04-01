package com.yao.spider;

import com.yao.spider.proxytool.ProxyHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 单耀 on 2018/1/24.
 */
public class StartClass {
    private static Logger logger = LoggerFactory.getLogger(StartClass.class);
    public static void main(String[] args) {
        ProxyHttpClient.getInstance().startProxy();

    }
}
