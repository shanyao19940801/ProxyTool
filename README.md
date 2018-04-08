# 代理获取工具
这个小工具是从我之前写的一个爬虫项目中分离出来的，主要是为了部署在我的服务器上然后空闲时间爬取代理以便使用
## 主要功能
* 定时自动爬取免费代理
  本项目中使用定时功能每天会爬取三次代理，爬取代理后会序列化在本地的文件中，
* 提够webservice接口
  目前项目只提供一种获取方式：webserice接口获取，代用该接口可以获取已经爬取的免费代理
  返回数据类型：json字符串
  实例：[请求实例](https://github.com/shanyao19940801/ProxyTool/blob/master/src/main/java/com/yao/spider/proxytool/client/WebServiceClient.java)
  url地址：[URL]（http://122.112.245.251:8080/services/GetProxys?wsdl）
  参数：无
