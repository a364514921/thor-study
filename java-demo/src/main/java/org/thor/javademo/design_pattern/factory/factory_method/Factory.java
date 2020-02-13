package org.thor.javademo.design_pattern.factory.factory_method;


import org.thor.javademo.design_pattern.factory.Shape;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.factory.factory_method
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 9:41
 * 系统版本：1.0.0
 **/

public interface Factory {
    public Shape getShape();
}