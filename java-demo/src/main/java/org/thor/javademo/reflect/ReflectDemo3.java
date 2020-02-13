package org.thor.javademo.reflect;


import org.thor.javademo.reflect.domain.Person;

import java.lang.reflect.Constructor;

public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {

        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
            2. 获取构造方法们
                 * Constructor<?>[] getConstructors()
                 * Constructor<T> getConstructor(类<?>... parameterTypes)

                 * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
                 * Constructor<?>[] getDeclaredConstructors()
         */


        //Constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //创建对象
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);

        System.out.println("----------");


        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
        //创建对象
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

        Object o = personClass.newInstance();
        System.out.println(o);


        //constructor1.setAccessible(true);
    }


}
