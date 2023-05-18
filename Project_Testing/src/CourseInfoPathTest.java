import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseInfoPathTest {
    CourseInfo course;
    Exception exception;
    @Test
    void CourseInfoPathTest() {

        course = new CourseInfo("Physics", "PHM123", 100);
        assertEquals("Physics", course.getName());
        assertEquals("PHM123", course.getCode());
        assertEquals(100, course.getFullMark());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" 1Physics", "PHM123", 100);
        });
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");

        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" Physics", "PHM123", 100);
        });
        assertEquals(exception.getMessage(), "String must start with a letter.");

        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics1", "PHM123", 100);
        });
        assertEquals(exception.getMessage(), "String must be alphabetical characters");

        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHM12", 100);
        });
        assertEquals(exception.getMessage(), "Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");

        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHM123", 50);
        });
        assertEquals(exception.getMessage(), "Full Mark must be 100" );

    }
}