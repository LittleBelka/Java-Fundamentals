package com.epam.littleBelka.task2;

import java.util.ListResourceBundle;

public class QuestionEnglish extends ListResourceBundle{

    public Object[][] content = new Object[][]
            {
                { "1", "How many hours in the day?" },
                { "2", "What is the name of our galaxy?" },
                { "3", "The capital of Madagascar?" },
                { "4", "Through a big city passes the Greenwich prime meridian?" }
            };

    public Object[][] getContents() {
        return content;
    }
}
