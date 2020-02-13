package org.thor.javademo.spring.ioc.cap7.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thor.javademo.spring.bean.Bike;
import org.thor.javademo.spring.bean.Jeep;
import org.thor.javademo.spring.bean.Plane;
import org.thor.javademo.spring.bean.Train;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
@ComponentScan(value = "org.thor.javademo.spring.ioc.cap7")
public class Cap7MainConfig {

//    @Scope("prototype")
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Bike bike() {
        System.out.println("bike...");
        return new Bike();
    }

    @Bean
    public Train train() {
        System.out.println("train...");
        return new Train();
    }

    @Bean
    public Jeep jeep() {
        System.out.println("jeep...");
        return new Jeep();
    }

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Plane plane() {
        System.out.println("Plane...");
        return new Plane();
    }
}
