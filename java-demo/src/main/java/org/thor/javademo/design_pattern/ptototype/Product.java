package org.thor.javademo.design_pattern.ptototype;

/**
 * Product接口是复制功能接口，该接口继承了java.lang.Cloneable(只有实现了该接口的类的实例才可以调用clone()方法复制实例,否则会抛出异常).
 * 另外需要注意：`java.lang.Cloneable 只是起到告诉程序可以调用clone方法的作用，它本身并没有定义任何方法。
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.ptototype
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 10:10
 * 系统版本：1.0.0
 **/
public interface Product extends Cloneable {
    /**
     * use方法是用于“使用”的方法，具体怎么“使用”，则被交给子类去实现。
     * @param s
     */
    public abstract void use(String s);

    /**
     * creatClone方法是用于复制实例的方法
     * @return
     */
    public abstract Product createClone();
}
