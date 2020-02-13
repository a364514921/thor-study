package org.thor.javademo.design_pattern.factory.abstract_factory;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.factory.abstract_factory
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 9:53
 * 系统版本：1.0.0
 **/

public class Test {
    public static void main(String[] args) {
        Factory factory;
        Gun gun;
        Bullet bullet;

        factory = new AK_Factory();

        bullet = factory.produceBullet();
        bullet.load();
        gun = factory.produceGun();
        gun.shooting();
    }
}