package org.thor.javademo.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-11 16:58
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Scope
public class Person {

    private String name;

    private Integer age;

}
