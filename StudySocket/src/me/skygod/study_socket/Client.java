package me.skygod.study_socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";//目标电脑的ip地址，这里的地址是本机地址
        int port = 8888;//目标电脑的端口
        try {
            Socket socket = new Socket(host, port);//创建目标连接，传入ip地址和端口号
            System.out.println("开启客户端");
            Thread thread1 = new Thread() {//使用多线程方法来实行收发，线程1负责接收信息
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();//获取socket输入流
                        DataInputStream dataInputStream = new DataInputStream(inputStream);
                        //把输入流封装在DataInputStream
                        while (true) {
                            String msg = dataInputStream.readUTF();//使用readUTF读取字符串
                            System.out.println("接收服务端消息： " + msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread2 = new Thread() {//线程2用来发送消息
                @Override
                public void run() {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        //打开输出流
                        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                        //把输出流封装在DataOutputStream中
                        Scanner scanner = new Scanner(System.in);
                        while (true) {
                            String str = scanner.next();
                            dataOutputStream.writeUTF(str);//使用writeUTF发送字符串
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread1.start();
            thread2.start();
            thread1.join();
            System.out.println("客户端关闭");
            socket.close();//关闭这个socket
        } catch (Exception e) {
            System.out.println("断开连接");
        }
    }
}
