package com.epam.littleBelka.task3;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ParsingDocumentTest {

    @Test
    public void testSerialLinksToPictures() throws Exception {

        ParsingDocument pas = new ParsingDocument();
        Assert.assertTrue(pas.serialLinksToPictures());
    }

    @Test
    public void testFindPictures() throws Exception {

        ParsingDocument pas = new ParsingDocument();
        ArrayList<String> list = pas.findPictures();
        if (list == null) {
            Assert.fail();
        }
        if (list.size() > 0) {
            for (String o:list) {
                System.out.println(o);
            }
        }
    }
}