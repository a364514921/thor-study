package org.thor.javademo.concurrent.cap1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.stream.Stream;

/**
 * @Description: 一个Main方法包含哪些线程
 * @Author: wangyiqiang
 * @Date: 2020-02-07 上午11:05
 * @Version: V1.0
 */
public class Demo1OnlyMain {
    /**
     * 打印结果：
     * [5] Monitor Ctrl-Break 负责获取当前运行线程系统属性的线程
     * [4] Signal Dispatcher 分发处理发送给虚拟机信号的线程
     * [3] Finalizer 调用对象finally方法的线程
     * [2] Reference Handler 负责清除引用的线程
     * [1] main 主线程（入口）
     * @param args
     */
    public static void main(String[] args) {
        // 虚拟机线程管理的接口
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        Stream.of (threadInfos).forEach(threadInfo -> {
            System.out.println("[" + threadInfo.getThreadId() + "]" + " " + threadInfo.getThreadName());
        });
    }
}
