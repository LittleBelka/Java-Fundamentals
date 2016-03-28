package ru.epam.littleBelka.task7;

import org.junit.Assert;
import org.junit.Test;

public class AtomicBoatTest {

    AtomicBoat boat = new AtomicBoat();

    @Test
    public void testStart() {
        Assert.assertTrue(boat.start.equals("Пуск лодки \"Шань\" со скоростью 65 км/ч"));
    }

}