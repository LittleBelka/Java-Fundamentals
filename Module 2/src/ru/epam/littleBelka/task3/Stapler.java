package ru.epam.littleBelka.task3;

public class Stapler extends Stationery {

    private int count;
    private int staplesNumber;
    private String brandName;
    private int cost;
    private String nameStationery;

    public Stapler(String nameStationery, int staplesNumber, String brandName) {
        cost = getCost(nameStationery);
        this.staplesNumber = staplesNumber;
        this.brandName = brandName;
        this.nameStationery = nameStationery;
    }

    @Override
    public int cost() {
        return cost * count;
    }

    @Override
    public String getNameStationery() {
        return nameStationery;
    }

    public void addStapler() {
        count++;
    }

    public int getStaplesNumber() {
        return staplesNumber;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }
}
