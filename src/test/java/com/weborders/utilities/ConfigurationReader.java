package com.weborders.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();


    static {
        try(InputStream in = new FileInputStream("configuration.properties")){
            properties.load(in);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration.properties file");
        }
    }
    public static  String getProperty(String key){
        return  properties.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(getProperty("browser"));
    }
}
