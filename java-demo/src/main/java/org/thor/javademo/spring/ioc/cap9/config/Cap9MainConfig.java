package org.thor.javademo.spring.ioc.cap9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thor.javademo.spring.bean.Plane;
import org.thor.javademo.spring.ioc.cap9.TestDao;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
@ComponentScan(value = {"org.thor.javademo.spring.ioc.cap9", "org.thor.javademo.spring.bean"})
public class Cap9MainConfig {

    // @Primary
    @Bean("testDao2")
    public TestDao testDao() {
        TestDao testDao = new TestDao();
        testDao.setFlag("2");
        return testDao;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Plane plane() {
        System.out.println("Plane...");
        return new Plane();
    }
}
