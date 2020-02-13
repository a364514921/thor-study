package org.thor.javademo.设计模式新.d2_代理模式;

/**
 * @Description:潘金莲这类女人
 * @Author: wangyiqiang
 * @Date: 2019-11-17 13:12
 * @Version: V1.0
 */
public class PanJinLian implements KindWomen {
    @Override
    public void makeEyesWithMan() {
        System.out.println("潘金莲抛媚眼");
    }

    @Override
    public void happyWithMan() {
        System.out.println("潘金莲在和男人做那个.....");
    }
}
