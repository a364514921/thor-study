package org.thor.javademo.design_pattern.factory.sample_factory;


import org.thor.javademo.design_pattern.factory.Shape;

/**
 * 利用反射解决简单工厂每次增加新了产品类都要修改产品工厂的弊端
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.factory.sample_factory
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 9:32
 * 系统版本：1.0.0
 **/

public class ShapeFactory2 {
    public static Object getClass(Class<? extends Shape> clazz) {
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }
}