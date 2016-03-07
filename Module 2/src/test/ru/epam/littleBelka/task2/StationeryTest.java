package ru.epam.littleBelka.task2;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StationeryTest {

    static Stationery s1 = new Stationery();

    @BeforeClass
    public static void testAddStationery() throws Exception {
        s1.addStationery("Pen");
        s1.addStationery("Pen");
        s1.addStationery("Paper");
        s1.addStationery("Stapler");
        s1.addStationery("Glue");
        s1.addStationery("Pencil");
        s1.addStationery("Pencil");
        s1.addStationery("Pencil");
    }

    @Test
    public void testGetCountStationery() throws Exception {
        Assert.assertFalse(s1.getCountStationery("Pen") != 2);
        Assert.assertFalse(s1.getCountStationery("Pencil") != 3);
        Assert.assertFalse(s1.getCountStationery("Paper") != 1);
        Assert.assertFalse(s1.getCountStationery("Glue") != 1);
        Assert.assertFalse(s1.getCountStationery("Stapler") != 1);

    }

    @Test
    public void testGetCostAllStationery() throws Exception {
        int sum = s1.getCostAllStationery();
        if (sum != 83) {
            Assert.fail();
        }
    }
}