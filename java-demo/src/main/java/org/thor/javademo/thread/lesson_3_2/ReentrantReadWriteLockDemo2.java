package org.thor.javademo.thread.lesson_3_2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_3_2
 * 功能说明：<br> 手动枷锁和解锁，都很适合高并发场景
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-18 下午1:31
 * 系统版本：1.0.0
 **/

public class ReentrantReadWriteLockDemo2 {
    public static void main(String[] args) {


    }

    //假设这里面存了数据缓存
    private final Map<String, Object> map = new HashMap<String, Object>();

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public Object readWrite(String id) {
        Object value = null;
        //首先开启读锁，从缓存中去取
        readWriteLock.readLock().lock();

        value = map.get(id);
        try {
            //如果缓存中没有数据，释放写锁
            if (value == null) {
                readWriteLock.readLock().unlock();
                readWriteLock.writeLock().lock();
                try {
                    if (value == null) {
                        //此时可以去数据库中查找,这里简单模拟一下
                        value = "aaa";
                    }

                }finally {
                    //释放写锁
                    readWriteLock.writeLock().unlock();
                }
            }

            //然后再上读锁
            readWriteLock.readLock().lock();
        }finally {
            //最后释放读锁
            readWriteLock.readLock().unlock();
        }
        return value;

    }


}
