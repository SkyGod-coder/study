package me.skygod.ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    /**
     * �洢���е��˻�����
     */
    private static final ArrayList<Account> accounts = new ArrayList<>();
    private static final Scanner scanner = Main.getScanner();

    /**
     * �ظ���ѯ
     *
     * @param name ����
     * @return ͬһ���Ƿ��ظ�����, ��Ϊtrue, ��Ϊfalse
     */
    private static Boolean containName(String name) {
        for (Account account : accounts) {
            if (name.equalsIgnoreCase(account.getName())) return true;
        }
        return false;
    }

    /**
     * ����
     */
    public static void creatAccount() {
        while (true) {
            System.out.println("===����===");
            System.out.println("������������(����exit���˳�ע�����)");
            String name = scanner.next();
            if (name.equalsIgnoreCase("exit")) break;
            if (containName(name)) {
                System.out.println("���������Ѿ���һ���˻���");
                continue;
            }
            System.out.println("����������:");
            String password = scanner.next();
            System.out.println("��ȷ������:");
            String confirmPassword = scanner.next();
            if (!confirmPassword.equalsIgnoreCase(password)) {
                System.out.println("������������벻һ��");
                continue;
            }
            System.out.println("������˻��ĵ���ȡ���޶�:");
            long number = System.currentTimeMillis();
            accounts.add(new Account(name, number, password, scanner.nextInt()));
            System.out.println("===�������===");
            System.out.println("���ס���Ŀ���:" + number);
            break;
        }
    }

    /**
     * ���ݿ��Ż�ȡ�˻�
     *
     * @param number ����
     * @return ���򷵻�Account��û���򷵻�null
     */
    public static Account getAccount(String number) {
        for (Account account : accounts) {
            if (number.equalsIgnoreCase(String.valueOf(account.getNumber()))) return account;
        }
        return null;
    }

    /**
     * ��½
     */
    public static void login() {
        System.out.println("===��½===");
        Account account;
        while (true) {
            System.out.println("�����뿨��:(����exit�˳���½����)");
            String number = scanner.next();
            if (number.equalsIgnoreCase("exit")) return;
            account = getAccount(number);
            if (account == null) {
                System.out.println("��Ч�Ŀ���");
                continue;
            }
            System.out.println("����������:");
            String password = scanner.next();
            if (!account.getPassword().equalsIgnoreCase(password)){
                System.out.println("�������");
                continue;
            }
            System.out.println("===��½���===");
            break;
        }
        Main.home(account);
    }

    /**
     * ��account�д���moneyԪ
     *
     * @param account �˻�����
     * @param money   ���
     */
    public static void save(Account account, int money) {
        int newMoney = account.getMoney() + money;
        account.setMoney(newMoney);
        String message = "����" + money + "Ԫ��" + "������˻�����" + newMoney + "Ԫ";
        account.getLog().add(message);
        System.out.println(message);
    }

    /**
     * ��account��ȡ��moneyԪ
     * @param account �˻�
     * @param money ���
     */
    public static void withdraw(Account account, int money){
        if(money > account.getLimit()){
            System.out.println("�����˵���ȡ���޶�");
            return;
        }
        int moneyAccount = account.getMoney();
        if(money > moneyAccount){
            System.out.println("����");
        }else{
            int newMoney = moneyAccount - money;
            account.setMoney(newMoney);
            String message = "ȡ��" + money + "��ϡ�" + "ȡ����˻�����" + newMoney + "Ԫ";
            account.getLog().add(message);
            System.out.println(message);
        }
    }

    /**
     * ��accountOut��ת��moneyԪ��accountIn
     *
     * @param accountOut ת���˻�
     * @param accountIn  ת���˻�
     * @param money      ת�˽��
     */
    public static void transfer(Account accountOut, Account accountIn, int money) {
        int newMoney = accountOut.getMoney() - money;
        if(newMoney < 0){
            System.out.println("����");
        }else {
            accountOut.setMoney(newMoney);
            accountIn.setMoney(accountIn.getMoney() + money);
            String message = "�ɹ���" + accountIn.getNumber() + "ת��" + money + "Ԫ��" + "ת�˺��˻�����" + newMoney + "Ԫ";
            System.out.println(message);
            accountOut.getLog().add(message);
        }
    }

    /**
     * �޸�����
     * @param account ���޸�������˻�
     */
    public static void change(Account account){
        if (!verifyPassword(account)) return;
        System.out.println("�������µ�����:");
        String password = scanner.next();
        account.setPassword(password);
        System.out.println("�޸ĳɹ�");
    }

    /**
     * ע��
     *
     * @param account ��ע�����˻�
     */
    public static void logout(Account account) {
        if (!verifyPassword(account)) return;
        accounts.remove(account);
        System.out.println("ע���ɹ�");
    }

    /**
     * ��֤����
     *
     * @param account �˻�
     * @return �����������ȷ�����룬�򷵻�true�����򷵻�false
     */
    private static Boolean verifyPassword(Account account) {
        System.out.println("����������ȷ��:");
        String password = scanner.next();
        String oldPassword = account.getPassword();
        if (!password.equalsIgnoreCase(oldPassword)) {
            System.out.println("�������");
            return false;
        }
        return true;
    }
}