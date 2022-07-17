package me.skygod.itheima.scannerStudy;

import java.util.Scanner;

public class scannerStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer i = scanner.nextInt();
        scanner.close();
        System.out.println(i);
    }
}
