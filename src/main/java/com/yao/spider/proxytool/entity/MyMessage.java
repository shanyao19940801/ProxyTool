package com.yao.spider.proxytool.entity;

import java.util.List;

/**
 * Created by shanyao on 2018/4/6.
 */
public class MyMessage {
    //返回状态：200 成功  400 错误
    int status;
    List<Proxy> proxyList;
    int resultCount;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Proxy> getProxyList() {
        return proxyList;
    }

    public void setProxyList(List<Proxy> proxyList) {
        this.proxyList = proxyList;
    }

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }
}
