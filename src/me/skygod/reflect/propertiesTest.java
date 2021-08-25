package me.skygod.reflect;

import java.io.IOException;
import java.util.Properties;

public class propertiesTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(propertiesTest.class.getClassLoader().getResourceAsStream("config.properties"));
        String string = properties.getProperty("class");
        System.out.println(string);
    }

}
