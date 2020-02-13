package org.thor.javademo.network;

import java.io.*;
import java.net.Socket;

/**
 * 模块名称：StudyJava com.wyq.studyjava.网络编程
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2017-08-23 下午7:23
 * 系统版本：1.0.0
 **/

public class GreetClient {

    public static void main(String [] args)
    {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try
        {
            System.out.println("连接到主机：" + serverName + " ，端口号：" + port);
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
