package ru.epam.littleBelka.task4;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class KitStationeryTest {

    static KitStationery kitS = new KitStationery();

    @BeforeClass
    public static void testCreateKitStationery() throws Exception {
        kitS.createKitStationery();
        for(int i = 0; i < 5; i++) {
            Assert.assertFalse(kitS.kit[i] == null);
        }
    }

    @Test
    public void testSortedByPrice() throws Exception {
        kitS.sortedByPrice();
        Assert.assertFalse(kitS.kit[0].cost() != 2 || kitS.kit[1].cost() != 7 || kitS.kit[2].cost() != 30
        || kitS.kit[3].cost() != 30 || kitS.kit[4].cost() != 30);
    }

    @Test
    public void testSortedByName() throws Exception {
        kitS.sortedByName();
        Assert.assertFalse(kitS.kit[0].getNameStationery() != "Glue" || kitS.kit[1].getNameStationery() != "Paper" ||
                kitS.kit[2].getNameStationery() != "Pen" || kitS.kit[3].getNameStationery() != "Pencil" ||
                kitS.kit[4].getNameStationery() != "Stapler");

    }

    @Test
    public void testSortedByPriceAndName() throws Exception {
        kitS.sortedByPriceAndName();
        Assert.assertFalse(kitS.kit[0].getNameStationery() != "Paper" || kitS.kit[1].getNameStationery() != "Pencil" ||
                kitS.kit[2].getNameStationery() != "Glue" || kitS.kit[3].getNameStationery() != "Pen" ||
                kitS.kit[4].getNameStationery() != "Stapler");
    }
}