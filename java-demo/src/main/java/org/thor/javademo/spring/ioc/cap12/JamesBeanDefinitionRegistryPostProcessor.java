package org.thor.javademo.spring.ioc.cap12;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
import org.thor.javademo.spring.bean.Tiger;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-29 上午11:53
 * @Version: V1.0
 */
@Component
public class JamesBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * BeanDefinitionRegistry Bean定义信息的保存中心，以后BeanFactory就是按照BeanDefinitionRegistry里面保存的bean定义信息创建bean实例
     * @param registry
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("My postProcessBeanDefinitionRegistry ...bean的数量：[" + registry.getBeanDefinitionCount() + "]");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Tiger.class);
        registry.registerBeanDefinition("tiger", rootBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("My postProcessBeanFactory ...bean的数量：[" + beanFactory.getSingletonCount() + "]");
    }
}
