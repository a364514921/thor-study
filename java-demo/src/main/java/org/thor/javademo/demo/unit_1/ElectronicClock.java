package org.thor.javademo.demo.unit_1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ElectronicClock extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 3688891358876658465L;
    private JPanel contentPane;
    private ImageIcon colon = new ImageIcon("src/images/colon.png");
    private ImageIcon[] numbers = { new ImageIcon("src/images/0.png"), new ImageIcon("src/images/1.png"), new ImageIcon("src/images/2.png"), new ImageIcon("src/images/3.png"),
            new ImageIcon("src/images/4.png"), new ImageIcon("src/images/5.png"), new ImageIcon("src/images/6.png"), new ImageIcon("src/images/7.png"),
            new ImageIcon("src/images/8.png"), new ImageIcon("src/images/9.png") };
    private JLabel hour1Label;
    private JLabel hour2Label;
    private JLabel colon1Label;
    private JLabel minute1Label;
    private JLabel minute2Label;
    private JLabel colon2Label;
    private JLabel second1Label;
    private JLabel second2Label;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ElectronicClock frame = new ElectronicClock();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public ElectronicClock() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent arg0) {
                do_this_windowActivated(arg0);
            }
        });
        setTitle("\u7535\u5B50\u65F6\u949F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 100);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 8, 5, 5));
        
        JPanel hour1Panel = new JPanel();
        contentPane.add(hour1Panel);
        
        hour1Label = new JLabel("");
        hour1Label.setHorizontalAlignment(SwingConstants.CENTER);
        hour1Panel.add(hour1Label);
        
        JPanel hour2Panel = new JPanel();
        contentPane.add(hour2Panel);
        
        hour2Label = new JLabel("");
        hour2Label.setHorizontalAlignment(SwingConstants.CENTER);
        hour2Panel.add(hour2Label);
        
        JPanel colon1Panel = new JPanel();
        contentPane.add(colon1Panel);
        
        colon1Label = new JLabel("");
        colon1Label.setHorizontalAlignment(SwingConstants.CENTER);
        colon1Panel.add(colon1Label);
        
        JPanel minute1Panel = new JPanel();
        contentPane.add(minute1Panel);
        
        minute1Label = new JLabel("");
        minute1Label.setHorizontalAlignment(SwingConstants.CENTER);
        minute1Panel.add(minute1Label);
        
        JPanel minute2Panel = new JPanel();
        contentPane.add(minute2Panel);
        
        minute2Label = new JLabel("");
        minute2Label.setHorizontalAlignment(SwingConstants.CENTER);
        minute2Panel.add(minute2Label);
        
        JPanel colon2Panel = new JPanel();
        contentPane.add(colon2Panel);
        
        colon2Label = new JLabel("");
        colon2Label.setHorizontalAlignment(SwingConstants.CENTER);
        colon2Panel.add(colon2Label);
        
        JPanel second1Panel = new JPanel();
        contentPane.add(second1Panel);
        
        second1Label = new JLabel("");
        second1Label.setHorizontalAlignment(SwingConstants.CENTER);
        second1Panel.add(second1Label);
        
        JPanel second2Panel = new JPanel();
        contentPane.add(second2Panel);
        
        second2Label = new JLabel("");
        second2Label.setHorizontalAlignment(SwingConstants.CENTER);
        second2Panel.add(second2Label);
    }
    
    private void getTime() {
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // 获得当前的小时
        int minute = calendar.get(Calendar.MINUTE); // 获得当前的分钟
        int second = calendar.get(Calendar.SECOND); // 获得当前的秒钟
        hour1Label.setIcon(numbers[hour / 10]);// 利用商获得小时第一位图片
        hour2Label.setIcon(numbers[hour % 10]);// 利用余数获得小时第二位图片
        minute1Label.setIcon(numbers[minute / 10]);// 利用商获得分钟第一位图片
        minute2Label.setIcon(numbers[minute % 10]);// 利用余数获得小时第二位图片
        second1Label.setIcon(numbers[second / 10]);// 利用商获得秒钟第一位图片
        second2Label.setIcon(numbers[second % 10]);// 利用余数获得小时第二位图片
    }
    
    private class ClockRunnable implements Runnable {
        
        @Override
        public void run() {
            while (true) {
                getTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    protected void do_this_windowActivated(WindowEvent arg0) {
        colon1Label.setIcon(colon);
        colon2Label.setIcon(colon);
        new Thread(new ClockRunnable()).start();
    }
}
