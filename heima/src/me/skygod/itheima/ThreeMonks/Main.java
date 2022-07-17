package me.skygod.itheima.ThreeMonks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {scanner.nextInt(),scanner.nextInt(),scanner.nextInt()};
        scanner.close();
        System.out.println("最大值为: " + Max.getMax(nums));
    }
}
