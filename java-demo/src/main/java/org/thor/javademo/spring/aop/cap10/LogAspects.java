package org.thor.javademo.spring.aop.cap10;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description:日志切面类
 * @Author: wangyiqiang
 * @Date: 2020-01-24 13:16
 * @Version: V1.0
 */
@Aspect
@Component
public class LogAspects {

    /**
     * 公共切入方法
     */
    @Pointcut("execution(public int com.wyq.studyjava.spring.aop.cap10.service.CalculateService.*(..))")
    public void pointCut() {
    }


    /**
     * 前置通知：logStart(),在目标方法运行之前运行 @Before
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "logStart... 参数列表是：{" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    /**
     * 后置通知：logEnd(),在目标方法运行之后运行 @After
     */
    @After("pointCut()")
    public void logEnd() {
        System.out.println("logEnd...");
    }

    /**
     * 返回通知：logReturn(),在目标方法正常返回之后运行 @AfterReturning
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println("logReturn... 正常返回... 结果是：{" + result + "}");
    }

    /**
     * 返回通知：logReturn(),在目标方法出现异常之后运行 @AfterThrowing
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println("logException...异常信息是：{" + exception + "}");
    }

    /**
     * 环绕通知：动态代理,手动执行目标方法运行 joinPoint.procced(),最底层通知，手动执行目标方法(@Around)，执行之前相当于前置通知，执行之后相当于后置通知
     */
    @Around("pointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("@Around: 执行目标方法之前...");

        // 通过反射手动执行方法
        Object obj = joinPoint.proceed();

        System.out.println("@Around: 执行目标方法之后...");
        return obj;
    }
}
