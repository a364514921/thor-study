package org.thor.javademo.设计模式新.d3_单例模式;

/**
 * @Description:大臣
 * @Author: wangyiqiang
 * @Date: 2019-11-17 13:43
 * @Version: V1.0
 */
public class Minister {
    /**
     * 三天见的皇帝都是同一个人
     * @param args
     */
    public static void main(String[] args) {
        // 第一天
        Emperor emperor1 = Emperor.getInstance();
        emperor1.emperorInfo();

        // 第二天
        Emperor emperor2 = Emperor.getInstance();
        emperor2.emperorInfo();

        // 第三天
        Emperor emperor3 = Emperor.getInstance();
        emperor3.emperorInfo();
    }
}
