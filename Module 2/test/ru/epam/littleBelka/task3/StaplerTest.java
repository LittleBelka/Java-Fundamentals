package ru.epam.littleBelka.task3;

import org.junit.Assert;
import org.junit.Test;

public class StaplerTest {

    Stapler stationery = new Stapler("Stapler", 200, "Berlingo");

    @Test
    public void testExtends() {
        Assert.assertTrue(Stationery.class.isAssignableFrom(Stapler.class));
    }

    @Test
    public void testCost() throws Exception {
        stationery.addStapler();
        stationery.addStapler();
        Assert.assertFalse(stationery.cost() != 60);
    }

    @Test
    public void testGetNameStationery() throws Exception {
        Assert.assertTrue(stationery.getNameStationery().equals("Stapler"));
    }

    @Test
    public void testGetStaplesNumber() throws Exception {
        Assert.assertTrue(stationery.getStaplesNumber() == 200);
    }

    @Test
    public void testGetBrandName() throws Exception {
        Assert.assertTrue(stationery.getBrandName().equals("Berlingo"));
    }
}