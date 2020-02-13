package org.thor.javademo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo12StreamForEach {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张无忌", "张三丰", "周芷若");
        stream.forEach(name -> {
            System.out.println("name=" + name);
        });

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.stream().forEach(item -> {
            System.out.println("item=" + item);
        });

        Stream<String> original = Stream.of("张无忌", "张三丰", "周芷若");
        Stream<String> result = original.filter(s -> s.startsWith("张"));
        result.forEach(System.out::println);
    }
}