package me.skygod.reflect;

/**
 * ��ʾ
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

    /**
     * ���ˡ��� �ԡ� ����
     * @param food Ҫ�Ե�ʳ��
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
