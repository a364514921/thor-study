package org.thor.javademo.design_pattern.adapter;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.adapter
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 10:50
 * 系统版本：1.0.0
 **/

public class M5DataLineAdapter2 implements Target {
    private Target target;

    public M5DataLineAdapter2(Target target) {
        this.target = target;
    }

    @Override
    public void connection() {
        System.out.println("插入 type-c 转接头");
        target.connection();
    }

}