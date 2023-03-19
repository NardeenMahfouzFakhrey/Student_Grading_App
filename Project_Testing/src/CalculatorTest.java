import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    public void sum(){
    assertEquals(5,Calculator.sum(2,3));
    assertEquals(6,Calculator.sum(3,3));

}
@Test
    public void sum1(){
        assertEquals(5,Calculator.sum(2,3));


    }

}