package org.thor.javademo.spring.aop.cap10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.thor.javademo.spring.aop.cap10.service.CalculateService;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 13:03
 * @Version: V1.0
 */
@Configuration
@ComponentScan("org.thor.javademo.spring.aop.cap10")
@EnableAspectJAutoProxy
public class Cap10MainConfigOfAop {

    @Bean
    public CalculateService calculateService() {
        return new CalculateService();
    }
//
//    @Bean
//    public LogAspects logAspects() {
//        return new LogAspects();
//    }
}
