package org.thor.javademo.设计模式新.d2_代理模式;

/**
 * @Description:王婆这个人老聪明了，她 老了，是个男人都看不上，但是她有智慧有经验呀，她作为一类女人的代理!
 * @Author: wangyiqiang
 * @Date: 2019-11-17 13:13
 * @Version: V1.0
 */
public class WangPo implements KindWomen {
    private KindWomen kindWomen;

    /**
     * 默认的话，是潘金莲的代理
     */
    public WangPo() {
        this.kindWomen = new PanJinLian();
    }

    /**
     * 她可以是KindWomen的任何一个女人的代理，只要你是这一类型
     *
     * @param kindWomen
     */
    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    @Override
    public void makeEyesWithMan() {
        kindWomen.makeEyesWithMan();
    }

    @Override
    public void happyWithMan() {
        kindWomen.happyWithMan();
    }
}
