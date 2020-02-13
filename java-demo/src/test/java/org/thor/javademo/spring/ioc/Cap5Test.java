package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.bean.Person;
import org.thor.javademo.spring.ioc.cap5.config.Cap5MainConfig;

import java.util.Map;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap5Test {

    @Test
    public void macConditionTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap5MainConfig.class);

        Map<String, Person> map = app.getBeansOfType(Person.class);
        System.out.println(map);

        System.out.println("-----------------");

    }
}
