package org.thor.javademo.design_pattern.observable;

/**
 * 抽象观察类
 */
public interface Observer {
    public String getName();

    public void setName(String name);

    /**
     * 什么支援盟友方法
     */
    public void help();

    /**
     * 什么遭受攻击的方法
     */
    public void beAttacked(AllyControlCenter acc);
}