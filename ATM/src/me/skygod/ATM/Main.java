package me.skygod.ATM;

import java.util.Scanner;

/**
 * @author SkyGod
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    /**
     * main��������ʼ����
     *
     * @param args main��������
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("===ATM===");
            System.out.println("1.��½");
            System.out.println("2.����");
            System.out.println("3.�˳�");
            //Fix������50��ͬ��Scanner#nextInt()��ȡ --> �Ƚ���ȡ����String����Ϊlong���ٽ�ȡΪint���ɱ��������뵼�µı���
            int command = (int)Long.parseLong(scanner.next());
            switch (command) {
                case 1:
                    Controller.login();
                    continue;
                case 2:
                    Controller.creatAccount();
                    System.out.println("���������ַ�����");
                    scanner.next();
                    continue;
                case 3:
                    return;
                default:
                    System.out.println("û�����ָ��");
            }
        }
    }

    /**
     * �û�����
     * @param account ������û����˻���
     */
    public static void home(Account account) {
        home:
        while (true) {
            System.out.println("===�û�����===");
            String[] commands = {"1.��ѯ", "2.���", "3.ȡ��", "4.ת��", "5.�޸�����", "6.�˳�", "7.ע���˻�"};
            for (String s : commands) {
                System.out.println(s);
            }
            int command = (int)Long.parseLong(scanner.next());
            switch (command) {
                case 1:
                    System.out.println(account);
                    System.out.println("���������ַ�����");
                    scanner.next();
                    continue;
                case 2:
                    System.out.println("������Ҫ���Ľ��");
                    Controller.save(account,scanner.nextInt());
                    System.out.println("���������ַ�����");
                    scanner.next();
                    continue;
                case 3:
                    System.out.println("������Ҫȡ��Ľ��");
                    Controller.withdraw(account,scanner.nextInt());
                    System.out.println("���������ַ�����");
                    scanner.next();
                    continue;
                case 4:
                    System.out.println("������Է��Ŀ���");
                    String number = scanner.next();
                    if(number.equalsIgnoreCase(String.valueOf(account.getNumber()))){
                        System.out.println("���ܸ��Լ�ת��\n���������ַ�����");
                        scanner.next();
                        continue;
                    }
                    Account accountIn = Controller.getAccount(number);
                    if(accountIn == null){
                        System.out.println("��Ч�Ŀ���");
                        continue;
                    }
                    String nameIn = accountIn.getName();
                    System.out.println("������Է�����[*" + nameIn.substring(1) + "]");
                    String lastname = scanner.next();
                    if(!nameIn.startsWith(lastname)){
                        System.out.println("��֤ʧ��\n���������ַ�����");
                        scanner.next();
                        continue;
                    }
                    System.out.println("������ת�˵Ľ��");
                    Controller.transfer(account,accountIn,scanner.nextInt());
                    System.out.println("���������ַ�����");
                    scanner.next();
                    continue;
                case 5:
                    Controller.change(account);
                    System.out.println("���������ַ�����");
                    scanner.next();
                    continue;
                case 6:
                    break home;
                case 7:
                    Controller.logout(account);
                    System.out.println("���������ַ�����");
                    scanner.next();
                    break home;
                default:
                    System.out.println("û�д�ָ��");

            }
        }
    }
}