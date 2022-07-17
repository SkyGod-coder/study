package me.skygod.itheima.RandomCode;

import java.util.Scanner;

public class CharToInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String input = scanner.next();
            if(input.equalsIgnoreCase("stop")){
                break;
            }
            System.out.println((int)input.charAt(0));
        }

    }
}
