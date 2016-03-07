package ru.epam.littleBelka.task6;

import org.junit.Assert;
import org.junit.Test;

public class AtomicBoatTest {

    AtomicBoat boat = new AtomicBoat();

    @Test
    public void testStart() {
        Assert.assertTrue(boat.start.equals("Пуск"));
    }

}