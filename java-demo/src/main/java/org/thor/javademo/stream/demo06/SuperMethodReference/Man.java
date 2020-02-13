package org.thor.javademo.stream.demo06.SuperMethodReference;

/**
 * @Description: 男人
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午8:52
 * @Version: V1.0
 */
public class Man extends Human {
    @Override
    public void sayHello() {
        System.out.println("Hello! 我是Man");
    }

    public void method(Greetable greetable) {
        greetable.greet();
    }

    public void show() {
        // 使用lambda表达式
        method(() -> {
            Human human = new Human();
            // 调用父类Human对象
            human.sayHello();
        });

        // 优化后的lambda表达式
        method(() -> {
            super.sayHello();
        });

        // 使用方法引用优化
        method(super::sayHello);

        // 使用方法引用优化
        method(this::sayHello);
    }
}
