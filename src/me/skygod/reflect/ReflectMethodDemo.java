package me.skygod.reflect;

import java.lang.reflect.Method;

public class ReflectMethodDemo {
    public static void main(String[] args) throws Exception {
        Class cls = Person.class;
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("==============");
        Person person = new Person();
        Method eat = cls.getDeclaredMethod("eat",String.class);
        eat.setAccessible(true);
        eat.invoke(person,"breakfast");
    }
}
