package com.epam.littleBelka.task1;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.TreeMap;

public class ScanDirectory {

    private File directory;      // the source folder
    private TreeMap<String, Boolean> directoryMap = new TreeMap<>();

    public ScanDirectory (File file) {
        directory = file;
        scan(directory);
    }

    public TreeMap<String, Boolean> getListFiles () {
        return directoryMap;
    }

    /**
     * This method records all files in TreeMap
     * @param path the path to the file
     */
    private void scan(File path){

        File[] list = path.listFiles();
        if (list == null) {
            return;
        }
        for (File f : list) {
            boolean bol = f.isDirectory();
            directoryMap.put(f.getPath(), bol);
            if (bol) {
                scan(f);
            }
        }
    }

    public void createFile (File file) throws FileAlreadyExistsException {

        if (file != null) {
            if (!file.exists()) {
                String path = file.getPath();
                int index = path.indexOf(File.separator);
                if (path.substring(0, index).equals(directory.getPath())) {

                    index = path.indexOf(File.separator, index + 1);
                    while (index != -1 && index != path.length() - 1) {
                        String str = path.substring(0, index + 1);
                        File newFile = new File(str);
                        if (!newFile.exists()) {
                            newFile.mkdir();
                        }
                        index = path.indexOf(File.separator, index + 1);
                    }
                    boolean dir = path.contains(".");
                    if (!dir) {
                        directoryMap.put(path, true);
                        file.mkdir();
                    } else {
                        directoryMap.put(path, false);
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                throw new FileAlreadyExistsException(file.getPath());
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void recordFile(File file, String str) throws FileNotFoundException {

        if (file != null || str != null) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    try (PrintWriter writer = new PrintWriter(new FileWriter(file.getPath(), true))) {
                        writer.write(str + System.lineSeparator());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                throw new FileNotFoundException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void deleteFile (File file) {
        if (file != null) {
            if (directoryMap.containsKey(file.getPath())) {
                if (file.isDirectory()) {
                    for (File inFile : file.listFiles()) {
                        deleteFile(inFile);
                    }
                }
                directoryMap.remove(file.getPath());
                file.delete();
            }
        } else {
            throw new NullPointerException();
        }
    }

}
