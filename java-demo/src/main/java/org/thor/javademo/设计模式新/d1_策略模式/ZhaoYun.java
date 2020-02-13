package org.thor.javademo.设计模式新.d1_策略模式;

/**
 * @Description:策划的调用者 策略模式的好处就是:体现了高内聚低耦合的特性
 * 就这三招，搞的周郎是“陪了 人又折兵”呀!这就是策略模式，高内聚低耦合的特点也表现出来了，
 * 还有一个就是扩展性，也就是 OCP 原则，
 * 策略类可以继续增加下去，只要修改 Context.java 就可以了，这 个不多说了，自己领会吧。
 * @Author: wangyiqiang
 * @Date: 2019-11-17 12:26
 * @Version: V1.0
 */
public class ZhaoYun {
    /**
     * 赵云出场了，他根据诸葛亮给他的交代，依次拆开妙计
     */
    public static void main(String[] args) {
        Context context;
        // 刚刚到吴国的时候拆第一个
        System.out.println("-----------刚刚到吴国的时候拆第一个-------------");
        context = new Context(new BackDoor()); //拿到妙计
        context.operate(); //拆开执行
        System.out.println("\n\n\n\n\n\n\n\n");

        // 刘备乐不思蜀了，拆第二个了
        System.out.println("-----------刘备乐不思蜀了，拆第二个了-------------");
        context = new Context(new GivenGreenLight());
        context.operate(); //执行了第二个锦囊了
        System.out.println("\n\n\n\n\n\n\n\n");

        // 孙权的小兵追了，咋办?拆第三个
        System.out.println("-----------孙权的小兵追了，咋办?拆第三个 -------------");
        context = new Context(new BlockEnemy());
        context.operate(); //孙夫人退兵
        System.out.println("\n\n\n\n\n\n\n\n");

    }
}
