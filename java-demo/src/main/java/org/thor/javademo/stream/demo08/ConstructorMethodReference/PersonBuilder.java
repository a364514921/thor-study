package org.thor.javademo.stream.demo08.ConstructorMethodReference;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午9:14
 * @Version: V1.0
 */
@FunctionalInterface
public interface PersonBuilder {
    /**
     * 根据传递的姓名，创建Person对象
     * @param name
     */
    Person build(String name);
}
