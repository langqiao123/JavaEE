Rest service 接口
运行步骤：
1, 打包为war包
2, 部署到容器内
3, 测试请求
http://127.0.0.1:8080/RestTest/service/test?data=test
 成功请求后将返回：
rest testing query param: [data = test]  

此外针对于http请求依赖于2个jar包
分别是：
/JavaEE/WebContent/WEB-INF/lib/httpclient-4.1.3.jar
/JavaEE/WebContent/WEB-INF/lib/httpcore-4.1.4.jar
  


1.jersey框架，实现rest交互：
asm-3.1.jar
jersey-client-1.0.3.jar
jersey-core-1.0.3.jar
jersey-json-1.0.3.jar
jersey-server-1.0.3.jar
jsr311-api-1.0.jar
2.做日志：
commons-logging-1.1.1.jar
log4j-1.2.15.jar
slf4j-api-1.6.1.jar
slf4j-log4j12-1.6.1.jar

3.servlet3.0:
servlet3.0支持annotation，
tomcat7支持servlet3.0
servlet3.0规范对应于jsp2.2规范


4.struts2jar包
commons-fileupload-1.3.1.jar
commons-io-2.2.jar
commons-lang3-3.1.jar
freemarker-2.3.19.jar
javassist-3.11.0.GA.jar
ognl-3.0.6.jar
struts2-core-2.3.16.3.jar
xwork-core-2.3.16.3.jar
struts2-convention-plugin-2.3.16.3.jar  (struts2的convention插件，)
struts2-config-browser-plugin-2.3.16.3.jar(提供页面查询web服务器部署的action信息)

5.fastjson-1.1.8.jar
操作转换json数据的jar包

6.cas-client-core-3.2.1.jar
单点登录sso依赖的客户端jar包