package org.thor.javademo.demo;

/**
 * 模块名称：StudyJava com.wyq.studyjava.demo
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2017-08-19 上午8:25
 * 系统版本：1.0.0
 **/

public class EnumDemo {

    public static void main(String[] args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
        int index = FreshJuice.FreshJuiceSize.SMALL.ordinal();
        System.out.println(index);
    }
}

class FreshJuice {
    enum FreshJuiceSize {SMALL, MEDIUM, LARGE}

    FreshJuiceSize size;

}


