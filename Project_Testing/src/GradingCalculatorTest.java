import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GradingCalculatorTest {
    StudentsInfo object;

    @BeforeEach
    void setUp(){
        StudentsInfo.usedIDs.clear();
        object = new StudentsInfo("Nardeen", "12345678", 10.0, 10.0, 20.0, 60.0);
    }

    @Test
    void testCalculateGrade(){

        GradingCalculator grader;

        //tests for Grade A+
        grader = GradingCalculator.CalculateGrade(10, 10, 20, 60);
        assertEquals("A+",grader.getGrade());
        assertEquals(4,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 19, 59);
        assertEquals("A+",grader.getGrade());
        assertEquals(4,grader.getGpaValue());

        //tests for Grade A
        grader = GradingCalculator.CalculateGrade(9, 10, 18, 59);
        assertEquals("A",grader.getGrade());
        assertEquals(4,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 19, 55);
        assertEquals("A",grader.getGrade());
        assertEquals(4,grader.getGpaValue());

        //tests for Grade A-
        grader = GradingCalculator.CalculateGrade(10, 9, 18, 55);
        assertEquals("A-",grader.getGrade());
        assertEquals(3.7,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 15, 55);
        assertEquals("A-",grader.getGrade());
        assertEquals(3.7,grader.getGpaValue());

        //tests for Grade B+
        grader = GradingCalculator.CalculateGrade(9, 9, 15, 55);
        assertEquals("B+",grader.getGrade());
        assertEquals(3.3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 15, 50);
        assertEquals("B+",grader.getGrade());
        assertEquals(3.3,grader.getGpaValue());

        //tests for Grade B
        grader = GradingCalculator.CalculateGrade(9, 9, 15, 50);
        assertEquals("B",grader.getGrade());
        assertEquals(3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 10, 15, 45);
        assertEquals("B",grader.getGrade());
        assertEquals(3,grader.getGpaValue());

        //tests for Grade B-
        grader = GradingCalculator.CalculateGrade(9, 10, 15, 45);
        assertEquals("B-",grader.getGrade());
        assertEquals(2.7,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 10, 10, 46);
        assertEquals("B-",grader.getGrade());
        assertEquals(2.7,grader.getGpaValue());

        //tests for Grade C+
        grader = GradingCalculator.CalculateGrade(9, 10, 11, 45);
        assertEquals("C+",grader.getGrade());
        assertEquals(2.3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 10, 13, 40);
        assertEquals("C+",grader.getGrade());
        assertEquals(2.3,grader.getGpaValue());

        //tests for Grade C
        grader = GradingCalculator.CalculateGrade(9, 10, 13, 40);
        assertEquals("C",grader.getGrade());
        assertEquals(2,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 11, 40);
        assertEquals("C",grader.getGrade());
        assertEquals(2,grader.getGpaValue());

        //tests for Grade C-
        grader = GradingCalculator.CalculateGrade(9, 10, 11, 39);
        assertEquals("C-",grader.getGrade());
        assertEquals(1.7,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(5, 5, 11, 46);
        assertEquals("C-",grader.getGrade());
        assertEquals(1.7,grader.getGpaValue());

        //tests for Grade D+
        grader = GradingCalculator.CalculateGrade(5, 5, 11, 45);
        assertEquals("D+",grader.getGrade());
        assertEquals(1.3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9, 10, 15, 30);
        assertEquals("D+",grader.getGrade());
        assertEquals(1.3,grader.getGpaValue());

        //tests for Grade D
        grader = GradingCalculator.CalculateGrade(9, 10, 14, 30);
        assertEquals("D",grader.getGrade());
        assertEquals(1,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9, 10, 11, 30);
        assertEquals("D",grader.getGrade());
        assertEquals(1,grader.getGpaValue());

        //tests for Grade F
        grader = GradingCalculator.CalculateGrade(9, 10, 10, 30);
        assertEquals("F",grader.getGrade());
        assertEquals(0,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(7, 7, 5, 40);
        assertEquals("F",grader.getGrade());
        assertEquals(0,grader.getGpaValue());
    }

    @Test
    void testTotalSummation(){

        //test TotalSummation with maximum sum 100
        double activities = 10;
        double practical = 10;
        double midterm = 20;
        double finalExam = 60;
        double expectedSum = activities + practical + midterm + finalExam;
        assertEquals(expectedSum, GradingCalculator.TotalSummation(activities, practical, midterm, finalExam) );


        //test TotalSummation with minimum sum 0
        activities = 0;
        practical = 0;
        midterm = 0;
        finalExam = 0;
        expectedSum = activities + practical + midterm + finalExam;
        assertEquals(expectedSum, GradingCalculator.TotalSummation(activities, practical, midterm, finalExam) );

        //test TotalSummation with valid inputs
        activities = 10;
        practical = 9;
        midterm = 15;
        finalExam = 53.5;
        expectedSum = activities + practical + midterm + finalExam;
        assertEquals(expectedSum, GradingCalculator.TotalSummation(activities, practical, midterm, finalExam) );

        Exception exception;

        //test TotalSummation with activities less than 0
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(-1, 5, 18, 50);
        });
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");

        //test TotalSummation with activities more than 10
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(11, 5, 18, 50);
        });
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");

        //test TotalSummation with practical less than 0
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(10, -5, 18, 49);
        });
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");

        //test TotalSummation with practical more than 10
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(5, 20, 18, 40);
        });
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");

        //test TotalSummation with midterm less than 0
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(8, 10, -15, 55);
        });
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");

        //test TotalSummation with midterm more than 20
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(8, 10, 25, 60);
        });
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");

        //test TotalSummation with activities less than 0
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(7, 10, 17, -55);
        });
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");

        //test TotalSummation with activities more than 10
        exception = assertThrows(IllegalArgumentException.class, () -> {
            GradingCalculator.TotalSummation(7, 10, 17, 70);
        });
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");

    }

    @Test
    void testGetGrade(){

    }

    @Test
    void testSetGrade(){
        GradingCalculator grader = new GradingCalculator();
        Exception exception;

        //test setGrade with invalid grades
        exception = assertThrows(IllegalArgumentException.class, () -> {
            grader.setGrade("F-");
        });
        assertEquals(exception.getMessage(), "InValid GPA Grade");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            grader.setGrade("D-");
        });
        assertEquals(exception.getMessage(), "InValid GPA Grade");

        //test setGrade with a valid grade
        grader.setGrade("B+");
        assertEquals(grader.getGrade(), "B+");

    }

    @Test
    void TestGetGpaValue(){

    }

    @Test
    void testSetGpaValue(){
        GradingCalculator grader = new GradingCalculator();
        Exception exception;

        //test setGpaValue with invalid numbers
        exception = assertThrows(IllegalArgumentException.class, () -> {
            grader.setGpaValue(3.8);
        });
        assertEquals(exception.getMessage(), "InValid GPA Value");

        exception = assertThrows(IllegalArgumentException.class, () -> {
            grader.setGpaValue(0.7);
        });
        assertEquals(exception.getMessage(), "InValid GPA Value");

        //test setGrade with a valid number
        grader.setGpaValue(3.7);
        assertEquals(grader.getGpaValue(), 3.7);
    }

    @Test
    void testToString(){}

    @Test
    void testSaveGrade(){}










}