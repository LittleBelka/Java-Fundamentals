package com.epam.littleBelka.task2;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class ReadPropertiesFile {

    public HashMap<String, String> readProperties (File file) throws FileNotFoundException, KeyPropertiesExceptions {

        if (file != null) {
            if (file.exists()) {
                try (InputStream in = new FileInputStream(file)) {
                    HashMap<String, String> map = new HashMap<>();
                    Properties prop = new Properties();
                    prop.load(in);
                    for (String p : prop.stringPropertyNames()) {
                        if (p.equals("")) {
                            throw new KeyPropertiesExceptions("Key not found");
                        } else {
                            String value = prop.getProperty(p);
                            map.put(p, prop.getProperty(p));
                        }
                    }
                    return map;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw new FileNotFoundException();
            }
        } else {
            throw new NullPointerException();
        }
        return  null;
    }
}
