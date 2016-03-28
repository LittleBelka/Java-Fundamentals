package com.epam.littleBelka.task2;

public class KeyPropertiesExceptions extends Exception{

    private String str;
    KeyPropertiesExceptions(String str) {
        this.str = str;
    }

    public String toString() {
        return str;
    }
}
