package ru.epam.littleBelka.task3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите нижнюю границу области определения  a");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Введите верхнюю границу области определения  b");
        int b = sc.nextInt();
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        System.out.println("Введите шаг  h");
        int h = sc.nextInt();
        if (h <= 0) {
            System.out.println("h - натуральное число");
        } else {
            if (a == b) {
                h = 1;
            }
            System.out.println("Аргумент" + "\t" + "Значение функции");
            for (int i = a; i < b + 1; i = i + h) {
                System.out.println(i + "\t\t\t" + new DecimalFormat("#0.00").format((Math.tan(2 * i) - 3)));
            }
        }
    }
}
