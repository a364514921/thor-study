package org.thor.mvc.annotation;

import java.lang.annotation.*;

/**
 * @Description:自定义依赖注入注解（仿@Autowired）
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午3:23
 * @Version: V1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThorAutowired {
    String value() default "";
}
