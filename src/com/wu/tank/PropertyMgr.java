package com.wu.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private static Properties propertyMgr = new Properties() ;
    static {
        try {
            propertyMgr.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if(propertyMgr==null){
            return null;
        }
        System.out.println(propertyMgr.getProperty(key));
        return propertyMgr.getProperty(key);
    }
}
