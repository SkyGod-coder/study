package me.skygod.itheima.singleinstance;

/**
 * ��������ģʽ
 */
public class SingleInstance1 {
    public static SingleInstance1 instance;

    static {
        instance = new SingleInstance1();
    }

    private SingleInstance1() {
    }
}
