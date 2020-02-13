package org.thor.javademo.spring.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 17:44
 * @Version: V1.0
 */
public class Jeep {
    public Jeep() {
        System.out.println("jeep... construct...");
    }

    @PostConstruct
    public void init() {
        System.out.println("jeep... init...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jeep... destroy...");
    }
}
