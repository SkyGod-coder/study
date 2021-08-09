package me.skygod.reflect;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*获取Class对象的三种方式*/
        Class cl1 = Class.forName("me.skygod.reflect.Person");
        Class cl2 = new Person().getClass();
        Class cl3 = Person.class;
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
    }
}
