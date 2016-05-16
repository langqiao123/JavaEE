1.Struts2核心库的源代码是放在struts-2.1.2/src/core/src/main/java路径下
Struts2插件的源代码是放在struts-2.1.2/src/plugins/插件名/src/main/java路径下
XWork源代码是放在xwork-2.1.2/src/java

2.javassist-3.11.0.GA.jar:这个jar是一个动态编辑、生成java字节码的类库(类似cglib)
不过性能更好

3.在struts2-core.jar中的org\apache\struts2下有一个default.properites文件
该文件为struts2的所有常量指定了默认值。


4.struts2框架按照如下搜索顺序加载struts2的常量
struts-default.xml
struts-plugin.xml
struts.xml
struts.properties
web.xml