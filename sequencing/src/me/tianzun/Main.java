package me.tianzun;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",50);
        map.put("李四",100);
        map.put("王五",10);
        String[][] out = rank(map);
        for(String[] s : out){
            System.out.print(s[0]);
            System.out.println(":"+s[1]);
        }
    }
    private static String[][] rank(Map<String,Integer> map){
        String[][] out = new String[map.keySet().size()][2];
        int n = 0;
        //map的key和value存储到数组
        for(String s : map.keySet()){
            out[n][0] = s;
            out[n][1] = String.valueOf(map.get(s));
            n++;
        }
        Arrays.sort(out, (a,b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        return out;

    }
}