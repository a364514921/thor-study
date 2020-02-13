package org.thor.javademo.设计模式新.d5_工厂模式;

/**
 * @Description:女娲造人
 * @Author: wangyiqiang
 * @Date: 2019-11-17 15:18
 * @Version: V1.0
 */
public class NvWa {
    public static void main(String[] args) {
        //女娲第一次造人，试验性质，少造点，火候不足，缺陷产品
        System.out.println("------------造出的第一批人是这样的:白人 -----------------");
        Human whiteMan = HumanFactory.createHuman(WhiteHuman.class);
        whiteMan.laugh();
        whiteMan.cry();
        whiteMan.talk();

        //女娲第二次造人，火候加足点，然后又出了个次品，黑人
        System.out.println("\n\n------------造出的第二批人是这样的:黑人 -----------------");
        Human blackMan =  HumanFactory.createHuman(BlackHuman.class);
        blackMan.laugh();
        blackMan.cry();
        blackMan.talk();

        //第三批人了，这次火候掌握的正好，黄色人类(不写黄人，免得引起歧义)，备注:RB人不属 于此列
        System.out.println("\n\n------------造出的第三批人是这样的:黄色人类 -----------------");
        Human yellowMan = HumanFactory.createHuman(YellowHuman.class);
        yellowMan.laugh();
        yellowMan.cry();
        yellowMan.talk();

        for (int i = 0; i < 10; i++) {
            Human autoHuman = HumanFactory.createHuman();
            autoHuman.laugh();
            autoHuman.talk();
            autoHuman.cry();
        }
    }
}
