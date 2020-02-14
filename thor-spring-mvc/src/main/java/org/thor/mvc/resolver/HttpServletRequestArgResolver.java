package org.thor.mvc.resolver;


import org.thor.mvc.annotation.ThorService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description:HttpServletRequest类型参数解析器
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午6:47
 * @Version: V1.0
 */
@ThorService("httpServletRequestArgResolver")
public class HttpServletRequestArgResolver implements ArgumentResolver{
    @Override
    public boolean support(Class<?> type, int paramIndex, Method method) {
        return ServletRequest.class.isAssignableFrom(type);
    }

    @Override
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method) {
        return request;
    }
}
