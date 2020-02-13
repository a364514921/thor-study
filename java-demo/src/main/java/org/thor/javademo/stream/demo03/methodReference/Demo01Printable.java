package org.thor.javademo.stream.demo03.methodReference;

/**
 * @Description: 方法引用
 * 双冒号::为引用运算符，而它所在的表达式被称为方法引用。如果Lambda要表达的函数方案已经存在于某个方法的实现中，那么则可以通过双冒号来引用该方法作为Lambda的替换者
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午7:54
 * @Version: V1.0
 */
public class Demo01Printable {
    public static void main(String[] args) {
        String str = "这是要打印的字符串";
        printString(str, val -> System.out.println(val));

        printString(str, System.out::println);

        /*
        分析：
         */
    }

    /**
     * 打印
     *
     * @param str
     */
    public static void printString(String str, Printable pri) {
        pri.print(str);
    }
}
