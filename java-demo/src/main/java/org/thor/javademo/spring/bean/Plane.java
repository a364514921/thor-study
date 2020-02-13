package org.thor.javademo.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-24 08:58
 * @Version: V1.0
 */
public class Plane implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        /*
         * 容器初始化，将applicationContext传进来，那么其它方法九可以使用到IOC容器了
         * 这个功能是ApplicationContextAwareProcessor做的
         * */
        this.applicationContext = applicationContext;
    }

    public Plane() {
        System.out.println("plane... construct...");
    }

    /**
     * 对象创建并父子后调用
     */
    @PostConstruct
    public void init() {
        System.out.println("plane... PostConstruct...");
    }

    /**
     * 容器移除对象之前回调通知，销毁bean
     */
    @PreDestroy
    public void destroy() {
        System.out.println("plane... PreDestroy...");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("plane... 当前bean的名字：" + name);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        // 用来解析String的值
        String result = resolver.resolveStringValue("您好！${os.name}, 计算#{10+15}");
        System.out.println("解析的字符串----" + result);
    }
}
