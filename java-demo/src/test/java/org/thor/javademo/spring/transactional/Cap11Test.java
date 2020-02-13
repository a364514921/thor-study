package org.thor.javademo.spring.transactional;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.transactional.cap11.Cap11MainConfig;
import org.thor.javademo.spring.transactional.cap11.service.OrderService;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap11Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap11MainConfig.class);

        // 从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        System.out.println("容器创建完成...");

        OrderService orderService = (OrderService) app.getBean("orderService");
        orderService.addOrder();

        System.out.println("关闭容器...");
        app.close();
    }

}
