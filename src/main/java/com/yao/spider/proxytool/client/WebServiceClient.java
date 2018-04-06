package com.yao.spider.proxytool.client;

import com.yao.spider.utils.CxfInvokeUtil;
import net.sf.json.JSONSerializer;

import java.util.HashMap;

/**
 * Created by shanyao on 2018/4/6.
 */
public class WebServiceClient {
    public static void main(String[] args) {
        String url = "http://localhost:8080/services/GetProxys?wsdl";
        String method = "getProxyList";
        try {
            Object result = CxfInvokeUtil.invoke(url,method,new HashMap());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
