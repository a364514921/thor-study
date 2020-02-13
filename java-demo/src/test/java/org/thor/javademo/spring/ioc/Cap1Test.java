package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.thor.javademo.spring.bean.Person;
import org.thor.javademo.spring.ioc.cap1.config.MainConfig;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap1Test {

    /**
     * xml形式注册bean
     */
    @Test
    public void xmlTest() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) app.getBean("person");
        System.out.println(person);
    }

    /**
     * @bean注解形式注入
     */
    @Test
    public void beanAnnotationTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNamesForType = app.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }
}
