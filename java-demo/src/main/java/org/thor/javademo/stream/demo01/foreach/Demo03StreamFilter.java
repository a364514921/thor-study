package org.thor.javademo.stream.demo01.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 使用Stream流的方式，遍历集合，对集合汇总的数据进行过滤
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午4:56
 * @Version: V1.0
 */
public class Demo03StreamFilter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream()
                .filter(str -> str.startsWith("张"))
                .filter(str -> str.length() == 3)
                .forEach(str -> System.out.println(str));
    }
}
