package me.skygod.reflect;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        //获取所有*public*修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("------------------");
        //根据变量名获取（仅限public）
        Field a = personClass.getField("a");
        System.out.println(a);
        System.out.println("------------------");
        Person person = new Person();
        //获取一个成员变量在一个实例中的值
        Object value = a.get(person);
        System.out.println(value);
        //设置一个成员变量在一个实例中的值
        a.set(person ,"张三");
        System.out.println(person);
        System.out.println("==================");
        //declared,获取所有成员变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("------------------");
        //尝试访问private修饰的成员变量在一实例中的值
        Field name = personClass.getDeclaredField("name");
        //忽略访问权限修饰符的安全检查
        name.setAccessible(true);//暴力反射
        Object nameValue = name.get(person);
        System.out.println(nameValue);
        System.out.println(person);
    }
}
