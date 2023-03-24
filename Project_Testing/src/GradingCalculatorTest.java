import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradingCalculatorTest {
    StudentsInfo object;
    @BeforeEach
    void setUp(){
        object = new StudentsInfo("Nardeen", "12345678", 10.0, 10.0, 20.0, 60.0);
    }

    @Test
    void testGradeA() {
        GradingCalculator g = GradingCalculator.CalculateGrade(object.Activities ,object.Practical , object.Midterm , object.Final);
        assertEquals("A+",g.getGrade());
        assertEquals(4,g.getGpaValue());
    }
}