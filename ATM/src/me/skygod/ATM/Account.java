package me.skygod.ATM;

import java.util.ArrayList;

/**
 * �˻�����
 */
public class Account {
    private String name;
    private long number;
    private String password;
    private int money;
    private int limit;

    private ArrayList<String> log = new ArrayList<>();
    public Account(String name,long number,String password,int limit){
        this.name = name;
        this.number = number;
        this.password =password;
        this.limit = limit;
    }

    /**
     * ���ڡ���ѯ������ʱ����
     * @return
     */
    @Override
    public String toString() {
        StringBuilder logStringBuilder = new StringBuilder();
        for (String log : this.log){
            logStringBuilder.append(log + "\n");
        }
        String logString = logStringBuilder.toString();
        return "===ATM===" + "\n" +
                "����," + name + ",�����˻���ǰ��Ϣ����" + "\n" +
                "���:" + money + "\n" +
                "�����޶�:" + limit + "\n" +
                "===������¼===" + "\n" +
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

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setLog(ArrayList<String> log) {
        this.log = log;
    }

}