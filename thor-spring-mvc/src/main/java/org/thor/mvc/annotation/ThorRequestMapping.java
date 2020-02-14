package org.thor.mvc.annotation;

import java.lang.annotation.*;

/**
 * @Description:自定义RequestMapping注解
 * @Author: wangyiqiang
 * @Date: 2020-01-31 上午11:34
 * @Version: V1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Inherited //注解可以被子类继承
public @interface ThorRequestMapping {

    String value() default "";

}
