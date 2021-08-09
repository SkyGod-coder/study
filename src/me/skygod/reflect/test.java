package me.skygod.reflect;

public class test {
    public static void main(String[] args) {
        System.out.println(test.class.getClassLoader().getResource("config.properties"));
    }
}
