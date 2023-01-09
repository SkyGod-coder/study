package me.skygod.itheima.permission;

public class Father {
    private Father() {
        System.out.println("Father");
    }

    Father(String name) {
        System.out.println("Father" + name);
    }
}
