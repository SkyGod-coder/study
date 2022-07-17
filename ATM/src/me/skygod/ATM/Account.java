package me.skygod.ATM;

import java.util.ArrayList;

/**
 * 账户对象
 */
public class Account {
    private final String name;
    private final long number;
    private String password;
    private int money;
    private final int limit;

    private final ArrayList<String> log = new ArrayList<>();

    public Account(String name, long number, String password, int limit) {
        this.name = name;
        this.number = number;
        this.password = password;
        this.limit = limit;
    }

    /**
     * 便于“查询”操作时调用
     *
     * @return 账户的详细信息
     */
    @Override
    public String toString() {
        StringBuilder logStringBuilder = new StringBuilder();
        for (String log : this.log){
            logStringBuilder.append(log).append("\n");
        }
        String logString = logStringBuilder.toString();
        return "===ATM===" + "\n" +
                "您好," + name + ",您的账户当前信息如下" + "\n" +
                "余额:" + money + "\n" +
                "单次限额:" + limit + "\n" +
                "===操作记录===" + "\n" +
                logString;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney() {
        return money;
    }

    public int getLimit() {
        return limit;
    }

    public ArrayList<String> getLog() {
        return log;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}