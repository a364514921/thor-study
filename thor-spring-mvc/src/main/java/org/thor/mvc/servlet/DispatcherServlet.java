package org.thor.mvc.servlet;


import org.thor.mvc.adapter.HandleAdapterService;
import org.thor.mvc.annotation.ThorAutowired;
import org.thor.mvc.annotation.ThorController;
import org.thor.mvc.annotation.ThorRequestMapping;
import org.thor.mvc.annotation.ThorService;
import org.thor.mvc.controller.DemoController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用来初始化bean和拦截请求
 * @author: wangyiqiang
 * @date: 2020-02-14 下午6:42
 * @version: V1.0
 */
public class DispatcherServlet extends HttpServlet {

    /**
     * 处理器名称
     */
    private static final String HANDLER_ADAPTER = "thorHandleAdapter";

    /**
     * bean容器
     */
    protected Map<String, Object> beansMap = new HashMap<>(16);

    /**
     * url映射处理器handleMap
     */
    protected Map<String, Object> handleMap = new HashMap<>(16);

    /**
     * 包下所有class类
     */
    protected List<String> classNames = new ArrayList<>();

    private HandleAdapterService handleAdapterService;

    /**
     * tomcat启动时初始化方法
     *
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        // 1.根据一个基础包进行扫描，扫描包及子包下的所有类
        this.scanPackage("org.thor.mvc");

        // 2.把扫描出来的类进行实例化
        this.instanceBean();
        for (Map.Entry<String, Object> entry : this.beansMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 3.依赖注入，把service的依赖注入到controller类中
        this.dependenceInject();

        // 4.建立一个URL和controller类中method的映射关系
        this.handleMapping();
        for (Map.Entry<String, Object> entry : this.handleMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
//        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求路径 /thor-spring-mvc/demo/query
        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        // 将contextPath去掉， /thor-spring-mvc/demo/query -> /demo/query
        String path = requestURI.replaceAll(contextPath, "");

        // 2.根据请求的路径获取要执行的方法
        Method method = (Method) this.handleMap.get(path);

        // 3.拿到控制类
        DemoController demoController = (DemoController) this.beansMap.get("/" + path.split("/")[1]);

        // 4.处理器(策略模式)处理方法上的请求参数
        handleAdapterService = (HandleAdapterService) this.beansMap.get(HANDLER_ADAPTER);
        Object[] args = handleAdapterService.handle(req, resp, method, this.beansMap);

        // 5.执行方法
        try {
            method.invoke(demoController, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    /**
     * 根据一个基础包进行扫描，扫描包及子包下的所有类
     */
    private void scanPackage(String basePackage) {
        // 扫描编译好的类路径下所有的类
        URL url = this.getClass().getClassLoader().getResource("/" + this.replaceTo(basePackage));
        // 获取文件根路径
        String pathDir = url.getFile();
        File fileDir = new File(pathDir);
        // 该路径下所有文件
        String[] filesStr = fileDir.list();
        // 获取包下所有class类
        for (String path : filesStr) {
            File filePath = new File(pathDir + path);
            if (filePath.isDirectory()) {
                this.scanPackage(basePackage + "." + path);
            } else {
                // 如果是class文件，则加入classList（待生成bean）
                classNames.add(basePackage + "." + path);
            }
        }

        String path = url.getPath();
    }

    private String replaceTo(String basePacket) {
        return basePacket.replaceAll("\\.", "/");
    }

    /**
     * 把扫描出来的类通过反射进行实例化
     */
    private void instanceBean() {
        List<String> classNames = this.classNames;
        if (classNames == null || classNames.size() <= 0) {
            System.out.println("包扫描失败...");
        }

        // 遍历扫描到的class文件，将需要实例化的类（加了注解的类）通过反射创建对象
        for (String className : classNames) {
            // 编译后的class文件：org.thor.mvc.controller.DemoController.class
            className = className.replaceAll(".class", "");

            try {
                // 获取class类，用来实例化
                Class<?> clazz = Class.forName(className);
                // 判断是否标记了ThorController注解
                if (clazz.isAnnotationPresent(ThorController.class)) {
                    ThorController controller = clazz.getAnnotation(ThorController.class);
                    // 从RequestMapping中获取请求路径，用路径作为实例的key
                    ThorRequestMapping requestMapping = clazz.getAnnotation(ThorRequestMapping.class);
                    beansMap.put(requestMapping.value(), clazz.newInstance());
                } else if (clazz.isAnnotationPresent(ThorService.class)) {
                    // 获取当前clazz类的注解(通过这个注解可得到当前service的id)  @org.thor.mvc.annotation.ThorService(value=ThorServiceImpl)
                    ThorService service = clazz.getAnnotation(ThorService.class);
                    beansMap.put(service.value(), clazz.newInstance());
                } else {
                    continue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 依赖注入,把service的依赖注入到controller类中
     */
    private void dependenceInject() {
        if (this.beansMap.entrySet().isEmpty()) {
            System.out.println("找不到实例化的类...");
            return;
        }

        for (Map.Entry<String, Object> map : this.beansMap.entrySet()) {
            //获取bean实例
            Object instance = map.getValue();
            //获取类,用来判断类里声明了哪些注解(主要是针对控制类里的判断,比如使用了@Autowired  @Qualifier,对这些注解进行解析)
            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(ThorController.class)) {
                // 获取类属性
                Field[] fields = clazz.getDeclaredFields();
                // 遍历属性，@Autowired  @Qualifier,对这些注解进行解析
                for (Field field : fields) {
                    if (field.isAnnotationPresent(ThorAutowired.class)) {
                        // 拿到@ThorAutowired("DemoServiceImpl")里的指定要注入的bean名字"demoService"
                        ThorAutowired qualifier = field.getAnnotation(ThorAutowired.class);
                        String beanName = qualifier.value();
                        // 授权
                        field.setAccessible(true);
                        try {
                            field.set(instance, this.beansMap.get(beanName));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 建立一个URL和controller类中method的映射关系
     */
    private void handleMapping() {
        if (this.beansMap.size() <= 0) {
            System.out.println("找不到是实例化的类...");
            return;
        }

        for (Map.Entry<String, Object> map : this.beansMap.entrySet()) {
            // 获取bean实例
            Object instance = map.getValue();
            Class<?> clazz = instance.getClass();
            // 获取所有Controller类
            if (clazz.isAnnotationPresent(ThorController.class)) {
                // 获取Controller类上面的ThorRequestMapping注解里的请求路径
                ThorRequestMapping annotationCtrl = clazz.getAnnotation(ThorRequestMapping.class);
                String classPath = annotationCtrl.value();

                // 获取Controller类下的所有方法
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(ThorRequestMapping.class)) {
                        // 获取Controller类下方法上ThorRequestMapping注解里的请求路径
                        ThorRequestMapping annotationMethod = method.getAnnotation(ThorRequestMapping.class);
                        String methodPath = annotationMethod.value();
                        // 把方法上与路径建立映射关系( /demo/query--->public void org.thor.mvc.controller.DemoController.query )
                        handleMap.put(classPath + methodPath, method);
                    }
                }
            }
        }
    }
}
