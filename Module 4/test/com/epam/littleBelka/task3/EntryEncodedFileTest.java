package com.epam.littleBelka.task3;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class EntryEncodedFileTest {

    @Test
    public void testReadAndWriter() throws Exception {

        EntryEncodedFile entry = new EntryEncodedFile();
        File file1 = new File("test.html");
        entry.readAndWriter(file1);
        File file2 = new File("Task3UTF-16.html");
        if (file2.exists()) {
            try (Reader reader1 = new InputStreamReader(new FileInputStream(file1),"UTF-8");
                 Reader reader2 = new InputStreamReader(new FileInputStream(file2),"UTF-16")) {
                int i;
                int j;
                while ((i = reader1.read()) != -1) {
                    char ch1 = (char) i;
                    j = reader2.read();
                    if (j == -1) {
                        Assert.fail();
                    } else {
                        char ch2 = (char) j;
                        if (ch2 != ch1) {
                            Assert.fail();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Assert.fail();
        }
    }
}