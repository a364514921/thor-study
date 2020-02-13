package org.thor.javademo.design_pattern.builder;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.builder
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 9:02
 * 系统版本：1.0.0
 **/

public class MainTest {
    public static void main(String[] args) {
        // 套餐A
        MealA a = new MealA();
        // 准备套餐A的服务员
        KFCWaiter waiter = new KFCWaiter(a);
        // 获得套餐
        Meal mealA = waiter.construct();

        System.out.print("套餐A的组成部分:");
        System.out.println("食物："+mealA.getFood()+"；   "+"饮品："+mealA.getDrink());

        // 套餐A
        MealB b = new MealB();
        // 准备套餐A的服务员
        KFCWaiter waiterB = new KFCWaiter(b);
        // 获得套餐
        Meal mealB = waiterB.construct();

        System.out.print("套餐B的组成部分:");
        System.out.println("食物："+mealB.getFood()+"；   "+"饮品："+mealB.getDrink());

    }
}