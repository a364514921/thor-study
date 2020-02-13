package org.thor.javademo.design_pattern.ptototype;

import java.util.HashMap;

/**
 * Manager类使用Product接口来复制实例。
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.ptototype
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 10:11
 * 系统版本：1.0.0
 **/

public class Manager {

    /**
     * 保存实例的“名字”和“实例”之间的对应关系
     */
    private HashMap<String, Product> showcase = new HashMap<String, Product>();

    /**
     * register方法将接收到的一组“名字”和“Product接口”注册到showcase中。这里Product是实现Product接口的实例，具体还未确定
     *
     * @param name
     * @param product
     */
    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String productname) {
        Product p = showcase.get(productname);
        return p.createClone();
    }

}