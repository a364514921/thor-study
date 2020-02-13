package org.thor.javademo.design_pattern.adapter;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.adapter
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 10:44
 * 系统版本：1.0.0
 **/

public class M5DataLine implements Target {
    @Override
    public void connection() {
        System.out.println("使用小米5数据线连接...");
    }
}