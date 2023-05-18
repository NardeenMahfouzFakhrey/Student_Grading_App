import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseInfoCETest {

    CourseInfo course;
    Exception exception;

    @Test
    void CE_validConstructor(){
        // Test constructor with valid inputs
        course = new CourseInfo("Physics", "PHY001", 100);
        assertEquals("Physics", course.getName());
        assertEquals("PHY001", course.getCode());
        assertEquals(100, course.getFullMark());
    }

    @Test
    void CE_testConstructorName(){
        // Test constructor with invalid name
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" MATH", "PHY001", 100);
        });
        assertEquals(exception.getMessage(), "String must start with a letter.");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" MATH123", "PHY001", 100);
        });
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("12345", "PHY001", 100);
        });
        assertEquals(exception.getMessage(), "String must be alphabetical characters");

    }

    @Test
    void CE_testConstructorCode(){
        // Test constructor with invalid code
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY00", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY0011", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "MATH", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "12345", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY001m", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "123PHMc", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
    }

    @Test
    void CE_testConstructorFullMark() {
        // Test constructor with invalid full mark
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY001", 50);
        });
        assertEquals(exception.getMessage(),"Full Mark must be 100");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY001", 120);
        });
        assertEquals(exception.getMessage(),"Full Mark must be 100");
    }

}