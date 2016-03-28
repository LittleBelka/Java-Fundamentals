package ru.epam.littleBelka.task3;

import org.junit.Assert;
import org.junit.Test;

public class PaperTest {

    Paper stationery = new Paper("Paper", 75, "Hatber");

    @Test
    public void testExtends() {
        Assert.assertTrue(Stationery.class.isAssignableFrom(Paper.class));
    }

    @Test
    public void testCost() throws Exception {
        stationery.addPaper();
        stationery.addPaper();
        Assert.assertFalse(stationery.cost() != 4);
    }

    @Test
    public void testGetNameStationery() throws Exception {
        Assert.assertTrue(stationery.getNameStationery().equals("Paper"));
    }

    @Test
    public void testGetDensity() throws Exception {
        Assert.assertTrue(stationery.getDensity() == 75);
    }

    @Test
    public void testGetBrandName() throws Exception {
        Assert.assertTrue(stationery.getBrandName().equals("Hatber"));
    }
}