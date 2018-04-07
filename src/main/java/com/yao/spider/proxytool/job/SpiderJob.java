package com.yao.spider.proxytool.job;

import com.yao.spider.core.constants.ProxyConstants;
import com.yao.spider.core.util.MyIOutils;
import com.yao.spider.proxytool.ProxyHttpClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2018/3/30.
 */
@Component("spiderJob")
public class SpiderJob {
    @Scheduled(cron = "0 0 8,16,24 * * ?")
    public void startSpider() {
        MyIOutils.compyFile(ProxyConstants.PROXYSER_FILE_NMAE, ProxyConstants.PROXYSER_FILE_NMAE_EXIST);
        ProxyHttpClient.getInstance().startProxy();
    }
}
