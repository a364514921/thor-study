package org.thor.javademo.spring.ioc;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.ioc.cap12.Cap12mainConfig;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap12Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap12mainConfig.class);

        System.out.println("关闭容器...");
        app.close();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap12mainConfig.class);

        System.out.println("关闭容器...");
        app.close();
    }

}
