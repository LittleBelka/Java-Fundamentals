package com.epam.littleBelka.task1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CrazyLoggerTest {

    static CrazyLogger log = new CrazyLogger();

    @BeforeClass
    public static void recordLog() {
        log.record("mes1");
        log.record("mes2");
        log.record("mes3");
    }

    @Test
    public void testFindMessageByDate() throws Exception {
        String curStringDate = new SimpleDateFormat("dd-MM-YYYY").format(System.currentTimeMillis());
        ArrayList<String> list = log.findMessageByDate(curStringDate);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testFindMessageByDateTime() throws Exception {
        String curStringDate = new SimpleDateFormat("dd-MM-YYYY:hh-mm").format(System.currentTimeMillis());
        ArrayList<String> list = log.findMessageByDateTime(curStringDate);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void testGetStr() throws Exception {
        StringBuilder str = log.getStr();
        Assert.assertTrue(str.length() > 0);
    }
}