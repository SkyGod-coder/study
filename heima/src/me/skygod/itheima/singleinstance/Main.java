package me.skygod.itheima.singleinstance;

public class Main {
    public static void main(String[] args) {
        SingleInstance1 instance1_1 = SingleInstance1.instance;
        SingleInstance1 instance1_2 = SingleInstance1.instance;
        System.out.println(instance1_1 == instance1_2);
        SingleInstance2 instance2_1 = SingleInstance2.getInstance();
        SingleInstance2 instance2_2 = SingleInstance2.getInstance();
        System.out.println(instance2_1 == instance2_2);
    }
}
