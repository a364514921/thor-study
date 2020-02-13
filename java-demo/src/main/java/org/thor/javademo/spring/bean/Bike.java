package org.thor.javademo.spring.bean;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 17:27
 * @Version: V1.0
 */
public class Bike {

    public Bike() {
        System.out.println("bike... construct...");
    }

    /**
     * 初始化
     */
    public void init() {
        System.out.println("bike... init...");
    }

    /**
     * 销毁
     */
    public void destroy() {
        System.out.println("bike... destroy...");
    }
}
