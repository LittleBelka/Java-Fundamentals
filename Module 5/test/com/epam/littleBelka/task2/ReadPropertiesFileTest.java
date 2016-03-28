package com.epam.littleBelka.task2;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class ReadPropertiesFileTest {

    @Test(expected = NullPointerException.class)
    public void testReadPropertiesNull() throws Exception {
        ReadPropertiesFile prop = new ReadPropertiesFile();
        prop.readProperties(null);
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadPropertiesNotExist() throws Exception {
        ReadPropertiesFile prop = new ReadPropertiesFile();
        File file = new File("example.properties");
        prop.readProperties(file);
    }

    @Test
    public void testReadProperties() throws Exception {
        ReadPropertiesFile prop = new ReadPropertiesFile();
        File file = new File("test.properties");
        HashMap<String, String> map = new HashMap<>();
        map.put("cheerful", "funny");
        map.put("sad", "cheerless");
        map.put("sensitive", "responsive");
        map.put("big", "great");
        try (OutputStream out = new FileOutputStream(file)) {
            Properties properties = new Properties();
            for (String o: map.keySet()) {
                properties.setProperty(o, map.get(o));
            }
            properties.store(out, "synonyms");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, String> map2 = prop.readProperties(file);
        Assert.assertTrue(map.equals(map2));

    }

    @Test(expected = KeyPropertiesExceptions.class)
    public void testReadPropertiesWithKey() throws Exception {
        ReadPropertiesFile prop = new ReadPropertiesFile();
        File file = new File("test.properties");
        HashMap<String, String> map = new HashMap<>();
        map.put("cheerful", "funny");
        map.put("sad", "cheerless");
        map.put("", "responsive");
        map.put("big", "great");
        try (OutputStream out = new FileOutputStream(file)) {
            Properties properties = new Properties();
            for (String o: map.keySet()) {
                properties.setProperty(o, map.get(o));
            }
            properties.store(out, "synonyms");
        } catch (IOException e) {
            e.printStackTrace();
        }
        prop.readProperties(file);
    }
}