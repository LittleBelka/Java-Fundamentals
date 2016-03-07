package ru.epam.littleBelka.task2;

import java.util.Arrays;

public class Stationery {

    private int n;
    private String[] stationery;
    private int[] count;

    public Stationery() {
        stationery = new String[1];
        count = new int[1];
        count[0] = 0;
    }

    private int getCostStationery(String nameStationery) {
        int cost = -1;
        switch (nameStationery) {
            case "Pen": cost = 10;
                break;
            case "Pencil": cost = 7;
                break;
            case "Paper": cost = 2;
                break;
            case "Stapler": cost = 25;
                break;
            case "Glue": cost = 15;
                break;
        }
        return cost;
    }

    private void changeCapacity(int capacity) {
        String[] copy = Arrays.copyOf(stationery, capacity);
        stationery = copy;
        int[] copyCount = Arrays.copyOf(count, capacity);
        count = copyCount;
    }

    public void addStationery(String newStationery) {
        if (newStationery != null) {
            int index = Arrays.asList(stationery).indexOf(newStationery);
            if (index != -1) {
                count[index]++;
            }
            if (index == -1) {
                if (stationery.length == n) {
                    changeCapacity(2 * stationery.length);
                }
                stationery[n] = newStationery;
                count[n] = 1;
                n++;
            }
        }
    }

    public int getCountStationery(String nameStationery) {

        int index = Arrays.asList(stationery).indexOf(nameStationery);
        if (index != -1) {
            return count[index];
        }
        return 0;
    }

    public int getCostAllStationery() {

        int costStationery = 0;
        if (stationery[0] != null) {
            for (int i = 0; i < n; i++) {
                int cost = getCostStationery(stationery[i]);
                costStationery = costStationery + count[i] * cost;
            }
        }
        return costStationery;
    }

}
