package org.thor.javademo.design_pattern.builder;

/**
 * 产品角色
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.builder
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 8:54
 * 系统版本：1.0.0
 **/

public class Meal {
    private String food;
    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
}