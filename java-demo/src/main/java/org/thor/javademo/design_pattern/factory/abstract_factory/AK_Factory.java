package org.thor.javademo.design_pattern.factory.abstract_factory;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.factory.abstract_factory
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 9:51
 * 系统版本：1.0.0
 **/

public class AK_Factory implements Factory {
    @Override
    public Gun produceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AK_Bullet();
    }
}