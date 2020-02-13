package org.thor.javademo.design_pattern.observable;

import java.util.ArrayList;
import java.util.List;

/**
 * 战队控制中心类：目标类
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.observable
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-19 17:06
 * 系统版本：1.0.0
 **/

public abstract class AllyControlCenter {
    /**
     * 战队名称
     */
    protected String allyName;

    /**
     * 定义一个集合用于存储战队成员
     */
    protected List<Observer> players = new ArrayList<>();


    /**
     * 注册方法
     *
     * @param obs
     */
    public void join(Observer obs) {
        System.out.println(obs.getName() + "加入" + this.allyName + "战队！");
        players.add(obs);
    }

    /**
     * 注销方法
     * @param obs
     */
    public void quit(Observer obs) {
        System.out.println(obs.getName() + "退出" + this.allyName + "战队！");
        players.remove(obs);
    }

    /**
     * 声明抽象通知方法
     * @param name
     */
    public abstract void notifyObserver(String name);

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }
}