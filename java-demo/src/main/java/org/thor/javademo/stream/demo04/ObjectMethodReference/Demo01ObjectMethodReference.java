package org.thor.javademo.stream.demo04.ObjectMethodReference;

/**
 * @Description: 通过对应名引用成员方法
 * 使用前提是对象是已经存在的，成员方法也是已经存在
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午8:17
 * @Version: V1.0
 */
public class Demo01ObjectMethodReference {
    public static void main(String[] args) {
        printString((s)->{
            // 创建MethodRefObject对象
            MethodRefObject obj = new MethodRefObject();
            // 调用MethodRefObject对象中的成员方法
            obj.printUpperCaseString(s);
        });

        /*
        使用方法引用优化Lambda
         */
        MethodRefObject obj = new MethodRefObject();
    }

    public static void printString(Printable pri){
        pri.print("hello");
    }
}
