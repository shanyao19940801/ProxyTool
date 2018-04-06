package com.yao.spider.proxytool.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2018/3/30.
 */
@Component("spiderJob")
public class SpiderJob {
    @Scheduled
    public void startSpider() {

    }
}
