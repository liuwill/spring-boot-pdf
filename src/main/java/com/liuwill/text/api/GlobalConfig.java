package com.liuwill.text.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalConfig {
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
            InputStream in = ClassLoader.getSystemResourceAsStream("config/form.properties");
            theProps.load(in);
        } catch (IOException e) {
            return null;
        }
        return theProps;
    }
}
