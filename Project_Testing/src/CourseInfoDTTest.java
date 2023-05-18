import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseInfoDTTest {


    CourseInfo course;
    Exception exception;

    @Test
    void DecisionTable_Test1(){
        // Test constructor with invalid name, code and full mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" Physics", "PHY001p", 25);
        });
        assertEquals(exception.getMessage(), "String must start with a letter.");

    }

    @Test
    void DecisionTable_Test2(){
        // Test constructor with invalid Name and code
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" Physics", "PHY001p", 100);
        });
        assertEquals(exception.getMessage(), "String must start with a letter.");
    }

    @Test
    void DecisionTable_Test3(){
        // Test constructor with invalid Name and full mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" Physics", "PHY001", 25);
        });
        assertEquals(exception.getMessage(), "String must start with a letter.");
    }

    @Test
    void DecisionTable_Test4(){
        // Test constructor with invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" MATH", "PHY001", 100);
        });
        assertEquals(exception.getMessage(), "String must start with a letter.");
    }

    @Test
    void DecisionTable_Test5(){
        // Test constructor with invalid code and full mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY001p", 25);
        });
        assertEquals(exception.getMessage(), "Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
    }

    @Test
    void DecisionTable_Test6(){
        // Test constructor with invalid code
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY00", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
    }

    @Test
    void DecisionTable_Test7(){
        // Test constructor with invalid full mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY001", 50);
        });
        assertEquals(exception.getMessage(),"Full Mark must be 100");
    }

    @Test
    void DecisionTable_Test8(){
        // Test constructor with valid inputs
        course = new CourseInfo("Physics", "PHY001", 100);
        assertEquals("Physics", course.getName());
        assertEquals("PHY001", course.getCode());
        assertEquals(100, course.getFullMark());
    }
}