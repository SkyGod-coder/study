package me.skygod.study_socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            //��8888�˿��ϼ��������Ƿ��������������
            System.out.println("�ȴ�����");
            final Socket[] accept = {serverSocket.accept()};
            //��ȡsocket����
            /*Thread thread1 = new Thread(){//ʹ�ö��߳��������շ����߳�1����������Ϣ
                @Override
                public void run() {
                    try {
                        InputStream inputStream = accept.getInputStream();//��ȡsocket������
                        DataInputStream dataInputStream = new DataInputStream(inputStream);
                        //����������װ��DataInputStream
                        while (true){
                            String msg = dataInputStream.readUTF();//ʹ��readUTF��ȡ�ַ���
                            System.out.println("�����ͻ�����Ϣ�� "+msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };*/
            Thread thread2 = new Thread() {//�߳�2����������Ϣ
                @Override
                public void run() {
                    OutputStream outputStream = null;
                    DataOutputStream dataOutputStream = null;
                    final Scanner scanner = new Scanner(System.in);
                    //��ȡ������
                    while (outputStream == null) {
                        try {
                            if (accept[0] == null || !accept[0].isConnected()) accept[0] = serverSocket.accept();
                            System.out.println("�����ӹ���" + accept[0]);
                            outputStream = accept[0].getOutputStream();//�������
                        } catch (IOException ignored) {
                        }
                        if (outputStream != null)
                            dataOutputStream = new DataOutputStream(outputStream);//���������װ��DataOutputStream��
                    }
                    while (true) {
                        System.out.println("���췢�ͣ�");
                        String strServer = scanner.next();
                        if (strServer.equalsIgnoreCase("exit")) {
                            break;
                        }
                        try {
                            dataOutputStream.writeUTF(strServer);//ʹ��writeUTF�����ַ���
                            dataOutputStream.flush();
                        } catch (IOException e) {
                            try {
                                System.out.println("��Ϣ����ʧ�ܣ�������");
                                accept[0] = serverSocket.accept();
                                System.out.println("�����ӹ���" + accept[0]);
                                outputStream = accept[0].getOutputStream();
                                if (outputStream != null) dataOutputStream = new DataOutputStream(outputStream);
                            } catch (IOException ignored) {
                            }
                        }
                    }
                }
            };
//            thread1.start();
            thread2.start();
            thread2.join();
            accept[0].close();//�رյ���socket����
            serverSocket.close(); //�ر����socket ������
            System.out.println("�������ر�");
        } catch (Exception e) {
            System.out.println("�Ͽ�����");
        }
    }
}
