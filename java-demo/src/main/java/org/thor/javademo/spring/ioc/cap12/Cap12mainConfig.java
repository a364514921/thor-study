package org.thor.javademo.spring.ioc.cap12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thor.javademo.spring.bean.Train;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-29 上午10:54
 * @Version: V1.0
 */
@Configuration
@ComponentScan("org.thor.javademo.spring.ioc.cap12")
public class Cap12mainConfig {

    @Bean
    public Train train() {
        return new Train();
    }
}
