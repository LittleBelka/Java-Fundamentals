package ru.epam.littleBelka.task1.javase01.t01;

import ru.epam.littleBelka.task1.javase01.t01.logic.Logic;

public class Main {

    public static void main(String[] args) {
        Logic logic = new Logic();
        System.out.println(logic.method());
    }
}

/*  compilation:
javac -classpath ./out -d .out/ src\ru\epam\littleBelka\task1\javase01\t01\Main.java
* src\ru\epam\littleBelka\task1\javase01\t01\logic\Logic.java*/

/*  start:
java -classpath ./out ru.epam.littleBelka.task1.javase01.t01.Main*/
