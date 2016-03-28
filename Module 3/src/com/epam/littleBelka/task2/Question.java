package com.epam.littleBelka.task2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Question {

    private String language = "";
    private String classQuestion = "";
    private String classAnswer = "";

    public void selectionLanguage(String lan) {

        if (lan != null && (lan.equals("ru") || lan.equals("en"))) {
            language = lan;
        }
        if (language.equals("en")) {
            classQuestion = "QuestionEnglish";
            classAnswer = "AnswerEnglish";
            show();
        }
        if (language.equals("ru")) {
            classQuestion = "QuestionRussian";
            classAnswer = "AnswerRussian";
            show();
        }
    }

    private void show() {

        ResourceBundle bungle = ResourceBundle.getBundle("com.epam.littleBelka.task2." + classQuestion, new Locale(language));
        System.out.println("№1 " + bungle.getString("1"));
        System.out.println("№2 " + bungle.getString("2"));
        System.out.println("№3 " + bungle.getString("3"));
        System.out.println("№4 " + bungle.getString("4"));
        System.out.println();
        System.out.println("Выбири номер вопроса");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        if (Integer.parseInt(number) > 0 && Integer.parseInt(number) < 5) {
            ResourceBundle bungle1 = ResourceBundle.getBundle("com.epam.littleBelka.task2." + classAnswer, new Locale(language));
            System.out.println(bungle1.getString(number));
        } else {
            System.out.println("Вопроса под таким номером нет");
        }
    }
}
