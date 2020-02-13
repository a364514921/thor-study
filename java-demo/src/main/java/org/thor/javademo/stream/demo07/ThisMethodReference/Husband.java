package org.thor.javademo.stream.demo07.ThisMethodReference;

/**
 * @Description: 丈夫类:通过this引用本类的成员方法
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午9:08
 * @Version: V1.0
 */
public class Husband {
    public void buyHouse() {
        System.out.println("北京二环内买一套四合院");
    }

    public void merry(Richable rich){
        rich.buy();
    }

    public void happy() {
        merry(()->{
            this.buyHouse();
        });

        merry(this::buyHouse);
    }
}
