package ru.epam.littleBelka.task3;

public class Pencil extends Stationery {

    private int count;
    private String color;
    private String brandName;
    private int cost;
    private String nameStationery;

    public Pencil(String nameStationery, String color, String brandName) {
        cost = getCost(nameStationery);
        this.color = color;
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

    public void addPencil() {
        count++;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getBrandName() {
        return brandName;
    }
}
