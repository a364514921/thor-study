package org.thor.javademo.functioninterface.demo02.lambda;

/**
 * @Description:日志案例
 * 发现一下代码存在一些性能浪费的问题
 * 调用showLog方法，传递的第二个参数是一个拼接后的字符串
 * 如果showLog方法中传递的日志级别不是1
 * 那么就不会使用凭借后的字符串，所以感觉白白拼接，存在资源浪费
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午12:09
 * @Version: V1.0
 */
public class Demo01Logger {

    public static void main(String[] args) {
        // 定义三个日志信息
        String msg1 = "Hello ";
        String msg2 = "World ";
        String msg3 = "Java";

        showLog(1, msg1 + msg2 + msg3);
    }

    /**
     * 定义一个根据日志级别，显示日志信息的方法
     * @param level
     * @param msg
     */
    public static void showLog(int level, String msg) {
        // 输出日志等级为1的日志信息
        if (level == 1) {
            System.out.println(msg);
        }
    }
}
