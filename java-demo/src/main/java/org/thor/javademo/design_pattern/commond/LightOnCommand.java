package org.thor.javademo.design_pattern.commond;

/**
 * @Description 开灯命令
 * @ClassName LightOnCommond
 * @Author wangyq
 * @Date 2019-04-12 15:51
 * @Version 1.0.0
 **/
public class LightOnCommand implements Command{
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}