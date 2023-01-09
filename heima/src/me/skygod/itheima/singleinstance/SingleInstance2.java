package me.skygod.itheima.singleinstance;

public class SingleInstance2 {
    private static SingleInstance2 instance;

    private SingleInstance2() {
    }

    public static SingleInstance2 getInstance() {
        if (instance == null) instance = new SingleInstance2();
        return instance;
    }
}
