import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradingCalculatorWhiteBoxTesting {

    GradingCalculator gradingCalculator = new GradingCalculator();
    double activities;
    double practical;
    double midterm;
    double finalExam;
    double expectedSum;
    Exception exception;

    /* Statement Coverage Test Cases for setGrade Module */

    @Test
    void setGradeStatementCoverage_Test1(){
        /* Set An Invalid Grade */
        exception = assertThrows(IllegalArgumentException.class, () -> {
            gradingCalculator.setGrade("K+");
        });
        assertEquals(exception.getMessage(), "InValid GPA Grade");

    }


    @Test
    void setGradeStatementCoverage_Test2(){

        /* Set A Valid Grade */
        gradingCalculator.setGrade("A+");
            assertEquals(gradingCalculator.getGrade(), "A+");

    }


    /* Branch and Decision Coverage Test Cases for calculateGrade Module */

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test1() {

        // A+ Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(10, 10, 20, 60);
        assertEquals("A+", gradingCalculator.getGrade());
        assertEquals(4, gradingCalculator.getGpaValue());


    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test2() {

        // A Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 10, 18, 59);
        assertEquals("A", gradingCalculator.getGrade());
        assertEquals(4, gradingCalculator.getGpaValue());


    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test3() {

        // A- Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(10, 9, 18, 55);
        assertEquals("A-", gradingCalculator.getGrade());
        assertEquals(3.7, gradingCalculator.getGpaValue());


    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test4() {

        // B+ Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 9, 15, 55);
        assertEquals("B+", gradingCalculator.getGrade());
        assertEquals(3.3, gradingCalculator.getGpaValue());

    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test5() {

        // B Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 9, 15, 50);
        assertEquals("B", gradingCalculator.getGrade());
        assertEquals(3, gradingCalculator.getGpaValue());

    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test6() {

        // B- Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 10, 15, 45);
        assertEquals("B-", gradingCalculator.getGrade());
        assertEquals(2.7, gradingCalculator.getGpaValue());

    }


    @Test
    void calculateGradeBranchAndDecisionCoverage_Test7() {

        // C+ Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 10, 11, 45);
        assertEquals("C+", gradingCalculator.getGrade());
        assertEquals(2.3, gradingCalculator.getGpaValue());

    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test8() {

        // C Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 10, 13, 40);
        assertEquals("C", gradingCalculator.getGrade());
        assertEquals(2, gradingCalculator.getGpaValue());

    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test9() {

        // C- Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 10, 11, 39);
        assertEquals("C-", gradingCalculator.getGrade());
        assertEquals(1.7, gradingCalculator.getGpaValue());

    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test10() {

        // D+ Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(5, 5, 11, 45);
        assertEquals("D+", gradingCalculator.getGrade());
        assertEquals(1.3, gradingCalculator.getGpaValue());


    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test11() {

        // D Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 10, 14, 30);
        assertEquals("D", gradingCalculator.getGrade());
        assertEquals(1, gradingCalculator.getGpaValue());

    }

    @Test
    void calculateGradeBranchAndDecisionCoverage_Test12() {

        // F Grade Branch
        gradingCalculator = GradingCalculator.CalculateGrade(9, 10, 10, 30);
        assertEquals("F", gradingCalculator.getGrade());
        assertEquals(0, gradingCalculator.getGpaValue());

    }


    /* Condition Coverage Test Cases for totalSummation Module */

    @Test
    void totalSummationConditionCoverage_Test1() {

        // midterm >= 0 is True && midterm <= 20 is True
        activities = 10;
        practical = 10;
        midterm = 19;
        finalExam = 60;
        expectedSum = activities + practical + midterm + finalExam;

        assertEquals(expectedSum, GradingCalculator.TotalSummation(activities, practical, midterm, finalExam) );

    }


    @Test
    void totalSummationConditionCoverage_Test2() {

        // midterm >= 0 is True and midterm <= 20 is False
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(activities, practical, 24, finalExam);
        });
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");

    }


    @Test
    void totalSummationConditionCoverage_Test3() {

        // midterm >= 0 is False and midterm <= 20 is True
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(activities, practical, -1, finalExam);
        });
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");

    }


    @Test
    void totalSummationConditionCoverage_Test4() {

        // practical >= 0 is True && practical <= 10 is True
        activities = 10;
        practical = 9;
        midterm = 20;
        finalExam = 60;
        expectedSum = activities + practical + midterm + finalExam;

        assertEquals(expectedSum, GradingCalculator.TotalSummation(activities, practical, midterm, finalExam) );

    }


    @Test
    void totalSummationConditionCoverage_Test5() {

        // practical >= 0 is True and practical <= 10 is False
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(activities, 24, midterm, finalExam);
        });
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");

    }


    @Test
    void totalSummationConditionCoverage_Test6() {

        // practical >= 0 is False and practical <= 10 is True
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(activities, -1, midterm, finalExam);
        });
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");

    }


    @Test
    void totalSummationConditionCoverage_Test7() {

        // activities >= 0 is True && activities <= 10 is True
        activities = 9;
        practical = 10;
        midterm = 20;
        finalExam = 60;
        expectedSum = activities + practical + midterm + finalExam;

        assertEquals(expectedSum, GradingCalculator.TotalSummation(activities, practical, midterm, finalExam) );

    }


    @Test
    void totalSummationConditionCoverage_Test8() {
        // activities >= 0 is True and activities <= 10 is False
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(24, practical, midterm, finalExam);
        });
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");

    }


    @Test
    void totalSummationConditionCoverage_Test9() {

        // activities >= 0 is False and activities <= 10 is True
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(-1, practical, midterm, finalExam);
        });
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");

    }


    @Test
    void totalSummationConditionCoverage_Test10() {

        // afinal >= 0 is True && afinal <= 60 is True
        activities = 10;
        practical = 10;
        midterm = 20;
        finalExam = 42;
        expectedSum = activities + practical + midterm + finalExam;

        assertEquals(expectedSum, GradingCalculator.TotalSummation(activities, practical, midterm, finalExam) );

    }


    @Test
    void totalSummationConditionCoverage_Test11() {

        // afinal >= 0 is True && afinal <= 60 is False
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(activities, practical, midterm, 90);
        });
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");

    }


    @Test
    void totalSummationConditionCoverage_Test12() {

        // afinal >= 0 is False && afinal <= 60 is True
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(activities, practical, midterm, -1);
        });
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");

    }

}

