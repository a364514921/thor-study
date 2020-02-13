package org.thor.javademo.spring.ioc.cap2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.thor.javademo.spring.bean.Person;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
// 扫描此目录下包
@ComponentScan(value = "org.thor.javademo.spring.ioc.cap2",
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {JamesTypeFilter.class})},
//        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})},
        useDefaultFilters = false
        )
public class Cap2MainConfig {

    @Bean
    public Person person01() {
        return new Person();
    }
}
