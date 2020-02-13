package org.thor.javademo.设计模式新.d2_代理模式;

/**
 * @Description:卢俊义的老婆贾氏
 * @Author: wangyiqiang
 * @Date: 2019-11-17 13:19
 * @Version: V1.0
 */
public class JiaShi implements KindWomen {
    @Override
    public void makeEyesWithMan() {
        System.out.println("贾氏抛媚眼");
    }

    @Override
    public void happyWithMan() {
        System.out.println("贾氏正在Happy中......");
    }
}
