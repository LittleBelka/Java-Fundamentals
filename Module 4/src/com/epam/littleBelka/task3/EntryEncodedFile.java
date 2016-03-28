package com.epam.littleBelka.task3;

import java.io.*;

public class EntryEncodedFile {

    public void readAndWriter(File file) {
        try (Reader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
             Writer writer = new OutputStreamWriter(new FileOutputStream("Task3UTF-16.html", true), "UTF-16")) {
            int i;
            while ((i = reader.read()) != -1) {
                writer.write((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
