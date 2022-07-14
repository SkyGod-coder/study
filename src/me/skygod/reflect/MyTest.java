package me.skygod.reflect;

import java.util.Date;

public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        System.out.println(date.getTime());
        Thread.sleep(1000);
        date = new Date();
        System.out.println(date.getTime());
    }
}
