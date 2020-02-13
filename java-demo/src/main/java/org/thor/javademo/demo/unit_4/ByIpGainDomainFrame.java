package org.thor.javademo.demo.unit_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SuppressWarnings("serial")
public class ByIpGainDomainFrame extends JFrame {
    
    private JTextField tf_ip;
    private JTextField tf_canonical;
    private JTextField tf_host;
    
    /**
     * Launch the application
     * 
     * @param args
     */
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ByIpGainDomainFrame frame = new ByIpGainDomainFrame();
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
    public ByIpGainDomainFrame() {
        super();
        getContentPane().setLayout(null);
        setTitle("通过IP地址获得域名和主机名");
        setBounds(100, 100, 333, 218);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    String ip = tf_ip.getText();// IP地址
                    String[] ipStr = ip.split("[.]");// IP转换为字符串数组
                    byte[] ipBytes = new byte[4];// 声明存储转换后IP的字节数组
                    for (int i = 0; i < 4; i++) {
                        int m = Integer.parseInt(ipStr[i]);// 转换为整数
                        byte b = (byte) (m & 0xff);// 转换为字节
                        ipBytes[i] = b;// 赋值给字节数组
                    }
                    InetAddress inetAddr = InetAddress.getByAddress(ipBytes);// 创建InetAddress对象
                    String canonical = inetAddr.getCanonicalHostName();// 获取域名
                    String host = inetAddr.getHostName();// 获取主机名
                    tf_canonical.setText(canonical);// 在文本框中显示域名
                    tf_host.setText(host);// 在文本框中显示主机名
                } catch (UnknownHostException e1) {
                    e1.printStackTrace();
                }
            }
        });
        button.setText("获取域名和主机名");
        button.setBounds(28, 136, 150, 28);
        getContentPane().add(button);
        
        final JLabel label = new JLabel();
        label.setForeground(new Color(0, 0, 255));
        label.setFont(new Font("", Font.BOLD, 16));
        label.setText("通过IP地址获得域名和主机名");
        label.setBounds(51, 10, 223, 35);
        getContentPane().add(label);
        
        final JLabel label_1 = new JLabel();
        label_1.setText("主 机 名：");
        label_1.setBounds(28, 110, 66, 18);
        getContentPane().add(label_1);
        
        tf_host = new JTextField();
        tf_host.setBounds(87, 108, 199, 22);
        getContentPane().add(tf_host);
        
        final JButton button_1 = new JButton();
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.exit(0);
            }
        });
        button_1.setText("退出系统");
        button_1.setBounds(191, 136, 95, 28);
        getContentPane().add(button_1);
        
        final JLabel label_2 = new JLabel();
        label_2.setText("域    名：");
        label_2.setBounds(28, 82, 66, 18);
        getContentPane().add(label_2);
        
        tf_canonical = new JTextField();
        tf_canonical.setBounds(87, 80, 199, 22);
        getContentPane().add(tf_canonical);

        final JLabel label_3 = new JLabel();
        label_3.setText("输入IP地址：");
        label_3.setBounds(10, 51, 84, 18);
        getContentPane().add(label_3);

        tf_ip = new JTextField();
        tf_ip.setBounds(87, 52, 199, 22);
        getContentPane().add(tf_ip);
        //
    }
    
}
