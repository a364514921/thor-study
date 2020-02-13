package org.thor.javademo.设计模式新.d4_多例模式;

/**
 * @Description:大臣 臣们悲惨了，一个皇帝都伺候不过来了，现在还来了两个个皇帝
 * TND，不管了，找到个皇帝，磕头，请按就成了!
 * @Author: wangyiqiang
 * @Date: 2019-11-17 14:09
 * @Version: V1.0
 */
public class Minister {
    public static void main(String[] args) {
        //10个大臣
        int ministerNum = 10;
        for (int i = 0; i < ministerNum; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("第" + (i + 1) + "个大臣参拜的是:");
            emperor.emperorInfo();
        }
    }
}
