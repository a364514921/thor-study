package org.thor.javademo.thread.lesson_5_2;

import java.util.concurrent.DelayQueue;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_5_2
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-19 下午8:51
 * 系统版本：1.0.0
 **/

public class DelayQueueTest {
    public static void main(String[] args) {
        final DelayQueue<Student> bq = new DelayQueue<>();

        for (int i = 0; i < 5; i++) {
            Student student = new Student("学生" + i , Math.round((Math.random() * 10 + i)));
            //将数据存储到队列
            bq.put(student);
        }

        //获取但不移除此队列的头部例如过此队列为空，则返回null
        System.out.println("bq.peek()" + bq.peek().getName());

    }
}
