package org.thor.javademo.stream.demo02.stream;


import org.thor.javademo.stream.EarthModel;
import org.thor.javademo.stream.PersonModel;
import org.thor.javademo.stream.TeaModel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2019-11-21 15:47
 * @Version: V1.0
 */
public class DemoStream {
    public static List<PersonModel> personList;

    /**
     * 初始化 赋值
     */
    static {
        PersonModel wu = new PersonModel("wu qi", 18, "男");
        PersonModel zhang = new PersonModel("zhang san", 19, "男");
        PersonModel wang = new PersonModel("wang si", 20, "女");
        PersonModel zhao = new PersonModel("zhao wu", 20, "男");
        PersonModel chen = new PersonModel("chen liu", 21, "男");
        personList = Arrays.asList(wu, zhang, wang, zhao, chen);
    }

    public static void main(String[] args) {
        /*
        1.Filter
        遍历数据并检查其中的元素时使用
        filter接收一个函数作为参数，该函数用Lambda表达式表示
         */
        System.out.println("\n 1.Filter -----");
        DemoStream.filterSex();
        DemoStream.filterSexAndAge();

        /*
        2.Map
        生成的是一对一映射，for的作用
        比较常用
        而且很简单
         */
        System.out.println("\n 2.Map ----");
        DemoStream.listUsernames();

        /*
        3.FlatMap
        顾名思义，跟map差不多，更深层次的操作，单还是有区别的
        map和flat返回值不通
        Map每个输入元素，都会按照规则转换成为另外一个元素。
        还有一些场景，是一对多映射关系，这是需要FlatMap。
        Map:一对一
        FlatMap:一对多
        map和flatMap的方法声明是不一样的
        map和flatMap的区别：faltMap可以处理更深层次的数据，入参为多个list，结果可以返回为一个list，而map是一对一，入参是多个list，
        返回结果必须是多个list。通俗的说，如果入参都是对象，那么flatMap可以操作对象里面的对象，而map只能操作第一层。
         */
        System.out.println("\n 3.FlatMap -----");
        DemoStream.flatMapString();

        /*
        4.Reduce
        类似递归
        数字（字符串）累加
         */
        System.out.println("\n 4.Reduce -----");
        DemoStream.reduceTest();

        /*
        5.Collect
        collect在流中生成列表，map，等常用的数据结构
        toList()
        toSet()
        toMap()
         */
        System.out.println("\n 5.Collect -----");
        DemoStream.toListTest();
        DemoStream.toSetTest();
        DemoStream.toMapTest();
        DemoStream.toGroupTest();
        DemoStream.toJoiningTest();
        DemoStream.reduce();

        /*
        6.Optional
        Optional是核心类库新设计的一个数据类型，用来替换null值
        人们对原有的null值有很多抱怨，甚至连发明这一该你拿的Tony Hoare也是如此，他曾说这是自己一个"价值连城的错误"
        用处很广，不光在lambda中，哪都能用
        Optional.of(T), T为非空，否则初始化报错
        Optional.of(T), T为任意，可以为空
        isPresent(), 相当于 !=null
        ifPresent(T), T可以是一段lambda表达式，或者其他代码，非空则执行
         */
        System.out.println("\n 6.Optional -----");
        DemoStream.optionalTest();

        /*
        7.并发
        stream替换成parallelStream或parallel
        输入流的大小并不是决定并行化是否会带来速度提升的唯一因素，性能还会收到编写代码的方式和核的数量影响
        影响性能的五要素是：数据大小、数据源结构、值是否装箱、可用的CPU的数量，以及处理每个元素说话的时间
         */
        System.out.println("-----------List-----------");
        testList();
        System.out.println("-----------Set-----------");
        testSet();

        /*
        8.Peek
        list.map.fiter.map.xx 为链式调用，最终调用collect(xx)返回结果
        分惰性求值和及早求值
        判断一个操作是惰性求值还是及早求值很简单:只需看它的返回值。如果返回值是 Stream，那么是惰性求值;如果返回值是另一个值或为空，那么就是及早求值。
        使用这些操作的理想方式就是形成一个惰性求值的链，最后用一个及早求值的操作返回想要的结果。
        通过peek可以查看每个值，同时能继续操作流
         */
        DemoStream.peekTest();
    }

    /**
     * peekTest
     */
    public static void peekTest() {
        List<PersonModel> data = DemoStream.getData();

        //peek打印出遍历的每个per
        data.stream().map(per -> per.getName()).peek(p -> {
            System.out.println(p);
        }).collect(toList());
    }


