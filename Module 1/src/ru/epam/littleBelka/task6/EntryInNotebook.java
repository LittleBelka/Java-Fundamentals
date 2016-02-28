package ru.epam.littleBelka.task6;

import java.util.Scanner;

/**
 * This is the main class that is designed for different actions with entries in a notebook.
 */
public class EntryInNotebook {

    /**
     * This method adds an entries in notebook and carries them with different actions.
     * @param args it entries added to the notebook
     */
    public static void main(String[] args){

        System.out.println("Введите количество записей  n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("n - натуральное число");
        } else {
            Notebook notebook = new Notebook(n);
            System.out.println("Введите записи");
            for (int i = 0; i < n; i++) {
                notebook.addEntry(sc.next());
            }
            notebook.getAllEntries();
        }
    }

}
