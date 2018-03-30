package com.yao.spider;

import com.yao.spider.proxytool.ProxyHttpClient;

/**
 * Created by user on 2018/3/30.
 */
public class StartClass {
    public static void main(String[] args) {
        ProxyHttpClient.getInstance().startProxy();
    }
}
