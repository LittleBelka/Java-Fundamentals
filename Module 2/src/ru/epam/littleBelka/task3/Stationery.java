package ru.epam.littleBelka.task3;

public abstract class Stationery {

    public int getCost(String nameStationery) {

        int cost = -1;
        switch (nameStationery) {
            case "Pen": cost = 10;
                break;
            case "Pencil": cost = 7;
                break;
            case "Paper": cost = 2;
                break;
            case "Stapler": cost = 30;
                break;
            case "Glue": cost = 15;
                break;
        }
        return cost;
    }

    public abstract int cost();

    public abstract String getBrandName();

    public abstract String getNameStationery();

}
