package org.thor.javademo.design_pattern.commond;

/**
 * @Description
 * @ClassName SimpleRemoteControlTest
 * @Author wangyq
 * @Date 2019-04-12 17:10
 * @Version 1.0.0
 **/
public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl control = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommond = new LightOnCommand(light);
        control.setCommand(lightOnCommond);
        control.pressButton();
    }
}