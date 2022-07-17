package me.skygod.reflect;

import java.util.ArrayList;

public class TypeStudy {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三"));
        System.out.println(list);
        System.out.println(list.remove(new Person("张三")));
        System.out.println(list);
    }
}
