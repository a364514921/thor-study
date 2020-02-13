package org.thor.javademo.annotation;

import java.lang.annotation.*;

/**
 * @Description: 描述需要去执行的类名和方法名
 * @Author: wangyiqiang
 * @Date: 2020-02-05 下午6:24
 * @Version: V1.0
 */
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {

    String className();

    String methodName();

}
