package org.thor.javademo.functioninterface.demo02.lambda;

/**
 * @Description:使用Lambda优化日志案例 Lambda特点；延迟加载
 * Lambda使用前提：必须存在函数式接口
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午12:16
 * @Version: V1.0
 */
public class Demo02Lambda {

    public static void main(String[] args) {
        // 定义三个日志信息
        String msg1 = "Hello ";
        String msg2 = "World ";
        String msg3 = "Java";

        showLog(1, () -> {
            // 返回拼接好的字符串
            return msg1 + msg2 + msg3;
        });

        /*
         * 总结：使用Lambda表达式作为参数传递，仅仅是把参数传递到showLog方法中
         * 只有满足条件，日志等级是1级
         * 才会调用接口MessageBuilder中国年的方法buildMsg
         * 所以使用Lambda表达式不会存在性能浪费
         */
    }

    /**
     * 显示日志
     *
     * @param level 日志等级
     * @param mb    MessageBuilder函数式接口
     */
    public static void showLog(int level, MessageBuilder mb) {
        // 对日志进行判断，如果是1级，则调用MessageBuilder接口中的buildMsg方法
        if (level == 1) {
            System.out.println(mb.buildMsg());
        }
    }
}
