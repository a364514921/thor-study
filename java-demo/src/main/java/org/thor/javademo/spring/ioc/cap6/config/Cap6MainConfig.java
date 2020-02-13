package org.thor.javademo.spring.ioc.cap6.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.thor.javademo.spring.bean.Cat;
import org.thor.javademo.spring.bean.Dog;
import org.thor.javademo.spring.bean.Person;
import org.thor.javademo.spring.ioc.cap6.JamesFactoryBean;
import org.thor.javademo.spring.ioc.cap6.JamesImportBeanDefinitionRegister;
import org.thor.javademo.spring.ioc.cap6.JamesImportSelector;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
// 导入组件，ID默认是组件的全类名
@Import({Dog.class, Cat.class, JamesImportSelector.class, JamesImportBeanDefinitionRegister.class})
public class Cap6MainConfig {

    @Bean
    public Person person() {
        System.out.println("给容器中添加person...");
        return new Person("wangyq", 18);
    }

    @Bean
    public JamesFactoryBean jamesFactoryBean() {
        return new JamesFactoryBean();
    }

}
