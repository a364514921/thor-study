package org.thor.javademo.demo.unit_1.pingtu;


import org.thor.javademo.demo.unit_1.pingtu.swtdesigner.SwingResourceManager;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * 模块名称：StudyJava com.wyq.studyjava.demo.unit_1.pingtu
 * 功能说明：<br>用户创建面板对象
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-21 上午2:26
 * 系统版本：1.0.0
 **/

public class GamePanel extends JPanel implements MouseListener {

    private Cell[] cells = new Cell[9];

    private Cell cellBlack = null;

    public GamePanel() {
        super();
        setLayout(null);
        init();
    }

    /**
     * 游戏初始化
     */
    public void init() {
        //图片序号
        int num = 0;
        //图标对象
        Icon icon = null;
        //单元图片对象
        Cell cell = null;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //计算图片序号
                num = i * 3 + j;
                String path = "/pic/" + (num + 1) + ".jpg";
                System.out.println("path:" + path);
                icon = SwingResourceManager.getIcon(GamePanel.class, path);
                System.out.println("icon：" + icon);
                cell = new Cell(icon, num);

                //设置单元图片坐标
                cell.setLocation(j * Cell.IMAGE_WIDTH, i * Cell.IMAGE_WIDTH);
                //将单元图片存储到单元图片数组中
                cells[num] = cell;
            }
        }

        //向面板中添加所有单元
        for (int i = 0; i < cells.length; i++) {
            this.add(cells[i]);
        }

    }

    /**
     * 对图片进行随机排序
     */
    public void random() {
        Random random = new Random();
        int m, n;
        //判断空白图片位置是否为空
        if (cellBlack == null) {
            //取出空白图片
            cellBlack = cells[cells.length - 1];
            //遍历所有单元图片
            for (int i = 0; i < cells.length; i++) {

                if (i != cells.length - 1) {
                    //对非空白图片添加鼠标监听时间
                    cells[i].addMouseListener(this);
                }
            }
        }

        //遍历所有单元图片，产生随机数
        for (int i = 0; i < cells.length; i++) {
            m = random.nextInt(cells.length);
            n = random.nextInt(cells.length);

            //对单元图片调换
            cells[m].setLocation(cells[n].getX(), cells[n].getY());
            cells[n].setLocation(cells[m].getX(), cells[m].getY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Cell cell = (Cell) e.getSource();
        int x = cellBlack.getX();
        int y = cellBlack.getY();

        if ((x - cell.getX()) == Cell.IMAGE_WIDTH && cell.getY() == y) {
            //向右移动
            cell.move(Direction.RIGHT);
            cellBlack.move(Direction.LEFT);
        } else if ((x - cell.getX()) == -Cell.IMAGE_WIDTH && cell.getY() == y) {
            //想做移动
            cell.move(Direction.LEFT);
            cellBlack.move(Direction.RIGHT);
        } else if ((cell.getY() - y) == Cell.IMAGE_WIDTH && cell.getX() == x) {
            //向下移动
            cell.move(Direction.UP);
            cellBlack.move(Direction.DOWN);
        } else if ((cell.getY() - y) == -Cell.IMAGE_WIDTH && cell.getX() == x) {
            //向上移动
            cell.move(Direction.DOWN);
            cellBlack.move(Direction.UP);
        }

        //判断拼图是否成功
        if (isSuccess()) {
            int i = JOptionPane.showConfirmDialog(this, "成功，再来一局？", "拼图成功", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                random();
            }
        }
    }

    /**
     * 判断是否拼图成功
     *
     * @return 布尔值
     */
    public boolean isSuccess() {
        for (int i = 0; i < cells.length; i++) {// 遍历所有单元图片
            int x = cells[i].getX();// 获取x坐标
            int y = cells[i].getY();// 获取y坐标
            if (i != 0) {
                if (y / Cell.IMAGE_WIDTH * 3 + x / Cell.IMAGE_WIDTH != cells[i].getPlace()) {// 判断单元图片位置是否正确
                    return false;// 只要有一个单元图片的位置不正确，就返回false
                }
            }
        }
        return true;// 所有单元图片的位置都正确返回true
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
