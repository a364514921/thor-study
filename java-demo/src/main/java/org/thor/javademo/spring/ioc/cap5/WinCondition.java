package org.thor.javademo.spring.ioc.cap5;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-01-23 15:41
 * @Version: V1.0
 */
public class WinCondition implements Condition {

    /**
     * @param context  判断条件 - 能使用的上下文（环境）
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        return false;
    }
}
