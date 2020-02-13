package org.thor.javademo.设计模式新.d3_单例模式;

/**
 * @Description:皇帝
 * @Author: wangyiqiang
 * @Date: 2019-11-17 13:40
 * @Version: V1.0
 */
public class Emperor {
    /**
     * 定义一个皇帝放在那里，然后给这个皇帝名字
     */
    private static Emperor emperor = null;

    /**
     * 世俗和道德约束你，目的就是不让你产生第二个皇帝
     * private 构造函数，目的是保证这个类不能被其他类new出来
     */
    private Emperor() {
    }

    /**
     * 获取皇帝实例
     *
     * @return
     */
    public static Emperor getInstance() {
        // 如果皇帝还没定义，那就定义一个
        if (emperor == null) {
            emperor = new Emperor();
        }
        return emperor;
    }

    /**
     * 皇帝叫什么名字呀
     */
    public void emperorInfo() {
        System.out.println("我就是皇帝某某某....");
    }
}
