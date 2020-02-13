package org.thor.javademo.annotation;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-05 下午6:23
 * @Version: V1.0
 */
@Pro(className = "com.wyq.studyjava.annotation.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws  Exception {
        //1.解析注解
        //1.1获取该类的字节码对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //2.获取上边的注解对象
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        // 其实就是在内存中生成了一个该注解接口的子类实现对象
  /*
            public class ProImpl implements Pro{
                public String className(){
                    return "cn.itcast.annotation.Demo1";
                }
                public String methodName(){
                    return "show";
                }
            }
 */

        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();

        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }
}
