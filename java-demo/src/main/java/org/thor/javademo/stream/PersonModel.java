package org.thor.javademo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2019-11-21 15:48
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonModel {
    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;
}
