package com.itacademy.utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.StringUtils;
import com.itacademy.enums.Capability;
import com.itacademy.enums.PropertyFile;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(PropertyFile propertyFile,Capability capability) {
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader("src/main/resources/" + propertyFile.getPathToFile());
            properties.load(fileReader);
        } catch (IOException e) {
            System.out.println("Properties are not loaded. Чет не так)");
        }
        for (Object key : properties.keySet()) {
            String systemValue = System.getProperty((String) key);
            if (!StringUtils.isEmpty(systemValue)) {
                properties.put(key, systemValue);
            }
        }
        return properties.getProperty(capability.getKey(), capability.getDefaultValue());
    }

    public static String getConfigProperty(Capability capability) {
    return getProperty(PropertyFile.CONFIG,capability);
    }
}
