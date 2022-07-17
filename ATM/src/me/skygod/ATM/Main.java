package me.skygod.ATM;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static Scanner getScanner() {
        return scanner;
    }

    /**
     * main函数，初始界面
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("===ATM===");
            System.out.println("1.登陆");
            System.out.println("2.开户");
            //Fix：（第50行同）Scanner#nextInt()获取 --> 先将获取到的String解析为long，再截取为int，可避免误输入导致的崩溃
            int command = (int)Long.parseLong(scanner.next());
            switch (command) {
                case 1:
                    Controller.login();
                    continue;
                case 2:
                    Controller.creatAccount();
                    System.out.println("输入任意字符继续");
                    scanner.next();
                    continue;
                default:
                    System.out.println("没有这个指令");
            }
        }
    }

    /**
     * 用户中心
     * @param account 登入的用户（账户）
     */
    public static void home(Account account) {
        home:
        while (true) {
            System.out.println("===用户中心===");
            String[] commands = {"1.查询", "2.存款", "3.取款", "4.转账", "5.修改密码", "6.退出", "7.注销账户"};
            for (String s : commands) {
                System.out.println(s);
            }
            int command = (int)Long.parseLong(scanner.next());
            switch (command) {
                case 1:
                    System.out.println(account);
                    System.out.println("输入任意字符继续");
                    scanner.next();
                    continue;
                case 2:
                    System.out.println("请输入要存款的金额");
                    Controller.save(account,scanner.nextInt());
                    System.out.println("输入任意字符继续");
                    scanner.next();
                    continue;
                case 3:
                    System.out.println("请输入要取款的金额");
                    Controller.withdraw(account,scanner.nextInt());
                    System.out.println("输入任意字符继续");
                    scanner.next();
                    continue;
                case 4:
                    System.out.println("请输入对方的卡号");
                    String number = scanner.next();
                    if(number.equalsIgnoreCase(String.valueOf(account.getNumber()))){
                        System.out.println("不能给自己转账\n输入任意字符继续");
                        scanner.next();
                        continue;
                    }
                    Account accountIn = Controller.getAccount(number);
                    if(accountIn == null){
                        System.out.println("无效的卡号");
                        continue;
                    }
                    String nameIn = accountIn.getName();
                    System.out.println("请输入对方的姓[*" + nameIn.substring(1) + "]");
                    String lastname = scanner.next();
                    if(!nameIn.startsWith(lastname)){
                        System.out.println("验证失败\n输入任意字符继续");
                        scanner.next();
                        continue;
                    }
                    System.out.println("请输入转账的金额");
                    Controller.transfer(account,accountIn,scanner.nextInt());
                    System.out.println("输入任意字符继续");
                    scanner.next();
                    continue;
                case 5:
                    Controller.change(account);
                    System.out.println("输入任意字符继续");
                    scanner.next();
                    continue;
                case 6:
                    break home;
                case 7:
                    Controller.logout(account);
                    System.out.println("输入任意字符继续");
                    scanner.next();
                    continue;
                default:
                    System.out.println("没有此指令");

            }
        }
    }
}
