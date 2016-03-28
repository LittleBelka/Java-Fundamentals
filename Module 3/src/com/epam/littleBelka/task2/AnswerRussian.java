package com.epam.littleBelka.task2;

import java.util.ListResourceBundle;

public class AnswerRussian extends ListResourceBundle {

    public Object[][] content = new Object[][]
            {
                { "1", "24" },
                { "2", "Млечный путь" },
                { "3", "Антананариву" },
                { "4", "Лондон" }
            };

    public Object[][] getContents() {
        return content;
    }
}
