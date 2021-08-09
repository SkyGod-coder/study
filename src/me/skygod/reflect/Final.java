package me.skygod.reflect;

import java.lang.reflect.Method;
import java.util.Properties;

public class Final {
    public static void main(String[] args) throws Exception {
        //读取配置文件
        //创建properties对象
        Properties properties = new Properties();
        //加载配置文件
        properties.load(Final.class.getClassLoader().getResourceAsStream("config.properties"));
        //获取全类名和方法名
        String clsFull = properties.getProperty("class");
        String methodName = properties.getProperty("method");

        //加载类并执行方法
        //获取Class对象
        Class cls = Class.forName(clsFull);
        //创建对象
        Object obj = cls.newInstance();
        //根据方法名获取Method对象（忽略安全检查）
        Method method = cls.getDeclaredMethod(methodName);
        //暴力反射
        method.setAccessible(true);
        //指定对象执行方法
        method.invoke(obj);
    }
}
