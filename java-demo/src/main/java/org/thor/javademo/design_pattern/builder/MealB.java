package org.thor.javademo.design_pattern.builder;

/**
 * 具体建造者B
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.builder
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 8:55
 * 系统版本：1.0.0
 **/

public class MealB extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("汉堡");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("果汁");
    }
}