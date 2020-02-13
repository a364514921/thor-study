package org.thor.javademo.demo.unit_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SuppressWarnings("serial")
public class GetLocalHostNameFrame extends JFrame {
    
    private JTextField tf_canonical;
    private JTextField tf_host;
    /**
     * Launch the application
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GetLocalHostNameFrame frame = new GetLocalHostNameFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame
     */
    public GetLocalHostNameFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("获取本地主机的域名和主机名");
        setBounds(100, 100, 333, 226);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    InetAddress inetAddr = InetAddress.getLocalHost();// 创建本地主机的InetAddress对象
                    String canonical = inetAddr.getCanonicalHostName();// 获取本地主机的域名
                    String host = inetAddr.getHostName();// 获取本地主机的主机名
                    tf_canonical.setText(canonical);// 在文本框中显示本地主机的域名
                    tf_host.setText(host);// 在文本框中显示本地主机的主机名
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }
            }
        });
        button.setText("获取域名和主机名");
        button.setBounds(28, 150, 150, 28);
        getContentPane().add(button);

        final JLabel label = new JLabel();
        label.setForeground(new Color(0, 0, 255));
        label.setFont(new Font("", Font.BOLD, 16));
        label.setText("获取本地主机的域名和主机名");
        label.setBounds(46, 21, 223, 35);
        getContentPane().add(label);

        final JLabel label_1 = new JLabel();
        label_1.setText("主 机 名：");
        label_1.setBounds(28, 112, 66, 18);
        getContentPane().add(label_1);

        tf_host = new JTextField();
        tf_host.setBounds(87, 110, 199, 22);
        getContentPane().add(tf_host);

        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        button_1.setText("退出系统");
        button_1.setBounds(191, 150, 95, 28);
        getContentPane().add(button_1);

        final JLabel label_2 = new JLabel();
        label_2.setText("域    名：");
        label_2.setBounds(28, 72, 66, 18);
        getContentPane().add(label_2);

        tf_canonical = new JTextField();
        tf_canonical.setBounds(87, 70, 199, 22);
        getContentPane().add(tf_canonical);
        //
    }
    
}
