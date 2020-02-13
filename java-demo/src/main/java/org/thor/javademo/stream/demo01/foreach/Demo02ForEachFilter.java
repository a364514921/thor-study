package org.thor.javademo.stream.demo01.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:传统集合的多步遍历代码 需求：
 * 1. 筛选所有姓张的人
 * 2. 筛选名字有三个字的人
 * 3. 进行对结果进行输出打印
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午4:51
 * @Version: V1.0
 */
public class Demo02ForEachFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        List<String> zhangList = new ArrayList<>();
        for (String name : list) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        List<String> shortList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                shortList.add(name);
            }
        }
        for (String name : shortList) {
            System.out.println(name);
        }
    }
}
