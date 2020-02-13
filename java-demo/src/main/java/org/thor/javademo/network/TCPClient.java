package org.thor.javademo.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description: TCP通信的客户端：向服务器发送连接请求，给服务器发送数据，读取服务器诙谐的数据
 * 表示客户端的类：java.net.Socket: 此类实现客户端套接字（也可以叫"套接字"）。套接字是两台机器间通信的端点。
 * 包含了IP地址和端口号的网络单位
 * <p>
 * 构造方法：
 * Sokcet(String host,int port)创建一个流套接字并将其连接到指定主机上的指定端口号。
 * <p>
 * 成员方法：
 * OutputStream getOutputStream() 返回此套接字的输出流
 * InputStream getInputStream() 返回此套接字的输入流
 * void close() 关闭此套接字
 * <p>
 * 实现步骤：
 * 1. 创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
 * 2. 使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream。
 * 3. 使用网络字节输出流OutputStream对象中的write方法，给服务器发送数据。
 * 4. 使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象。
 * 5. 使用网络字节输入流InputStream对象中的方法read,读取服务器返回的数据
 * 6. 释放资源
 * <p>
 * 注意：
 * 1. 客户端和服务端进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
 * 2. 当我们创建客户端对象Socket的时候，就会去请求服务器和服务器经过三次握手建立连接同路
 * 这时服务器没有启动，那么就会抛出异常，如果服务器已经启动那么就可以进行交互了
 * @author: wangyiqiang
 * @date: 2020-02-10 上午11:50
 * @version: V1.0
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        // 1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);

        // 2.使用Socket对象中的方法getOutputStream()获取网络字节输出流OutputStream。
        OutputStream os = socket.getOutputStream();

        // 3.使用网络字节输出流OutputStream对象中的write方法，给服务器发送数据。
        os.write("你好服务器".getBytes());

        // 4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象。
        InputStream is = socket.getInputStream();

        // 5.使用网络字节输入流InputStream对象中的方法read,读取服务器返回的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));

        // 6.释放资源
        os.close();
        is.close();
        socket.close();
    }
}
