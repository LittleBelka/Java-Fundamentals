package ru.epam.littleBelka.task3;

import org.junit.Assert;
import org.junit.Test;

public class GlueTest {

    Glue stationery = new Glue("Glue", 300, "Kinotti");

    @Test
    public void testExtends() {
        Assert.assertTrue(Stationery.class.isAssignableFrom(Glue.class));
    }

    @Test
    public void testCost() throws Exception {
        stationery.addGlue();
        stationery.addGlue();
        Assert.assertFalse(stationery.cost() != 30);
    }

    @Test
    public void testGetNameStationery() throws Exception {
        Assert.assertTrue(stationery.getNameStationery().equals("Glue"));
    }

    @Test
    public void testGetViscosity() throws Exception {
        Assert.assertTrue(stationery.getViscosity() == 300);
    }

    @Test
    public void testGetBrandName() throws Exception {
        Assert.assertTrue(stationery.getBrandName().equals("Kinotti"));
    }
}