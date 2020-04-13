# Springboot + Dubbo 开发笔记

## 出现警告，解决办法

```log
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by javassist.ClassPool (file:/C:/Users/mwlbj/.m2/repository/org/javassist/javassist/3.20.0-GA/javassist-3.20.0-GA.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of javassist.ClassPool
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
```
出现这个问题的原因是项目引用的JDK版本过高导致的，将JDK版本降到1.8即可。
项目右键 -> open module settings -> 将 project 和 modules 里面的 dependences 里面的jdk配置改为1.8

## 访问controller的时候报错


javax.servlet.ServletException: Circular view path [/getUser]: would dispatch back to the current handler URL [/getUser] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
	at org.springframework.web.servlet.view.InternalResourceView.prepareForRendering(InternalResourceView.java:210) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.view.InternalResourceView.renderMergedOutputModel(InternalResourceView.java:148) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.view.AbstractView.render(AbstractView.java:316) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1373) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1118) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1057) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.2.5.RELEASE.jar:5.2.5.RELEASE]

解决方法：在controller上面添加 @RestController 或者在方法上面添加 @ResponseBody，应为服务返回的都是 json 格式数据