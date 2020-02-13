package org.thor.javademo.design_pattern.builder;

/**
 * Director（指挥者）
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.builder
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 9:00
 * 系统版本：1.0.0
 **/

public class KFCWaiter {
    private MealBuilder mealBuilder;

    public KFCWaiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        //准备食物
        mealBuilder.buildFood();
        //准备饮料
        mealBuilder.buildDrink();

        //准备完毕，返回一个完整的套餐给客户
        return mealBuilder.getMeal();
    }
}