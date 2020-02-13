package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.ioc.cap7.config.Cap7MainConfig;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap7Test {

    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap7MainConfig.class);

        System.out.println("容器创建完成...");

        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));


//        app.getBean("bike");

        // 单实例模式下，当关闭容器时候销毁 ；多实例IOC容器不负责销毁，是由自己来控制
        System.out.println("关闭容器...");
        app.close();
    }
}
