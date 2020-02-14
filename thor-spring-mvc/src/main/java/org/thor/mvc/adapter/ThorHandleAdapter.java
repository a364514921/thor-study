package org.thor.mvc.adapter;


import org.thor.mvc.annotation.ThorService;
import org.thor.mvc.resolver.ArgumentResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:处理器实现类
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午6:35
 * @Version: V1.0
 */
@ThorService("thorHandleAdapter")
public class ThorHandleAdapter implements HandleAdapterService {

    @Override
    public Object[] handle(HttpServletRequest request, HttpServletResponse response, Method method, Map<String, Object> beanMap) {
        // 获取当前待执行的方法有哪些参数
        Class<?>[] paramClasses = method.getParameterTypes();
        //根据参数的个数,new 一个参数的数组,将方法里的所有参数赋值到args来
        Object[] args = new Object[paramClasses.length];

        //1、要拿到所有实现了ArgumentResolver这个接口的实现类
        Map<String, Object> argumentResolvers = this.getBeansOfType(beanMap, ArgumentResolver.class);

        int paramIndex = 0;
        int i = 0;
        //对每一个参数进行循环,每个参数都有特殊处理(比如RequestParam的处理类为 RequestParamArgumentResolver )
        for (Class<?> paramClazz : paramClasses) {
            //哪个参数对应了哪个参数解析类,用策略模式来找
            for (Map.Entry<String, Object> entry : argumentResolvers.entrySet()) {
                ArgumentResolver resolver = (ArgumentResolver) entry.getValue();

                if (resolver.support(paramClazz, paramIndex, method)) {
                    args[i++] = resolver.argumentResolver(request, response, paramClazz, paramIndex, method);
                }
            }
            paramIndex++;
        }

        return args;
    }

    /**
     * 获取实现了ArgumentResolver接口的所有实例(其实就是每个参数的注解实例)
     *
     * @param beans         所有bea
     * @param interfaceType 接口类型
     * @return
     */
    private Map<String, Object> getBeansOfType(Map<String, Object> beans, Class<?> interfaceType) {
        Map<String, Object> resultBeans = new HashMap<String, Object>();

        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            //拿到实例-->反射对象-->它的接口(接口有多实现,所以为数组)
            Class<?>[] interfaces = entry.getValue().getClass().getInterfaces();

            if (interfaces != null && interfaces.length > 0) {
                for (Class<?> interfaceInfo : interfaces) {
                    //接口的类型与传入进来的类型一样,把实例加到resultBeans里来
                    if (interfaceInfo.isAssignableFrom(interfaceType)) {
                        resultBeans.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        return resultBeans;
    }
}
