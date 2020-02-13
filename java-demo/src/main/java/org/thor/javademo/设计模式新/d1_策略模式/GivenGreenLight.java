package org.thor.javademo.设计模式新.d1_策略模式;

/**
 * @Description:求吴国 开个绿灯
 * @Author: wangyiqiang
 * @Date: 2019-11-17 12:22
 * @Version: V1.0
 */
public class GivenGreenLight implements IStrategy {

    @Override
    public void operate() {
        System.out.println("求吴国 开个绿灯,放行!");
    }
}
