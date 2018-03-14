package com.example;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Configuration {

    public Map<String, String> getProperties() {
        Map<String, String> map = new HashMap<>();
        try {
            Properties p = new Properties();
            String file = "/etc/config/archivo.properties";
            p.load(new FileReader(file));
            for (String key : p.stringPropertyNames()) {
                String value = p.getProperty(key);
                map.put(key, value);
            }
        } catch (Exception e) {
            // Return default values
            map.put("nombre","OpenShift");
            map.put("saludo","hola!");
            map.put("mensaje","Esto es HelloWorld!");
        }
        return map;
    }
}
