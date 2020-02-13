package org.thor.javademo.design_pattern.adapter;

/**
 * .创建适配器类，继承了被适配类，同时实现标准接口
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.adapter
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 10:45
 * 系统版本：1.0.0
 **/

public class M5DataLineAdapter extends M4DataLine implements  Target{

    @Override
    public void connection() {
        System.out.println("插入 type-c 转接头");
        super.connection();
    }
}