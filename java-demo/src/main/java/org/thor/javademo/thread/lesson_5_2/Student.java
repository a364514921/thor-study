package org.thor.javademo.thread.lesson_5_2;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_5_2
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-19 下午8:40
 * 系统版本：1.0.0
 **/

public class Student implements Delayed {

    private String name;

    /**
     * 交卷时间
     */
    private long submitTime;

    /**
     * 考试时间
     */
    private long workTime;

    public Student(String name, long submitTime) {
        this.name = name;
        this.workTime = submitTime;
        this.submitTime = TimeUnit.NANOSECONDS.convert(submitTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //返回一个延迟时间
        return unit.convert(submitTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        //比较方法
        Student stu = (Student) o;
        return submitTime > stu.submitTime ? 1 : (submitTime < stu.submitTime ? -1 : 0);
    }

    public String getName() {
        return name + "交卷，用时：" + workTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(long submitTime) {
        this.submitTime = submitTime;
    }

    public long getWorkTime() {
        return workTime;
    }

    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }
}
