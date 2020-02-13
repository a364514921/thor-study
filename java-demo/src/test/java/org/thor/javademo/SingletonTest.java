package org.thor.javademo;

/**
 * 模块名称：StudyJava PACKAGE_NAME
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-08-19 下午5:52
 * 系统版本：1.0.0
 **/

public class SingletonTest {
    private static SingletonTest singletonTest;

    public SingletonTest() {
    }

    public static SingletonTest getInstance() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                if (singletonTest == null) {
                    if (singletonTest == null) {
                        singletonTest = new SingletonTest();
                    }
                }
            }
        }
        return singletonTest;
    }

}
