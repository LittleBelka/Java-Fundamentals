package ru.epam.littleBelka.task4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("n - натуральное число");
        } else {
            double[] number = new double[n];
            System.out.println("Введите последовательность из n чисел");
            for (int i = 0; i < n; i++) {
                number[i] = sc.nextDouble();
            }
            double max = number[0];
            for (int i = 0; i < n / 2; i++) {
                double tmp = number[i] + number[n - 1 - i];
                if (max < tmp) {
                    max = tmp;
                }
            }
            System.out.println("Max =  " + new DecimalFormat("#0.00").format(max));
        }
    }
}
