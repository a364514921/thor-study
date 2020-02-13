package org.thor.javademo.spring.ioc.cap12;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-29 上午10:57
 * @Version: V1.0
 */
@Component
public class JamesBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("My postProcessBeanFactory... ");
        // 所有bean已经加载到beanFactory,但是bean实例还未创建
        // 获取bean的数量
        int count = beanFactory.getBeanDefinitionCount();
        String[] names = beanFactory.getBeanDefinitionNames();
        System.out.println("bean的数量：[" + count + "]");
        System.out.println(Arrays.asList(names));
    }
}
