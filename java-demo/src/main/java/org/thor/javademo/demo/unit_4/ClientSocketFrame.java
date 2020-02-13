package org.thor.javademo.demo.unit_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketFrame extends JFrame { // ������̳�JFrame��
    private JLabel label;
    private JPanel panel;
    private PrintWriter writer; // ����PrintWriter�����
    private BufferedReader reader; // ����BufferedReader����
    private Socket socket; // ����Socket����
    private JTextArea ta_info = new JTextArea(); // ����JtextArea����
    private JTextField tf_send = new JTextField(); // ����JtextField����
    
    public ClientSocketFrame() { // ���췽��
        super(); // ���ø���Ĺ��췽��
        setTitle("�ͻ��˳���");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 361, 257);
        final JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta_info);
        getContentPane().add(getPanel(), BorderLayout.NORTH);
    }
    
    private void connect() { // �����׽��ַ���
        ta_info.append("��������......\n"); // �ı�������Ϣ��Ϣ
        try { // ��׽�쳣
            socket = new Socket("192.168.0.104", 1978); // ʵ����Socket����
            while (true) {
                writer = new PrintWriter(socket.getOutputStream(), true);
                reader = new BufferedReader(new InputStreamReader(socket
                        .getInputStream())); // ʵ����BufferedReader����
                ta_info.append("������ӡ�\n"); // �ı�������ʾ��Ϣ
                getClientInfo();
            }
        } catch (Exception e) {
            e.printStackTrace(); // ����쳣��Ϣ
        }
    }
    
    public static void main(String[] args) { // ������
        ClientSocketFrame clien = new ClientSocketFrame(); // ������������
        clien.setVisible(true); // ��������ʾ
        clien.connect(); // �������ӷ���
    }
    
    private void getClientInfo() {
        try {
            while (true) { // ����׽���������״̬
                if (reader != null) {
                    String line = reader.readLine();
                    if (line != null)
                        ta_info.append("���յ����������͵���Ϣ��" + line + "\n"); // ��ÿͻ�����Ϣ
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    
    /**
     * @return
     */
    protected JPanel getPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.add(getLabel());
            tf_send.setPreferredSize(new Dimension(200, 25));
            panel.add(tf_send);
            tf_send.addActionListener(new ActionListener() { // ���¼�
                        public void actionPerformed(ActionEvent e) {
                            writer.println(tf_send.getText()); // ���ı�������Ϣд����
                            ta_info.append("�ͻ��˷��͵���Ϣ�ǣ�" + tf_send.getText()
                                    + "\n"); // ���ı�������Ϣ��ʾ���ı�����
                            tf_send.setText(""); // ���ı������
                        }
                    });
        }
        return panel;
    }
    
    /**
     * @return
     */
    protected JLabel getLabel() {
        if (label == null) {
            label = new JLabel();
            label.setText("�ͻ��˷��͵���Ϣ��");
        }
        return label;
    }
}
