package org.thor.javademo.spring.ioc.cap5;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 15:41
 * @Version: V1.0
 */
public class MacCondition implements Condition {

    /**
     * @param context  判断条件 - 能使用的上下文（环境）
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1.能获取到IOC使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();

        // 3.获取当前环境信息
        Environment environment = context.getEnvironment();

        // 4.获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String osName = environment.getProperty("os.name");
        System.out.println("osName: " + osName);
        if (osName.contains("Mac")) {
            return true;
        }
        return false;
    }
}
