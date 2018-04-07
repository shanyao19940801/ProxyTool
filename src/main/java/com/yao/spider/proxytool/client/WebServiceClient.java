package com.yao.spider.proxytool.client;

import com.yao.spider.proxytool.entity.Proxy;
import com.yao.spider.utils.CxfInvokeUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shanyao on 2018/4/6.
 */
public class WebServiceClient {
    public static void main(String[] args) {

//        String url = "http://localhost:8080/services/GetProxys?wsdl";
        String url = "http://122.112.245.251:8080/services/GetProxys?wsdl";
        String method = "getProxyList";
        try {
            String result = (String) CxfInvokeUtil.invoke(url,method,new HashMap());
            JSONObject object = JSONObject.fromObject(result);
            int status = object.getInt("status");
            if (status == 200) {
                JSONArray jsonArray = object.getJSONArray("proxyList");
                List<Proxy> proxyList = (List<Proxy>) jsonArray.toCollection(jsonArray, Proxy.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
