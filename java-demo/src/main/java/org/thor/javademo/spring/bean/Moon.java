package org.thor.javademo.spring.bean;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 12:14
 * @Version: V1.0
 */
@Component
public class Moon {

    public Moon() {
        System.out.println("Moon construct...");
    }

    public void init() {
        System.out.println("Moon init...");
    }

    public void destroy() {
        System.out.println("Moon destroy...");
    }
}
