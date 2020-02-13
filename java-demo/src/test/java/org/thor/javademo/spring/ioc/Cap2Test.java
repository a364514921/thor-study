package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.ioc.cap2.config.Cap2MainConfig;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap2Test {

    @Test
    public void componentScanTest() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap2MainConfig.class);

        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));
    }
}
