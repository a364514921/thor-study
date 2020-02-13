package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.ioc.cap4.config.Cap4MainConfig;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap4Test {

    @Test
    public void lazyTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap4MainConfig.class);

        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        System.out.println("-----------------");

        Object person = app.getBean("person");
        System.out.println(person);

    }
}
