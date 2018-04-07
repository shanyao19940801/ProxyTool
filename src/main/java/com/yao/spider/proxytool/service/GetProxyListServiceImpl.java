package com.yao.spider.proxytool.service;

import com.yao.spider.core.constants.ProxyConstants;
import com.yao.spider.core.util.MyIOutils;
import com.yao.spider.proxytool.entity.MyMessage;
import com.yao.spider.proxytool.entity.Proxy;
import com.yao.spider.proxytool.service.IGetProxyListService;
import net.sf.json.JSONSerializer;
import org.eclipse.jetty.util.ajax.JSON;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by shanyao on 2018/4/6.
 */
@WebService(serviceName = "getProxy", endpointInterface = "com.yao.spider.proxytool.service.IGetProxyListService")
public class GetProxyListServiceImpl implements IGetProxyListService{
    public String getProxyList(String param) {
        MyMessage myMessage = new MyMessage();
        List<Proxy> proxyList = null;
        try {
            proxyList = (List<Proxy>) MyIOutils.deserializeObject(ProxyConstants.PROXYSER_FILE_NMAE_EXIST);
            if (proxyList == null) {
                proxyList = (List<Proxy>) MyIOutils.deserializeObject(ProxyConstants.PROXYSER_FILE_NMAE);
            }
        myMessage.setStatus(200);
        myMessage.setResultCount(proxyList.size());
        myMessage.setProxyList(proxyList);
        } catch (Exception e) {
            e.printStackTrace();
            myMessage.setStatus(400);
            myMessage.setResultCount(0);
            return "error";
        }
        String resultString = JSONSerializer.toJSON(myMessage).toString();
        return resultString;
    }
}
