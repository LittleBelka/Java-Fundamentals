package ru.epam.littleBelka.task2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ElementsSequence {

    public static void main(String[] args) {

        System.out.println("Введите e");
        Scanner sc = new Scanner(System.in);
        double e = sc.nextDouble();
        if (e <= 0) {
            System.out.println("e - натуральное число");
        } else {
            if (e >= 1) {
                System.out.println("Номер =  1");
                System.out.println("0,25");
            } else {
                findMinNumber(e);
            }
        }
    }

    public static void findMinNumber(double e) {

        int n = (int) (Math.sqrt(1/e) - 1);
        System.out.println("Номер =  " + n);
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(new DecimalFormat("#0.00").format(1/Math.pow(i + 1, 2) ) + "  ");
        }
    }

}