    private static int size = 10000000;

    /**
     * 测试list
     */
    public static void testList() {
        List<Integer> list = new ArrayList<>(size);
        for (Integer i = 0; i < size; i++) {
            list.add(new Integer(i));
        }

        List<Integer> temp1 = new ArrayList<>(size);
        //老的
        long start = System.currentTimeMillis();
        for (Integer i : list) {
            temp1.add(i);
        }
        System.out.println(+System.currentTimeMillis() - start);

        //同步
        long start1 = System.currentTimeMillis();
        list.stream().collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start1);

        //并发
        long start2 = System.currentTimeMillis();
        list.parallelStream().collect(Collectors.toList());
        System.out.println(System.currentTimeMillis() - start2);
    }

    /**
     * 测试set
     */
    public static void testSet() {
        List<Integer> list = new ArrayList<>(size);
        for (Integer i = 0; i < size; i++) {
            list.add(new Integer(i));
        }

        Set<Integer> temp1 = new HashSet<>(size);
        //老的
        long start = System.currentTimeMillis();
        for (Integer i : list) {
            temp1.add(i);
        }
        System.out.println(+System.currentTimeMillis() - start);

        //同步
        long start1 = System.currentTimeMillis();
        list.stream().collect(Collectors.toSet());
        System.out.println(System.currentTimeMillis() - start1);

        //并发
        long start2 = System.currentTimeMillis();
        list.parallelStream().collect(Collectors.toSet());
        System.out.println(System.currentTimeMillis() - start2);
    }

    /**
     * Optional测试
     */
    public static void optionalTest() {
        PersonModel personModel = new PersonModel();
        //对象为空则打出 -
        Optional<Object> o = Optional.of(personModel);
        System.out.println(o.isPresent() ? o.get() : "-");

        //名称为空则打出 -
        Optional<String> name = Optional.ofNullable(personModel.getName());
        System.out.println(name.isPresent() ? name.get() : "-");

        //如果不为空，则打出xxx
        Optional.ofNullable("test").ifPresent(na -> {
            System.out.println(na + "ifPresent");
        });

        //如果空，则返回指定字符串
        System.out.println(Optional.ofNullable(null).orElse("-"));
        System.out.println(Optional.ofNullable("1").orElse("-"));

        //如果空，则返回 指定方法，或者代码
        System.out.println(Optional.ofNullable(null).orElseGet(() -> {
            return "hahah";
        }));
        System.out.println(Optional.ofNullable("1").orElseGet(() -> {
            return "hahah";
        }));

        //如果空，则可以抛出异常
//        System.out.println(Optional.ofNullable("1").orElseThrow(() -> {
//            throw new RuntimeException("ss");
//        }));

        //利用 Optional 进行多级判断
        EarthModel earthModel = new EarthModel();
        //old
        if (earthModel != null) {
            if (earthModel.getTeaModel() != null) {
                //...
            }
        }
        //new
        Optional.ofNullable(earthModel)
                .map(EarthModel::getTeaModel)
                .map(TeaModel::getType)
                .isPresent();

        //判断对象中的list
        Optional.ofNullable(new EarthModel())
                .map(EarthModel::getPersonModelList)
                .map(pers -> pers
                        .stream()
                        .map(PersonModel::getName)
                        .collect(toList()))
                .ifPresent(per -> System.out.println(per));


        List<PersonModel> models = DemoStream.getData();
        Optional.ofNullable(models)
                .map(per -> per
                        .stream()
                        .map(PersonModel::getName)
                        .collect(toList()))
                .ifPresent(per -> System.out.println(per));


    }

    /**
     * toList
     */
    public static void toListTest() {
        List<PersonModel> data = DemoStream.getData();
        List<String> collect = data.stream()
                .map(PersonModel::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * toSet
     */
    public static void toSetTest() {
        List<PersonModel> data = DemoStream.getData();
        Set<String> collect = data.stream()
                .map(PersonModel::getName)
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    /**
     * toMap
     */
    public static void toMapTest() {
        List<PersonModel> data = DemoStream.getData();
        Map<String, Integer> map1 = data.stream()
                .collect(
                        Collectors.toMap(PersonModel::getName, PersonModel::getAge)
                );
        System.out.println(map1);


        Map<String, String> map2 = data.stream().collect(Collectors.toMap(per -> per.getName(), value -> {
            return value + "1";
        }));
        System.out.println(map2);
    }

    /**
     * 指定类型
     */
    public static void toTreeSetTest() {
        List<PersonModel> data = DemoStream.getData();
        TreeSet<PersonModel> collect = data.stream()
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(collect);
    }

    /**
     * 分组
     */
    public static void toGroupTest() {
        List<PersonModel> data = DemoStream.getData();
        Map<Boolean, List<PersonModel>> collect = data.stream()
                .collect(Collectors.groupingBy(per -> "男".equals(per.getSex())));
        System.out.println(collect);
    }

    /**
     * 分隔
     */
    public static void toJoiningTest() {
        List<PersonModel> data = DemoStream.getData();
        String collect = data.stream()
                .map(personModel -> personModel.getName())
                .collect(Collectors.joining(",", "{", "}"));
        System.out.println(collect);
    }

    /**
     * 自定义
     */
    public static void reduce() {
        List<String> collect = Stream.of("1", "2", "3").collect(
                Collectors.reducing(new ArrayList<String>(), x -> Arrays.asList(x), (y, z) -> {
                    y.addAll(z);
                    return y;
                }));
        System.out.println(collect);
    }

    /**
     * Reduce 累计
     */
    public static void reduceTest() {
        //累加，初始化值是 10
        Integer reduce = Stream.of(1, 2, 3, 4)
                .reduce(10, (count, item) -> {
                    System.out.println("count:" + count);
                    System.out.println("item:" + item);
                    return count + item;
                });
        System.out.println(reduce);

        Integer reduce1 = Stream.of(1, 2, 3, 4)
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce1);

        String reduce2 = Stream.of("1", "2", "3")
                .reduce("0", (x, y) -> (x + "," + y));
        System.out.println(reduce2);
    }

    /**
     * FlatMap
     */
    public static void flatMapString() {
        List<PersonModel> list = DemoStream.getData();

        // 返回类型不一样
        List<String> collect1 = list.stream()
                .flatMap(personModel -> Arrays.stream(personModel.getName().split(" ")))
                .collect(toList());

        List<Stream<String>> collect2 = list.stream()
                .map(personModel -> Arrays.stream(personModel.getName().split(" ")))
                .collect(toList());

        //用map实现
        List<String> collect3 = list.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(Arrays::stream).collect(toList());

        //另一种方式
        List<String> collect4 = list.stream()
                .map(person -> person.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream()).collect(toList());

        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(collect3);
        System.out.println(collect4);


    }

    /**
     * 去除所有的用户名字
     */
    public static void listUsernames() {
        List<PersonModel> list = DemoStream.getData();

        // old
        List<String> oldList = new ArrayList<>();
        for (PersonModel person : list) {
            oldList.add(person.getName());
        }
        System.out.println(oldList);

        // new1
        List<String> collect1 = list.stream().map(personModel -> personModel.getName()).collect(toList());
        System.out.println(collect1);
        // new2
        List<String> collect2 = list.stream().map(PersonModel::getName).collect(toList());
        System.out.println(collect2);
        // new3
        list.stream().map(personModel -> {
            System.out.println(personModel.getName());
            return personModel.getName();
        }).collect(toList());

    }

    /**
     * 过滤所有男性
     */
    public static void filterSex() {
        List<PersonModel> list = DemoStream.getData();

        // old
        List<PersonModel> tempList = new ArrayList<>();
        for (PersonModel person : list) {
            if ("男".equals(person.getSex())) {
                tempList.add(person);
            }
        }
        System.out.println(tempList);

        // new
        List<PersonModel> collect = list.stream()
                .filter(person -> "男".equals(person.getSex()))
                .collect(toList());
        System.out.println(collect);
    }

    /**
     * 过滤所有男性并且年龄小于20岁
     */
    public static void filterSexAndAge() {
        List<PersonModel> list = DemoStream.getData();

        // old
        List<PersonModel> tempList = new ArrayList<>();
        for (PersonModel person : list) {
            if ("男".equals(person.getSex()) && person.getAge() < 20) {
                tempList.add(person);
            }
        }
        System.out.println(tempList);

        // new
        List<PersonModel> collect = list.stream()
                .filter(person -> {
                    if ("男".equals(person.getSex()) && person.getAge() < 20) {
                        return true;
                    }
                    return false;
                })
                .collect(toList());
        System.out.println(collect);
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    public static List<PersonModel> getData() {
        return personList;
    }
}
