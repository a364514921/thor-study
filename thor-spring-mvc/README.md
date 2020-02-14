# 手写SpringMVC

> 摘要：实现简单SpringMVC

### 1.新建maven项目并添加响应的依赖
```text
         <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>3.0-alpha-1</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
```

### 2.自定义注解、对应Controller类、Service类  
@ThorController、@ThorAutowired、@ThorRequestParam、@ThorRequestMapping、@ThorService
DemoController、DemoServiceImpl、DemoService

### 3.新建DispatcherServlet用来初始化bean和拦截请求，并配置web.xml
```xml
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
    <display-name>Archetype Created Web Application</display-name>

    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <display-name>DispatcherServlet</display-name>
        <servlet-class>org.thor.mvc.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>0</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```    
    
### 4.实现DispatcherServlet
继承HttpServlet，重写继承HttpServlet中的初始化方法init()，doGet()、doPost()方法处理请求

* 4.1 tomcat启动时初始化方法init()

    1.根据一个基础包进行扫描，扫描包及子包下的所有类                          

    2.把扫描出来的类通过**反射**进行实例化,放入bean容器beanMap

    3.依赖注入，把service的依赖注入到controller类中
 
    4.建立一个URL和controller类中method的映射关系 

* 4.2 实现doPost()方法处理请求逻辑
    
    1.获取请求路径 /thor-spring-mvc/demo/query
    
    2.根据请求的路径获取要执行的方法
    
    3.从容器中拿到控制类
    
    4.创建一个处理器处理请求参数 
    
    5.策略模式实现参数解析器解析方法中各种类型的参数，如: HttpServletRequest、HttpServletResponse、String等

    6.执行方法 

### 5.测试
打开浏览器，输入[http://localhost:8080/thor_spring_mvc/demo/query?name=wangxiaoqiang&age=18](http://localhost:8080/thor_spring_mvc/demo/query?name=wangxiaoqiang&age=18)

成功返回： ?????name = wangxiaoqiang, age = 18