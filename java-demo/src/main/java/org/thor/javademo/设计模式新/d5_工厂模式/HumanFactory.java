package org.thor.javademo.设计模式新.d5_工厂模式;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @Description:造人工厂
 * @Author: wangyiqiang
 * @Date: 2019-11-17 15:15
 * @Version: V1.0
 */
public class HumanFactory {

    /**
     * 延迟初始化
     */
    private static HashMap<String, Human> humanMap = new HashMap<String, Human>();

    public static Human createHuman(Class clazz) {
        // 定义一个类型的人类
        Human human = null;

        try {
            // 如果MAP中有，则直接从取出，不用初始化了
            if (humanMap.containsKey(clazz.getSimpleName())) {
                human = humanMap.get(clazz.getSimpleName());
            } else {
                human = (Human) Class.forName(clazz.getName()).newInstance();
                humanMap.put(clazz.getSimpleName(), human);
            }
        } catch (InstantiationException e) {
            System.out.println("必须指定人类的颜色");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("人类定义错误!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("混蛋，你指定的人类找不到!");
            e.printStackTrace();
        }
        return human;
    }

    /**
     * 女娲生气了，把一团泥巴塞到八卦炉，哎产生啥人类就啥人类
     *
     * @return
     */
    public static Human createHuman() {
        //定义一个类型的人类
        Human human = null;

        //首先是获得有多少个实现类，多少个人类
        List<Class> concreteHumanList = ClassUtils.getAllClassByInterface(Human.class); //定义了多少人类

        //八卦炉自己开始想烧出什么人就什么人
        Random random = new Random();
        int rand = random.nextInt(concreteHumanList.size());
        human = createHuman(concreteHumanList.get(rand));
        return human;
    }
}
