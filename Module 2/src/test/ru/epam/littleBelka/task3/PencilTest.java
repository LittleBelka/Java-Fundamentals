package ru.epam.littleBelka.task3;

import org.junit.Assert;
import org.junit.Test;

public class PencilTest {

    Pencil stationery = new Pencil("Pencil", "blue", "Silwerhof");

    @Test
    public void testExtends() {
        Assert.assertTrue(Stationery.class.isAssignableFrom(Pencil.class));
    }

    @Test
    public void testCost() throws Exception {
        stationery.addPencil();
        stationery.addPencil();
        Assert.assertFalse(stationery.cost() != 14);
    }

    @Test
    public void testGetNameStationery() throws Exception {
        Assert.assertTrue(stationery.getNameStationery().equals("Pencil"));
    }

    @Test
    public void testGetColor() throws Exception {
        Assert.assertTrue(stationery.getColor().equals("blue"));
    }

    @Test
    public void testGetBrandName() throws Exception {
        Assert.assertTrue(stationery.getBrandName().equals("Silwerhof"));
    }
}