package me.skygod.itheima.classload;

public class Main {
    static {
        System.out.println("Main�ྲ̬�����");
    }

    {
        System.out.println("Main�ද̬�����");
    }

    public static void main(String[] args) {
        System.out.println("start");
        new Person();
    }
}
