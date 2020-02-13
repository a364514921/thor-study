package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.thor.javademo.spring.bean.Bird;
import org.thor.javademo.spring.ioc.cap8.config.Cap8MainConfig;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap8Test {

    @Test
    public void valueTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap8MainConfig.class);
        System.out.println("容器创建完成...");

        // 从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        // 从容器获取bird对象
        Bird bird = (Bird) app.getBean("bird");
        System.out.println(bird);

        ConfigurableEnvironment environment = app.getEnvironment();
        String property = environment.getProperty("bird.name");
        System.out.println(property);

        System.out.println("关闭容器...");
        app.close();
    }
}
