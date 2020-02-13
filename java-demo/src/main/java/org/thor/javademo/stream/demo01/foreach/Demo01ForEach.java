package org.thor.javademo.stream.demo01.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:传统集合的多步遍历代码
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午4:51
 * @Version: V1.0
 */
public class Demo01ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        for (String name : list) {
            System.out.println(name);
        }
    }
}
