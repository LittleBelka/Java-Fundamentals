package com.epam.littleBelka.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KeywordsJava {

    private ArrayList<String> keywordsJava = new ArrayList<String>();

    public void findKeywords(File file){

        if (file.exists()) {
            readFromFileKeywords();
            try (FileInputStream fileJava = new FileInputStream(file);
                FileOutputStream out = new FileOutputStream("ResultTask1.txt")){
                HashMap<String, Integer> keywords = new HashMap<>();
                int i;
                StringBuilder text = new StringBuilder();
                while ((i = fileJava.read()) != -1) {
                    text = text.append((char) i);
                }
                for (String o: keywordsJava) {
                    if (text.indexOf(o) != -1) {
                        while (text.indexOf(o) != -1) {
                            if (keywords.containsKey(o)) {
                                int count = keywords.get(o) + 1;
                                keywords.put(o, count);
                            } else {
                                keywords.put(o, 1);
                            }
                            text = text.delete(text.indexOf(o), text.indexOf(o) + o.length());
                        }
                    }
                }
                Iterator<Map.Entry<String, Integer>> iter = keywords.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Integer> entry = iter.next();
                    out.write(entry.getKey().getBytes());
                    out.write("    ".getBytes());
                    out.write(entry.getValue().toString().getBytes());
                    out.write("\r\n".getBytes());
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
