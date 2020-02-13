package org.thor.javademo.annotation;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-05 下午5:30
 * @Version: V1.0
 */
@MyAnno("12")
@MyAnno3
public class Worker {

    @MyAnno3
    public String name = "aaa";

    @MyAnno3
    public void show() {

    }
}
