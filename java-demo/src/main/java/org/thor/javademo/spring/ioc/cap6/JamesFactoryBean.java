package org.thor.javademo.spring.ioc.cap6;

import org.springframework.beans.factory.FactoryBean;
import org.thor.javademo.spring.bean.Bird;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 16:26
 * @Version: V1.0
 */
public class JamesFactoryBean implements FactoryBean<Bird> {
    @Override
    public Bird getObject() throws Exception {
        return new Bird();
    }

    @Override
    public Class<?> getObjectType() {
        return Bird.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
