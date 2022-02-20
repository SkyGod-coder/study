package me.skygod.itheima.studyLabel;

public class Main {
    public static void main(String[] args) {
        // continue跳出本次循环，继续Label循环
        // break结束Label循环
         //Label
        start:
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                continue start;
            }
        }
    }
}
