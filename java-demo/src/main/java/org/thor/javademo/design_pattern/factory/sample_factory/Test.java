package org.thor.javademo.design_pattern.factory.sample_factory;


import org.thor.javademo.design_pattern.factory.Shape;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.factory
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 9:28
 * 系统版本：1.0.0
 **/

public class Test {
    public static void main(String[] args) {

        // 获取 Circle 的对象，并调用它的 draw 方法
        Shape circle = ShapeFactory.getShape("CIRCLE");
        circle.draw();

        // 获取 Rectangle 的对象，并调用它的 draw 方法
        Shape rectangle = ShapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        // 获取 Square 的对象，并调用它的 draw 方法
        Shape square = ShapeFactory.getShape("SQUARE");
        square.draw();
    }

}