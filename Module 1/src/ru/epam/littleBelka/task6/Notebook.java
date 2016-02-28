package ru.epam.littleBelka.task6;

import java.util.Arrays;

/**
 * This class is designed to work with entries in a notebook.
 */
public class Notebook {

    private int n;
    private String[] entry;

    /**
     * This constructor is designed to initialize the array entries.
     * @param n the size of the array entries
     */
    public Notebook(int n) {
        entry = new String[n];
    }

    /**
     * This method increases the length of the array.
     * @param capacity the new length of the array
     */
    private void changeCapacity(int capacity) {
        String[] copy = Arrays.copyOf(entry, capacity);
        entry = copy;
    }

    /**
     * This method changes the value of an array by key.
     * @param key is entry number
     * @param newEntry is new entry
     */
    public void setEntry(int key, String newEntry) {
        if (newEntry != null && key >= 0 && key < n) {
            entry[key] = newEntry;
        }
    }

    /**
     * This method adds a new entry in the array.
     * @param newEntry is new entry
     */
    public void addEntry(String newEntry) {
        if (newEntry != null) {
            if (entry.length == n) {
                changeCapacity(2 * entry.length);
            }
            entry[n] = newEntry;
            n++;
        }
    }

    /**
     * This method returns the number of the entry.
     * @param str record whose number need to know
     * @return the number of the entry
     */
    public int getKey(String str) {
        if (str != null) {
            for (int i = 0; i < n; i++) {
                if (entry[i].equals(str)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * This method removes the entry for the key.
     * @param key is the number of deleted entry
     */
    public void removeEntry(int key) {
        if (key >= 0 && key < n) {
            entry[key] = entry[n-1];
            entry[n-1] = null;
            n--;
        }
    }

    /**
     * This method prints all entries from the array.
     */
    public void getAllEntries() {
        for(String o: entry) {
            System.out.println(o);
        }
    }
}
