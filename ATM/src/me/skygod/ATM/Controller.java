package me.skygod.ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    /**
     * 存储所有的账户对象
     */
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static final Scanner scanner = Main.getScanner();

    /**
     * 重复查询
     *
     * @param name 姓名
     * @return 同一人是否重复开户, 是为true, 否为false
     */
    private static Boolean containName(String name) {
        for (Account account : accounts) {
            if (name.equalsIgnoreCase(account.getName())) return true;
        }
        return false;
    }

    /**
     * 开户
     */
    public static void creatAccount() {
        while (true) {
            System.out.println("===开户===");
            System.out.println("请输入姓名；(键入exit可退出注册界面)");
            String name = scanner.next();
            if (name.equalsIgnoreCase("exit")) break;
            if (containName(name)) {
                System.out.println("您的名下已经有一个账户了");
                continue;
            }
            System.out.println("请输入密码:");
            String password = scanner.next();
            System.out.println("请确认密码:");
            String confirmPassword = scanner.next();
            if (!confirmPassword.equalsIgnoreCase(password)) {
                System.out.println("两次输入的密码不一致");
                continue;
            }
            System.out.println("输入此账户的单次取款限额:");
            long number = System.currentTimeMillis();
            accounts.add(new Account(name, number, password, scanner.nextInt()));
            System.out.println("===开户完成===");
            System.out.println("请记住您的卡号:" + number);
            break;
        }
    }

    /**
     * 根据卡号获取账户
     *
     * @param number 卡号
     * @return 有则返回Account，没有则返回null
     */
    public static Account getAccount(String number) {
        for (Account account : accounts) {
            if (number.equalsIgnoreCase(String.valueOf(account.getNumber()))) return account;
        }
        return null;
    }

    /**
     * 登陆
     */
    public static void login() {
        System.out.println("===登陆===");
        Account account;
        while (true) {
            System.out.println("请输入卡号:(输入exit退出登陆界面)");
            String number = scanner.next();
            if (number.equalsIgnoreCase("exit")) return;
            account = getAccount(number);
            if (account == null) {
                System.out.println("无效的卡号");
                continue;
            }
            System.out.println("请输入密码:");
            String password = scanner.next();
            if (!account.getPassword().equalsIgnoreCase(password)){
                System.out.println("密码错误");
                continue;
            }
            System.out.println("===登陆完成===");
            break;
        }
        Main.home(account);
    }

    /**
     * 向account中存入money元
     *
     * @param account 账户对象
     * @param money   金额
     */
    public static void save(Account account, int money) {
        int newMoney = account.getMoney() + money;
        account.setMoney(newMoney);
        String message = "存入" + money + "元。" + "存入后账户中有" + newMoney + "元";
        account.getLog().add(message);
        System.out.println(message);
    }

    /**
     * 从account中取款money元
     * @param account 账户
     * @param money 金额
     */
    public static void withdraw(Account account, int money){
        if(money > account.getLimit()){
            System.out.println("超过了单次取款限额");
            return;
        }
        int moneyAccount = account.getMoney();
        if(money > moneyAccount){
            System.out.println("余额不足");
        }else{
            int newMoney = moneyAccount - money;
            account.setMoney(newMoney);
            String message = "取款" + money + "完毕。" + "取款后账户中有" + newMoney + "元";
            account.getLog().add(message);
            System.out.println(message);
        }
    }

    /**
     * 从accountOut中转账money元到accountIn
     *
     * @param accountOut 转出账户
     * @param accountIn  转入账户
     * @param money      转账金额
     */
    public static void transfer(Account accountOut, Account accountIn, int money) {
        int newMoney = accountOut.getMoney() - money;
        if(newMoney < 0){
            System.out.println("余额不足");
        }else {
            accountOut.setMoney(newMoney);
            accountIn.setMoney(accountIn.getMoney() + money);
            String message = "成功给" + accountIn.getNumber() + "转账" + money + "元。" + "转账后账户中有" + newMoney + "元";
            System.out.println(message);
            accountOut.getLog().add(message);
        }
    }

    /**
     * 修改密码
     * @param account 欲修改密码的账户
     */
    public static void change(Account account){
        if (!verifyPassword(account)) return;
        System.out.println("请输入新的密码:");
        String password = scanner.next();
        account.setPassword(password);
        System.out.println("修改成功");
    }

    /**
     * 注销
     *
     * @param account 欲注销的账户
     */
    public static void logout(Account account) {
        if (!verifyPassword(account)) return;
        accounts.remove(account);
        System.out.println("注销成功");
    }

    /**
     * 验证密码
     *
     * @param account 账户
     * @return 如果输入了正确的密码，则返回true，否则返回false
     */
    private static Boolean verifyPassword(Account account) {
        System.out.println("输入密码以确认:");
        String password = scanner.next();
        String oldPassword = account.getPassword();
        if (!password.equalsIgnoreCase(oldPassword)) {
            System.out.println("密码错误");
            return false;
        }
        return true;
    }
}