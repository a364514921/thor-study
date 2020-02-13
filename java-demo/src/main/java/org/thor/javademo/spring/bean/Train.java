package org.thor.javademo.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 17:41
 * @Version: V1.0
 */
public class Train implements InitializingBean, DisposableBean {

    public Train() {
        System.out.println("train... construct...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("train... destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("train... afterPropertiesSet");
    }
}
