package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.ioc.cap3.config.Cap3MainConfig;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap3Test {

    @Test
    public void scopeTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap3MainConfig.class);

        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        // 从容器中取两次person实例，看是否为同一个bean
        Object person1 = app.getBean("person");
        Object person2 = app.getBean("person");
        System.out.println(person1 == person2);
    }
}
