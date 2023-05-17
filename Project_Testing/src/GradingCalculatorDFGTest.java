import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradingCalculatorDFGTest {

    //White Box Data Flow Technique
    @Test
    void DFG_CalculateGradeTest1(){
        GradingCalculator grader;
        String expectedGrade = "A+";
        double expectedGPA = 4;
        grader = GradingCalculator.CalculateGrade(9, 10, 20, 59);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest2(){
        GradingCalculator grader;
        String expectedGrade = "A";
        double expectedGPA = 4;
        grader = GradingCalculator.CalculateGrade(9, 9, 18, 58);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest3(){
        GradingCalculator grader;
        String expectedGrade = "A-";
        double expectedGPA = 3.7;
        grader = GradingCalculator.CalculateGrade(9, 9, 18, 55);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest4(){
        GradingCalculator grader;
        String expectedGrade = "B+";
        double expectedGPA = 3.3;
        grader = GradingCalculator.CalculateGrade(7, 9, 15, 55);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest5(){
        GradingCalculator grader;
        String expectedGrade = "B";
        double expectedGPA = 3;
        grader = GradingCalculator.CalculateGrade(9, 9, 15, 50);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest6(){
        GradingCalculator grader;
        String expectedGrade = "B-";
        double expectedGPA = 2.7;
        grader = GradingCalculator.CalculateGrade(9, 10, 15, 45);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest7(){
        GradingCalculator grader;
        String expectedGrade = "C+";
        double expectedGPA = 2.3;
        grader = GradingCalculator.CalculateGrade(9, 10, 11, 45);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest8(){
        GradingCalculator grader;
        String expectedGrade = "C";
        double expectedGPA = 2;
        grader = GradingCalculator.CalculateGrade(9, 10, 13, 39);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest9(){
        GradingCalculator grader;
        String expectedGrade = "C-";
        double expectedGPA = 1.7;
        grader = GradingCalculator.CalculateGrade(9, 8, 11, 39);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest10(){
        GradingCalculator grader;
        String expectedGrade = "D+";
        double expectedGPA = 1.3;
        grader = GradingCalculator.CalculateGrade(5, 5, 11, 45);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest11(){
        GradingCalculator grader;
        String expectedGrade = "D";
        double expectedGPA = 1;
        grader = GradingCalculator.CalculateGrade(8, 10, 14, 30);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }

    @Test
    void DFG_CalculateGradeTest12(){
        GradingCalculator grader;
        String expectedGrade = "F";
        double expectedGPA = 0;
        grader = GradingCalculator.CalculateGrade(9, 5, 10, 30);
        assertEquals(expectedGrade,grader.getGrade());
        assertEquals(expectedGPA,grader.getGpaValue());
    }
}
