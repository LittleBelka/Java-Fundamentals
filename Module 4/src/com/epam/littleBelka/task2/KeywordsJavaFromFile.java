package com.epam.littleBelka.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KeywordsJavaFromFile {

    private ArrayList<String> keywordsJava = new ArrayList<String>();

    public void findKeywords(File file) throws FileNotFoundException {

        if (file.exists()) {
            readFromFileKeywords();
            try (BufferedReader reader = new BufferedReader(new FileReader(file));
                 PrintWriter writer = new PrintWriter(new FileWriter("ResultTask2.txt"))) {
                HashMap<String, Integer> keywords = new HashMap<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    for (String o:keywordsJava) {
                        if (line.contains(o)) {
                            if (keywords.containsKey(o)) {
                                int count = keywords.get(o) + 1;
                                keywords.put(o, count);
                            } else {
                                keywords.put(o, 1);
                            }
                        }
                    }
                }
                Iterator<Map.Entry<String, Integer>> iter = keywords.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Integer> entry = iter.next();
                    writer.print(entry.getKey() + "   " + entry.getValue() + "\r\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readFromFileKeywords() {

        try (BufferedReader reader = new BufferedReader(new FileReader("Keywords Java.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                keywordsJava.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
