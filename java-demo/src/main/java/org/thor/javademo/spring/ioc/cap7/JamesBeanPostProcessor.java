package org.thor.javademo.spring.ioc.cap7;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description: 后置处理器：初始化前后进行处理工作
 * @Author: wangyiqiang
 * @Date: 2020-01-23 17:49
 * @Version: V1.0
 */
@Component
public class JamesBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("postProcessBeforeInitialization... " + beanName + "--->" + bean);
        // 返回传过来的对象，也可包装好再返回
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization... " + beanName + "--->" + bean);
        // 返回传过来的对象，也可包装好再返回
        return bean;
    }
}
