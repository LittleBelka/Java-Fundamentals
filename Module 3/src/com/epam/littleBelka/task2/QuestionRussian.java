package com.epam.littleBelka.task2;

import java.util.ListResourceBundle;

public class QuestionRussian extends ListResourceBundle {

    public Object[][] content = new Object[][]
            {
                { "1", "Сколько часов в сутках?" },
                { "2", "Как называется наша галактика?" },
                { "3", "Столица Мадагаскара?" },
                { "4", "Через какой большой город проходит Гринвичский нулевой меридиан?" }
            };

    public Object[][] getContents() {
        return content;
    }
}
