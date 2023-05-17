import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradingCalculateBVATest {

    //Black Box Boundary Value Analysis Technique
    @Test
    void BVA_testCalculateGradeAPlus(){
        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(10, 10, 20, 60);
        assertEquals("A+",grader.getGrade());
        assertEquals(4,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9.5, 10, 19.5, 59);
        assertEquals("A+",grader.getGrade());
        assertEquals(4,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 19, 59);
        assertEquals("A+",grader.getGrade());
        assertEquals(4,grader.getGpaValue()); }

    @Test
    void BVA_testCalculateGradeA(){

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(9, 10, 18, 59);
        assertEquals("A",grader.getGrade());
        assertEquals(4,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9.5, 9.5, 19.5, 55.5);
        assertEquals("A",grader.getGrade());
        assertEquals(4,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 19, 55);
        assertEquals("A",grader.getGrade());
        assertEquals(4,grader.getGpaValue()); }

    @Test
    void BVA_testCalculateGradeAminus() {

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(10, 9, 18, 55);
        assertEquals("A-", grader.getGrade());
        assertEquals(3.7, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9.5, 9, 16, 55);
        assertEquals("A-", grader.getGrade());
        assertEquals(3.7, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 15, 55);
        assertEquals("A-", grader.getGrade());
        assertEquals(3.7, grader.getGpaValue());
    }

    @Test
    void BVA_testCalculateGradeBplus(){

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(9, 9, 15, 55);
        assertEquals("B+",grader.getGrade());
        assertEquals(3.3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(8.5, 8, 14.5, 55);
        assertEquals("B+",grader.getGrade());
        assertEquals(3.3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 15, 50);
        assertEquals("B+",grader.getGrade());
        assertEquals(3.3,grader.getGpaValue()); }

    @Test
    void BVA_testCalculateGradeB() {

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(9, 9, 15, 50);
        assertEquals("B", grader.getGrade());
        assertEquals(3, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(8.5, 9, 15, 49);
        assertEquals("B", grader.getGrade());
        assertEquals(3, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 10, 15, 45);
        assertEquals("B", grader.getGrade());
        assertEquals(3, grader.getGpaValue());
    }

    @Test
    void BVA_testCalculateGradeBminus() {

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(9, 10, 15, 45);
        assertEquals("B-", grader.getGrade());
        assertEquals(2.7, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(7.5, 9.5, 8.5, 53);
        assertEquals("B-", grader.getGrade());
        assertEquals(2.7, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 10, 10, 46);
        assertEquals("B-", grader.getGrade());
        assertEquals(2.7, grader.getGpaValue());
    }

    @Test
    void BVA_testCalculateGradeCPlus(){

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(9, 10, 11, 45);
        assertEquals("C+",grader.getGrade());
        assertEquals(2.3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9.5, 9.5, 14.5, 40.5);
        assertEquals("C+",grader.getGrade());
        assertEquals(2.3,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 10, 13, 40);
        assertEquals("C+",grader.getGrade());
        assertEquals(2.3,grader.getGpaValue()); }

    @Test
    void BVA_testCalculateGradeC() {

        GradingCalculator grader;

        //tests for Grade C
        grader = GradingCalculator.CalculateGrade(9, 10, 13, 40);
        assertEquals("C", grader.getGrade());
        assertEquals(2, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 11.5, 40);
        assertEquals("C", grader.getGrade());
        assertEquals(2, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(10, 9, 11, 40);
        assertEquals("C", grader.getGrade());
        assertEquals(2, grader.getGpaValue());
    }

    @Test
    void BVA_testCalculateGradeCminus() {

        GradingCalculator grader;
        //tests for Grade C-
        grader = GradingCalculator.CalculateGrade(9, 10, 11, 39);
        assertEquals("C-", grader.getGrade());
        assertEquals(1.7, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(5.5, 5.5, 11, 46.5);
        assertEquals("C-", grader.getGrade());
        assertEquals(1.7, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(5, 5, 11, 46);
        assertEquals("C-", grader.getGrade());
        assertEquals(1.7, grader.getGpaValue());
    }

    @Test
    void BVA_testCalculateGradeDplus() {

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(5, 5, 11, 45);
        assertEquals("D+", grader.getGrade());
        assertEquals(1.3, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(6.5, 9.5, 16, 34.5);
        assertEquals("D+", grader.getGrade());
        assertEquals(1.3, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9, 10, 15, 30);
        assertEquals("D+", grader.getGrade());
        assertEquals(1.3, grader.getGpaValue());
    }

    @Test
    void BVA_testCalculateGradeD() {

        GradingCalculator grader;
        grader = GradingCalculator.CalculateGrade(9, 10, 14, 30);
        assertEquals("D", grader.getGrade());
        assertEquals(1, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(7.5, 10, 11, 32.5);
        assertEquals("D", grader.getGrade());
        assertEquals(1, grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(9, 10, 11, 30);
        assertEquals("D", grader.getGrade());
        assertEquals(1, grader.getGpaValue());
    }

    @Test
    void BVA_testCalculateGradeF(){

        GradingCalculator grader;
        //tests for Grade F
        grader = GradingCalculator.CalculateGrade(9, 10, 10, 30);
        assertEquals("F",grader.getGrade());
        assertEquals(0,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(7.5, 8.5, 5.5, 30.5);
        assertEquals("F",grader.getGrade());
        assertEquals(0,grader.getGpaValue());
        grader = GradingCalculator.CalculateGrade(0, 0, 0, 0);
        assertEquals("F",grader.getGrade());
        assertEquals(0,grader.getGpaValue());
    }

}
