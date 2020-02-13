package org.thor.javademo.stream.demo08.ConstructorMethodReference;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午9:15
 * @Version: V1.0
 */
public class Demo01ConstructMethodReference {
    public static void main(String[] args) {
        method("李白", (name) -> {
            return new Person(name);
        });

        method("李白", name -> new Person(name));

        method("李白", Person::new);
    }

    public static void method(String name, PersonBuilder pb) {
        Person person = pb.build(name);
        System.out.println(person.getName());
    }
}
