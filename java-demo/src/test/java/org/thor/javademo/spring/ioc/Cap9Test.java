package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.bean.Sun;
import org.thor.javademo.spring.ioc.cap9.TestDao;
import org.thor.javademo.spring.ioc.cap9.TestService;
import org.thor.javademo.spring.ioc.cap9.config.Cap9MainConfig;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap9Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);
        System.out.println("容器创建完成...");

        // 从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        TestService testService = app.getBean(TestService.class);
        testService.println();

        TestDao testDao = app.getBean(TestDao.class);
        System.out.println("unit test ... " + testDao);

        System.out.println("关闭容器...");
        app.close();
    }


    @Test
    public void test2() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);

        // 从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        System.out.println("\n容器创建完成...\n");

        TestService testService = app.getBean(TestService.class);
        testService.println();

        System.out.println("\n关闭容器...\n");
        app.close();
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);

        // 从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        System.out.println("\n容器创建完成...\n");

        Sun sun = app.getBean(Sun.class);
        System.out.println("sun... moon... " + sun.getMoon());
        System.out.println("moon... " + app.getBean("moon"));

        System.out.println("\n关闭容器...\n");
        app.close();
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);

        // 从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        System.out.println("\n容器创建完成...\n");

        System.out.println("\n关闭容器...\n");
        app.close();
    }
}
