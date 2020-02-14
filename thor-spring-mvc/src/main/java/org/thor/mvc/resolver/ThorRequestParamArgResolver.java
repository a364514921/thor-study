package org.thor.mvc.resolver;

import org.thor.mvc.annotation.ThorRequestParam;
import org.thor.mvc.annotation.ThorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @Description: 解析声明注解为RequestParam, 获取注解的值
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午6:52
 * @Version: V1.0
 */
@ThorService("ThorRequestParamArgResolver")
public class ThorRequestParamArgResolver implements ArgumentResolver {
    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation[] paramAnnotations = parameterAnnotations[paramIndex];
        for (Annotation paramAnnotation : paramAnnotations) {
            // 判断传进来的参数是不是ThorRequestParam类型
            if (ThorRequestParam.class.isAssignableFrom(paramAnnotation.getClass())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Annotation[] paramAnnotations = parameterAnnotations[paramIndex];
        for (Annotation paramAnnotation : paramAnnotations) {
            // 判断传进来的参数是不是ThorRequestParam类型
            if (ThorRequestParam.class.isAssignableFrom(paramAnnotation.getClass())) {
                ThorRequestParam requestParam = (ThorRequestParam) paramAnnotation;
                String value = requestParam.value();
                return request.getParameter(value);
            }
        }
        return null;
    }
}
