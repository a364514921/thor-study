package org.thor.mvc.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Description:参数解析接口
 * @Author: wangyiqiang
 * @Date: 2020-01-31 下午6:40
 * @Version: V1.0
 */
public interface ArgumentResolver {

    /**
     * 判断参数类型是否符合
     *
     * @param type       类 - 类型
     * @param paramIndex 参数索引
     * @param method     方法
     * @return
     */
    public boolean support(Class<?> type, int paramIndex, Method method);

    /**
     * 参数解析
     *
     * @param request    HttpServletRequest
     * @param response   HttpServletResponse
     * @param type       类 - 类型
     * @param paramIndex 参数索引下坐标,有很多注解,你得知道是哪个参数的注解,每个参数的索引顺序不一样
     * @param method     方法
     * @return 解析的参数对象
     */
    public Object argumentResolver(HttpServletRequest request, HttpServletResponse response, Class<?> type, int paramIndex, Method method);
}
