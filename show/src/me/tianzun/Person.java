package me.tianzun;

public class Person {
    private Integer age = 0;
    private String sex = "";

    public Person(int age,String sex){
        this.age = age;
        this.sex = sex;
    }

    public void setAge(int age){
        this.age = age;
    }
    @Override
    public String toString() {
        return age + "," +sex;
    }
}