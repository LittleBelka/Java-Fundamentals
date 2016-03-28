package com.epam.littleBelka.task2;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class KeywordsJavaFromFileTest {

    @Test
    public void testFindKeywords() throws Exception {

        KeywordsJavaFromFile key = new KeywordsJavaFromFile();
        File file = new File("CrazyLogger.java");
        key.findKeywords(file);
        File file1 = new File("ResultTask2.txt");
        if (file1.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file1));) {
                HashMap<String, Integer> keywords = new HashMap<>();
                keywords.put("new", 8);
                keywords.put("private", 1);
                keywords.put("package", 1);
                keywords.put("void", 1);
                keywords.put("import", 5);
                keywords.put("for", 7);
                keywords.put("while", 2);
                keywords.put("int", 4);
                keywords.put("long", 1);
                keywords.put("boolean", 2);
                keywords.put("try", 2);
                keywords.put("public", 5);
                keywords.put("else", 2);
                keywords.put("catch", 2);
                keywords.put("if", 7);
                keywords.put("class", 1);
                keywords.put("return", 7);
                String line;
                while ((line = reader.readLine()) != null) {
                    boolean bol = false;
                    for (String o:keywords.keySet()) {
                        if (line.contains(o) && keywords.get(o) != 0) {
                            if (Integer.parseInt(line.substring(line.indexOf(o) + o.length() + 1, line.length()).replace(" ", "")) == keywords.get(o)) {
                                keywords.put(o, 0);
                                bol = true;
                            } else {
                                Assert.fail();
                            }
                        }
                    }
                    if (!bol) {
                        Assert.fail();
                    }
                }
            } catch (IOException e) {
                Assert.fail();
            }
        } else {
            Assert.fail();
        }
    }

}