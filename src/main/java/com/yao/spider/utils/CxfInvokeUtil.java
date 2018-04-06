package com.yao.spider.utils;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by shanyao on 2018/3/25.
 */
public class CxfInvokeUtil {
    private static Logger logger = LoggerFactory.getLogger(CxfInvokeUtil.class);

    public static Object invoke(String wdslURL, String mehod, Map params) throws Exception {
        JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactory.createClient(wdslURL);
        Object[] objects = null;
        if (StringUtils.isEmpty(wdslURL)) {
            logger.error("url确实");
            return objects;
        }

        if (StringUtils.isEmpty(mehod)) {
            logger.error("method缺失");
            return objects;
        }
        String paramJson = JSONSerializer.toJSON(params).toString();
        objects = client.invoke(mehod, paramJson);
        return objects;
    }
}
