package com.liuwill.text.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/8/19 0019.
 */
public class ConfigReader {

    private static Properties theProps = null;
    public static String readProperty(String propertyName){
        if(theProps == null){
            theProps = loadProperties();
        }

        assert theProps != null;
        return theProps.getProperty(propertyName);
    }

    private static Properties loadProperties(){
        Properties theProps = new Properties();
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream("config/files.properties");
            theProps.load(in);
        } catch (IOException e) {
            return null;
        }
        return theProps;
    }
}
