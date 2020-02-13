package org.thor.javademo.spring.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 16:29
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
public class Bird {

    //    @Value("张三")
    @Value("${bird.name}")
    private String name;

    //    @Value("#{20-3}")
    @Value("${bird.age}")
    private String age;

    @Value("${bird.color}")
    private String color;

}
