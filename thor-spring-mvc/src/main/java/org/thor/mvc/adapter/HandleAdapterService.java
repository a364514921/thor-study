package org.thor.mvc.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Description:处理器映射适配器
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午6:31
 * @Version: V1.0
 */
public interface HandleAdapterService {

    /**
     * 对method方法里的参数进行处理
     *
     * @param request  request
     * @param response response
     * @param method   方法
     * @param beanMap  bean容器
     * @return
     */
    public Object[] handle(HttpServletRequest request, HttpServletResponse response, Method method, Map<String, Object> beanMap);


}
