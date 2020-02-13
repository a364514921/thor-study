package org.thor.javademo.demo.unit_1.pingtu;

import javax.swing.*;
import java.awt.*;

/**
 * 封装一个单元图片对象
 * 模块名称：StudyJava com.wyq.studyjava.demo.unit_1.pingtu
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-21 上午2:12
 * 系统版本：1.0.0
 **/

public class Cell extends JButton {
    /**
     * 图片宽度
     */
    public static final int IMAGE_WIDTH = 117;

    /**
     * 图片位置
     */
    private int place;

    public Cell(Icon icon, int place) {
        //单元图片大小
        this.setSize(IMAGE_WIDTH, IMAGE_WIDTH);
        //单元图片图标
        this.setIcon(icon);
        //单元图片位置
        this.place = place;
    }

    /**
     * 移动单元图片的方法
     */
    public void move(Direction direction) {
        //获取图片的Rectangle对象
        Rectangle rec = this.getBounds();
        switch (direction) {
            case UP:
                this.setLocation(rec.x, rec.y - IMAGE_WIDTH);
                break;
            case DOWN:
                this.setLocation(rec.x, rec.y + IMAGE_WIDTH);
                break;
            case LEFT:
                this.setLocation(rec.x - IMAGE_WIDTH,rec.y);
                break;
            case RIGHT:
                this.setLocation(rec.x + IMAGE_WIDTH,rec.y);
                break;
        }
    }

    @Override
    public int getX() {
        return this.getBounds().x;
    }

    @Override
    public int getY() {
        return this.getBounds().y;
    }

    public int getPlace() {
        return place;
    }
}
