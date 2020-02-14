package org.thor.mvc.annotation;

import java.lang.annotation.*;

/**
 * @Description:自定义Service注解
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午3:23
 * @Version: V1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThorService {
    String value() default "";
}
