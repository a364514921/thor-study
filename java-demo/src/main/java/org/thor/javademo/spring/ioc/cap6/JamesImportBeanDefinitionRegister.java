package org.thor.javademo.spring.ioc.cap6;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.thor.javademo.spring.bean.Pig;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 16:16
 * @Version: V1.0
 */
public class JamesImportBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {

    /**
     * 调用注册方法手动把需要的注解添加到容器中
     *
     * @param importingClassMetadata 当前注解的信息
     * @param registry 注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean condition1 = registry.containsBeanDefinition("com.wyq.studyjava.spring.ioc.entity.Dog");
        boolean condition2 = registry.containsBeanDefinition("com.wyq.studyjava.spring.ioc.entity.Cat");

        // 是否存在dog和cat组件，存在：添加pig组件
        if (condition1 && condition2) {
            System.out.println("cat和dog同时存在...");

            // 指定bean的定义信息(类型、scope)
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            // 注册一个bean，名为pig
            registry.registerBeanDefinition("pig", beanDefinition);
        }
    }
}
