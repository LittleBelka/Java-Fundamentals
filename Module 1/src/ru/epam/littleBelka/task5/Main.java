package ru.epam.littleBelka.task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("n - натуральное число");
        } else {
            int[][] number = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        number[i][j] = 1;
                    } else if (j == n - i - 1) {
                        number[i][j] = 1;
                    } else {
                        number[i][j] = 0;
                    }
                    System.out.print(number[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }
}
