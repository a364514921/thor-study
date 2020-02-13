package org.thor.javademo.spring.ioc.cap8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.thor.javademo.spring.bean.Bird;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
//@PropertySource(value = {"classpath:/test.yml"})
@PropertySource(value = {"classpath:/test.properties"})
public class Cap8MainConfig {

    @Primary
    @Bean
    public Bird bird() {
        System.out.println("bird...");
        return new Bird();
    }

}
