package com.epam.littleBelka.task1;

import org.junit.*;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.TreeMap;

public class ScanDirectoryTest {

    static ScanDirectory scan = new ScanDirectory(new File("files1")); // folder in which there will be changes:
                                                                        // creating, deleting, recording files
    @AfterClass
    public static void testDeleteFile () {
        TreeMap<String, Boolean> list = scan.getListFiles();
        File file = new File("files1\\Новая папка");
        scan.deleteFile(file);
        TreeMap<String, Boolean> listAfterDelete = scan.getListFiles();
        for (String o: listAfterDelete.keySet()) {
            if (o.contains(file.getPath())) {
                Assert.fail();
            }
        }
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteFileNull () {
        scan.deleteFile(null);
    }

    @Test(expected = FileAlreadyExistsException.class)
    public void testCreateFileExist () throws FileAlreadyExistsException {
        File file = new File("files1\\Новая папка (2)");
        scan.createFile(file);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateFileNull () throws FileAlreadyExistsException {
        scan.createFile(null);
    }

    @Test
    @Before
    public void testCreateFile (){
        File file = new File("files1\\Новая папка (2)\\katya.txt");
        try {
            scan.createFile(file);
        } catch (FileAlreadyExistsException ignore) {}
        if (!file.exists()) {
            Assert.fail();
        }
    }

    @Test(expected = FileNotFoundException.class)
    public void testRecordFileNotExist () throws FileNotFoundException {
        File file = new File("files1\\TTTTTTTTT.txt");
        String str = "information";
        scan.recordFile(file, str);
    }

    @Test(expected = NullPointerException.class)
    public void testRecordFileNull () throws FileNotFoundException {
        String str = "information";
        scan.recordFile(null, str);
    }

    @Test
    public void testRecordFile (){
        File file = new File("files1\\Новая папка (2)\\katya.txt");
        String str = "information";
        try {
            scan.recordFile(file, str);
        } catch (FileNotFoundException e) {
            Assert.fail();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean bol = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals(str)) {
                    bol = true;
                }
            }
            if (!bol) {
                Assert.fail();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}