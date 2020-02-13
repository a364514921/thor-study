package org.thor.javademo.spring.ioc.cap4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.thor.javademo.spring.bean.Person;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
public class Cap4MainConfig {

    @Lazy
    @Bean
    public Person person() {
        System.out.println("IOC容器创建完成...");
        return new Person("wangyq", 18);
    }
}
