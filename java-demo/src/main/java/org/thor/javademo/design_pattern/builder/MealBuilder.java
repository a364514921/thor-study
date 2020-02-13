package org.thor.javademo.design_pattern.builder;

/**
 * 抽象建造者
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.builder
 * 功能说明：<br>创建一个Product对象的各个部件指定的抽象接口。
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 8:53
 * 系统版本：1.0.0
 **/

public abstract class MealBuilder {
    Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}