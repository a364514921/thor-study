package org.thor.javademo.demo.unit_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketFrame extends JFrame {
    private JTextField tf_send;
    private JTextArea ta_info;
    private PrintWriter writer; // ����PrintWriter�����
    private BufferedReader reader; // ����BufferedReader����
    private ServerSocket server; // ����ServerSocket����
    private Socket socket; // ����Socket����socket
    
    public void getserver() {
        try {
            server = new ServerSocket(1978); // ʵ����Socket����
            ta_info.append("�������׽����Ѿ������ɹ�\n"); // �����Ϣ
            while (true) { // ����׽���������״̬
                ta_info.append("�ȴ��ͻ���������......\n"); // �����Ϣ
                socket = server.accept(); // ʵ����Socket����
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // ʵ����BufferedReader����
                writer = new PrintWriter(socket.getOutputStream(), true);
                getClientInfo(); // ����getClientInfo()����
            }
        } catch (Exception e) {
            e.printStackTrace(); // ����쳣��Ϣ
        }
    }
    
    private void getClientInfo() {
        try {
            while (true) { // ����׽���������״̬
                String line = reader.readLine();
                if (line != null)
                    ta_info.append("���յ��ͻ������͵���Ϣ��" + line + "\n"); // ��ÿͻ�����Ϣ
            }
        } catch (Exception e) {
            ta_info.append("�ͻ������˳���\n"); // ����쳣��Ϣ
        } finally {
            try {
                if (reader != null) {
                    reader.close();// �ر���
                }
                if (socket != null) {
                    socket.close(); // �ر��׽���
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) { // ������
        ServerSocketFrame frame = new ServerSocketFrame(); // �����������
        frame.setVisible(true);
        frame.getserver(); // ���÷���
    }
    
    public ServerSocketFrame() {
        super();
        setTitle("�������˳���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 379, 260);
        
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        ta_info = new JTextArea();
        scrollPane.setViewportView(ta_info);
        
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);
        
        final JLabel label = new JLabel();
        label.setText("���������͵���Ϣ��");
        panel.add(label);
        
        tf_send = new JTextField();
        tf_send.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                writer.println(tf_send.getText()); // ���ı�������Ϣд����
                ta_info.append("���������͵���Ϣ�ǣ�" + tf_send.getText() + "\n"); // ���ı�������Ϣ��ʾ���ı�����
                tf_send.setText(""); // ���ı������
            }
        });
        tf_send.setPreferredSize(new Dimension(220, 25));
        panel.add(tf_send);
    }
}
