package com.epam.littleBelka.task2;

import java.util.ListResourceBundle;

public class AnswerEnglish extends ListResourceBundle {

    public Object[][] content = new Object[][]
            {
                { "1", "24" },
                { "2", "Milky Way" },
                { "3", "Antananarivo" },
                { "4", "London" }
            };

    public Object[][] getContents() {
        return content;
    }
}
