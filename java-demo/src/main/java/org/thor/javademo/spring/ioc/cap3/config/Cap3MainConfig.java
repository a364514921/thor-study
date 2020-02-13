package org.thor.javademo.spring.ioc.cap3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thor.javademo.spring.bean.Person;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
public class Cap3MainConfig {

//    @Scope("prototype")
    @Bean
    public Person person() {
        return new Person();
    }
}
