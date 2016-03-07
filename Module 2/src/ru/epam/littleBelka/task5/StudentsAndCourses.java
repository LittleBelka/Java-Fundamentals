package ru.epam.littleBelka.task5;

import java.util.Arrays;

enum Course {
    Mathematics("double"), English("int"), Programming("int"), DiscreteMathematics("double");

    private int n;
    private String kindAssessment;
    private String[] students;
    private double[] assessment;

    Course(String kindAssessment) {
        this.kindAssessment = kindAssessment;
        students = new String[1];
        assessment = new double[1];
    }

    private void changeCapacity(int capacity) {
        String[] copy = Arrays.copyOf(students, capacity);
        students = copy;
        double[] copyCount = Arrays.copyOf(assessment, capacity);
        assessment = copyCount;
    }

    public void addStudentAndAssessment(String newStudent, double newAssessment) {
        if (newStudent != null) {
            if (!kindAssessment.equals("double")) {
                newAssessment = Math.round(newAssessment);
            }
            int index = Arrays.asList(students).indexOf(newStudent);
            if (index != -1 && students.length != n) {
                assessment[index] = newAssessment;
            }
            if (index == -1) {
                if (students.length == n) {
                    changeCapacity(2 * students.length);
                }
                students[n] = newStudent;
                assessment[n] = newAssessment;
                n++;
            }
        }
    }

    public double getAssessment(String nameStudent) {

        int index = Arrays.asList(students).indexOf(nameStudent);
        if (index != -1) {
            return assessment[index];
        }
        return 0;
    }

    public void showStudents() {

        for (String s: students) {
            System.out.println(s);
        }
    }
}

