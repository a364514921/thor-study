package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.ioc.cap6.config.Cap6MainConfig;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap6Test {

    @Test
    public void importTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap6MainConfig.class);

        Object bean1 = app.getBean("jamesFactoryBean");
        Object bean2 = app.getBean("jamesFactoryBean");
        Object bean3 = app.getBean("&jamesFactoryBean");
        System.out.println("bean的类型：" + bean1.getClass());
        System.out.println("bean的类型：" + bean2.getClass());
        System.out.println("bean的类型：" + bean3.getClass());
        System.out.println(bean1 == bean2);

        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        System.out.println("-----------------");

    }
}
