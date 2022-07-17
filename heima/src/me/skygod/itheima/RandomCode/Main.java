package me.skygod.itheima.RandomCode;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(createCode(10));
    }
    public static String createCode(int length){
        /*
        0~9
        10~35 +55 65~90 A~Z
        36~61 +61 97~122 a~z
         */
        Random random = new Random(System.currentTimeMillis());
        StringBuilder code = new StringBuilder();
        int j = 0;
        for (int i = 0; i < length; i++) {
            j = random.nextInt(62);
            if(j <= 9){
                code.append(j);
            }
            else if(j<=35){
                code.append((char)(j+55));
            }
            else{
                code.append((char)(j+61));
            }
        }
        return code.toString();
    }
}
