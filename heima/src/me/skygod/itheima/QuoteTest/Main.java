package me.skygod.itheima.QuoteTest;

import java.util.Objects;

public class Main{
    public static void main(String[] args) {
        String a = new String("777");
        String b = a;
        a = new String("777");
        System.out.println(a == b);
        MyString x = new MyString("777");
        MyString y = x;
        x.set("666");
        System.out.println(x);
        System.out.println(y);
    }

    static class MyString{
        private String s = "";
        public MyString(String s){
            this.s = s;
        }
        public void set(String s){
            this.s = s;
        }
        public String get(){
            return s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyString)) return false;
            MyString myString = (MyString) o;
            return Objects.equals(s, myString.get());
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }

        @Override
        public String toString() {
            return "MyString{" +
                    "s='" + s + '\'' +
                    '}';
        }
    }
}
