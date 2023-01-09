package me.skygod.study_socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";//Ŀ����Ե�ip��ַ������ĵ�ַ�Ǳ�����ַ
        int port = 8888;//Ŀ����ԵĶ˿�
        try {
            Socket socket = new Socket(host, port);//����Ŀ�����ӣ�����ip��ַ�Ͷ˿ں�
            System.out.println("�����ͻ���");
            Thread thread1 = new Thread() {//ʹ�ö��̷߳�����ʵ���շ����߳�1���������Ϣ
                @Override
                public void run() {
                    try {
                        InputStream inputStream = socket.getInputStream();//��ȡsocket������
                        DataInputStream dataInputStream = new DataInputStream(inputStream);
                        //����������װ��DataInputStream
                        while (true) {
                            String msg = dataInputStream.readUTF();//ʹ��readUTF��ȡ�ַ���
                            System.out.println("���շ������Ϣ�� " + msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread2 = new Thread() {//�߳�2����������Ϣ
                @Override
                public void run() {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        //�������
                        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                        //���������װ��DataOutputStream��
                        Scanner scanner = new Scanner(System.in);
                        while (true) {
                            String str = scanner.next();
                            dataOutputStream.writeUTF(str);//ʹ��writeUTF�����ַ���
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread1.start();
            thread2.start();
            thread1.join();
            System.out.println("�ͻ��˹ر�");
            socket.close();//�ر����socket
        } catch (Exception e) {
            System.out.println("�Ͽ�����");
        }
    }
}
