package org.thor.javademo.设计模式新.d4_多例模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:中国的历史上一般都是一个朝代一个皇帝，有两个皇帝的话，必然要PK出一个皇帝出来。 问题出来了:如果真在一个时间，中国出现了两个皇帝怎么办?比如明朝土木堡之变后，
 * 明英宗被俘虏，明景帝即位，但是明景帝当上皇帝后乐疯了，竟然忘记把他老哥明英宗削为 上皇，
 * 也就是在这一个多月的时间内，中国竟然有两个皇帝!
 * @Author: wangyiqiang
 * @Date: 2019-11-17 14:02
 * @Version: V1.0
 */
public class Emperor {

    /**
     * 最多只能有几个皇帝
     */
    private static int maxNumOfEmperor = 2;

    /**
     * 装皇帝的列表
     */
    private static List<Emperor> emperorList = new ArrayList<>(maxNumOfEmperor);

    /**
     * 皇帝叫什么名字
     */
    private static ArrayList emperorInfoList=new ArrayList(maxNumOfEmperor);

    /**
     * 正在被人尊称的是哪个皇帝
     */
    private static int countNumOfEmperor = 0;


    /**
     * 先把2个皇帝产生出来
     */
    static {
        for (int i = 0; i < maxNumOfEmperor; i++) {
            emperorList.add(new Emperor("皇" + (i + 1) + "帝"));
        }
    }

    /**
     * 就这么多皇帝了，不允许再推举一个皇帝(new 一个皇帝)
     */
    private Emperor() {
        //世俗和道德约束你，目的就是不让你产生第二个皇帝
    }


    private Emperor(String info) {
        emperorInfoList.add(info);
    }


    /**
     * //随机拉出一个皇帝，只要是个精神领袖就成
     *
     * @return
     */
    public static Emperor getInstance() {
        Random random = new Random();
        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
        return (Emperor) emperorList.get(countNumOfEmperor);
    }

    /**
     * 皇帝叫什么名字呀
     */
    public void emperorInfo() {
        System.out.println(emperorInfoList.get(countNumOfEmperor));
    }

}
