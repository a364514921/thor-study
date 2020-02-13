package org.thor.javademo.spring.aop.cap10.service;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 13:12
 * @Version: V1.0
 */
//@Service
public class CalculateService {

    public int div(int i, int j) {
        System.out.println("CalculateService... div...");
        return i / j;
    }
}
