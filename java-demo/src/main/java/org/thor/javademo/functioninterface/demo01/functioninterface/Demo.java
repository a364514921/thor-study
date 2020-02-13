package org.thor.javademo.functioninterface.demo01.functioninterface;

/**
 * @Description:函数式接口的使用：一般可以作为方法的参数和返回值类型
 * @Author: wangyiqiang
 * @Date: 2020-02-04 上午11:31
 * @Version: V1.0
 */
public class Demo {

    public static void main(String[] args) {
        // 调用show()方法，方法的参数是一个接口，所以可以传递接口的一个实现类对象
        show(new MyFunctionalInterfaceImpl());

        // 调用show()方法，方法的参数是一个接口，所有可以传递接口的匿名内部类
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });

        // 调用show()方法，方法的参数是一个函数式接口，所有我们可以使用Lambda表达式
        show(() -> {
            System.out.println("使用Lambda表达式重写接口中的抽象方法");
        });

        // 简化Lambda表达式
        show(() -> System.out.println("使用简化Lambda表达式重写接口中的抽象方法"));
    }

    /**
     * 定义一个方法，参数使用函数式接口MyfunctionInterface
     * @param myInter
     */
    public static void show(MyFunctionalInterface myInter){
        myInter.method();
    }


}
