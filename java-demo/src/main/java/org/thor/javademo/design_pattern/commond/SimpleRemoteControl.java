package org.thor.javademo.design_pattern.commond;

/**
 * @Description 遥控器
 * @ClassName SimpleRemoteControl
 * @Author wangyq
 * @Date 2019-04-12 17:08
 * @Version 1.0.0
 **/
public class SimpleRemoteControl {
  private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}