package ru.epam.littleBelka.task3;

public class Glue extends Stationery{

    private int count;
    private String brandName;
    private int viscosity;
    private int cost;
    private String nameStationery;

    public Glue(String nameStationery, int viscosity, String brandName) {
        cost = getCost(nameStationery);
        this.viscosity = viscosity;
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

    public void addGlue() {
        count++;
    }

    public int getViscosity() {
        return viscosity;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }
}
