package org.thor.javademo.stream.demo02.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Description: java.util.stream.Stream<T> 是Java 8新加入的最常用的流接口。
 * （这并不是一个函数式接口。） 获取一个流非常简单，
 * 有以下几种常用的方式：
 * 1. 所有的 Collection 集合都可以通过 stream 默认方法获取流；
 * 2. Stream 接口的静态方法 of 可以获取数组对应的流。
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午5:19
 * @Version: V1.0
 */
public class Demo02GetStream {
    public static void main(String[] args) {
        // 把集合转换为Stream流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        // 间接把map转换为Stream流
        Map<String, Object> map = new HashMap<>();

        // 获取键，存储到一个Set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();

        // 获取值，存储到一个Collection集合中
        Collection<Object> values = map.values();
        Stream<Object> stream4 = values.stream();

        // 获取键值对（键与值的映射关系 entrySet）
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Stream<Map.Entry<String, Object>> stream5 = entries.stream();

        // 把数组转换为Stream流
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);
        // 可变参数可以传递数组
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream7 = Stream.of(arr);
        String[] arrStr = {"a", "b", "c"};
        Stream<String> stream8 = Stream.of(arrStr);

    }
}
