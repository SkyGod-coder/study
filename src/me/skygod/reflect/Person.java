package me.skygod.reflect;

import java.util.Objects;

/**
 * 演示
 *
 * @since 1.5
 * @version 1.0
 * @author SkyGod
 */
public class Person {
    private String name;
    private int age;

    public String b;
    public String a;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void eat(){
        System.out.println("eat...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(b, person.b) &&
                Objects.equals(a, person.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), b, a);
    }

    /**
     * “人“” 吃” 方法
     * @param food 要吃的食物
     */
    private void eat(String food){
        System.out.println("eat " + food);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", b='" + b + '\'' +
                ", a='" + a + '\'' +
                '}';
    }
}
