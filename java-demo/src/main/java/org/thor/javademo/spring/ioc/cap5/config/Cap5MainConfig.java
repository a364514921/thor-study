package org.thor.javademo.spring.ioc.cap5.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.thor.javademo.spring.bean.Person;
import org.thor.javademo.spring.ioc.cap5.MacCondition;
import org.thor.javademo.spring.ioc.cap5.WinCondition;

/**
 * @Description:ComponentScan扫描规则
 * @Author: wangyiqiang
 * @Date: 2020-01-23 14:21
 * @Version: V1.0
 */
@Configuration
public class Cap5MainConfig {

    @Bean
    public Person person() {
        System.out.println("给容器中添加person...");
        return new Person("wangyq", 18);
    }

    @Conditional({WinCondition.class})
    @Bean
    public Person bob() {
        System.out.println("给容器中添加bob...");
        return new Person("bob", 33);
    }

    @Conditional({MacCondition.class})
    @Bean
    public Person james() {
        System.out.println("给容器中添加james...");
        return new Person("james", 13);
    }
}
