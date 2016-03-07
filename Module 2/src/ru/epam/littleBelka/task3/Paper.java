package ru.epam.littleBelka.task3;

public class Paper extends Stationery {

    private int count;
    private int density;
    private String brandName;
    private int cost;
    private String nameStationery;

    public Paper(String nameStationery, int density, String brandName) {
        cost = getCost(nameStationery);
        this.density = density;
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

    public void addPaper() {
        count++;
    }

    public int getDensity() {
        return density;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }

}
