package org.thor.javademo.spring.ioc.cap1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thor.javademo.spring.bean.Person;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:14
 * @Version: V1.0
 */
@Configuration
public class MainConfig {

    /**
     * 给容器中注册一个bean，类型为返回值的类型
     */
    @Bean
    public Person person() {
        return new Person("wangyq", 20);
    }
}
