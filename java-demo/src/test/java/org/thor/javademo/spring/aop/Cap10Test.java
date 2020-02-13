package org.thor.javademo.spring.aop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thor.javademo.spring.aop.cap10.Cap10MainConfigOfAop;
import org.thor.javademo.spring.aop.cap10.service.CalculateService;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:07
 * @Version: V1.0
 */
public class Cap10Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap10MainConfigOfAop.class);

        // 从容器中获取所有bean
        String[] names = app.getBeanDefinitionNames();
        Arrays.asList(names).stream().forEach(s -> System.out.println(s));

        System.out.println("容器创建完成...");

        CalculateService calculatorService = (CalculateService) app.getBean("calculateService");
        calculatorService.div(4 , 2);

        System.out.println("关闭容器...");
        app.close();
    }

}
