package org.thor.javademo.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: TCP通信的服务端：接受客户端的请求，读取客户端的数据，给客户端回写数据
 * 表示服务器的类：
 * java.net.ServerSocket: 此类实现服务器套接字
 * 构造方法：
 * ServerSocket(int port) 创建绑定到特定端口的服务器套接字
 * 服务器端必须直到是哪个客户端请求的服务器
 * 可以使用accept()方法获取到请求客户对象的Socket
 * 成员方法：
 * Socket accept() 侦听并接受到此套接字的连接
 * @author: wangyiqiang
 * @date: 2020-02-10 下午12:10
 * @version: V1.0
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        // 1.指定服务端端口号
        ServerSocket serverSocket = new ServerSocket(8888);

        // 2.使用ServerSocket对象中的方法accept()获取到请求客户端对象的Socket
        Socket socket = serverSocket.accept();

        // 3.使用Socket对象中的getInputStream()方法获取网络字节输入流InputStream
        InputStream is = socket.getInputStream();

        // 4.使用网络字节输入流InputStream对象中的方法read，读取客户端发送的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));

        // 5.使用Socket对象中的方法getOutputSteam()方法获取网络字节输出流OutputSteam
        OutputStream os = socket.getOutputStream();

        // 6.使用网络字节输出流OutputSteam给客户端诙谐数据
        os.write("收到！谢谢".getBytes());

        // 7.释放资源
        is.close();
        os.close();
        socket.close();
        serverSocket.close();
    }
}
