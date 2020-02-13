package org.thor.javademo;

import cn.hutool.core.convert.Convert;

/**
 * 模块名称：StudyJava PACKAGE_NAME
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-01-30 13:06
 * 系统版本：1.0.0
 **/

public class MainTest {
    public static void main(String[] args) {
//        Father father = new Father();
//        father.setUserId(1000);
//        father.setAge((short) 50);
//        father.setUsername("大头");
//        System.out.println(JSON.toJSONString(father));
//
//        Son son = new Son();
//        son.setUserId(1001);
//        son.setAge((short) 25);
//        son.setUsername("xiaoming");
//        System.out.println(JSON.toJSONString(son));
        double a = 22222267556.005;

        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
        String digitUppercase = Convert.digitToChinese(a);
        System.out.println(digitUppercase);

        System.out.println(Convert.numberToChinese(a,true));
        System.out.println(Convert.numberToChinese(a,false));
        System.out.println(Convert.numberToWord(a));
    }
}