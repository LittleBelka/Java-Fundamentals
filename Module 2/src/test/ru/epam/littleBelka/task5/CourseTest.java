package ru.epam.littleBelka.task5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CourseTest {

    @BeforeClass
    public static void addStudents() {
        Course.Mathematics.addStudentAndAssessment("Иванов", 4.8);
        Course.Mathematics.addStudentAndAssessment("Зайцев", 3.4);
        Course.Mathematics.addStudentAndAssessment("Сорокин", 4);
        Course.English.addStudentAndAssessment("Иванов", 4.1);
        Course.English.addStudentAndAssessment("Войтов", 3);
        Course.Programming.addStudentAndAssessment("Иванов", 4.6);
        Course.Programming.addStudentAndAssessment("Сорокин", 2.6);
        Course.DiscreteMathematics.addStudentAndAssessment("Иванов", 3);
    }

    @Test
    public void testGetAssessment() throws Exception {

        double as = Course.Mathematics.getAssessment("Иванов");
        Assert.assertFalse(as != 4.8);
        double as1 = Course.English.getAssessment("Иванов");
        Assert.assertFalse(as1 != 4);
        double as2 = Course.Programming.getAssessment("Иванов");
        Assert.assertFalse(as2 != 5);
        double as3 = Course.DiscreteMathematics.getAssessment("Иванов");
        Assert.assertFalse(as3 != 3);

    }
}