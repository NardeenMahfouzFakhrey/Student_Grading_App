import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CourseInfoTest {

    CourseInfo course;
    Exception exception;
    @BeforeEach
    void setUp(){
        course = new CourseInfo("Physics", "PHY001", 100);
    }

    @Test
    void testConstructor() {
        // Test constructor with valid inputs
        course = new CourseInfo("Physics", "PHY001", 100);
        assertEquals("Physics", course.getName());
        assertEquals("PHY001", course.getCode());
        assertEquals(100, course.getFullMark());
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
        // Test constructor with invalid code
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "MATH", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "12345", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "1234567p", 100);
        });
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
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

    @Test
    void CourseNameTest(){
        // Test setName method with valid input
        course.setName("Physics");
        assertEquals("Physics", course.getName());
        course.setName("Advanced Programming");
        assertEquals("Advanced Programming", course.getName());
        // Test setName method with invalid input
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" Physics"));
        assertEquals(exception.getMessage(), "String must start with a letter.");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" Advanced Programming"));
        assertEquals(exception.getMessage(), "String must start with a letter.");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName("Physics1"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" Physics1"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName("123Physics"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" 123"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName("123"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters");
    }

    @Test
    void CodeTest(){
        // Test setCode method with valid input
        course.setCode("PHY001");
        assertEquals("PHY001", course.getCode());
        course.setCode("PHY001s");
        assertEquals("PHY001s", course.getCode());
        // Test setCode method with invalid input
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PHY00"));
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PHY001a"));
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PH6001a"));
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode(" PHY001"));
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PH001"));
        assertEquals(exception.getMessage(),"Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
    }

    @Test
    void FullMarkTest(){
        // // Test setFullMark method with valid input
        course.setFullMark(100);
        assertEquals(100, course.getFullMark());
        // Test setFullMark method with invalid input
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setFullMark(30));
        assertEquals(exception.getMessage(),"Full Mark must be 100");
        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> course.setFullMark(120));
        assertEquals(exception.getMessage(),"Full Mark must be 100");
    }

    @Test
    void testGetStudents() {
        // Test getStudents method
        CourseInfo course = new CourseInfo();
        ArrayList<StudentsInfo> students = new ArrayList<>();
        students.add(new StudentsInfo("John Doe", "12345678",5,6,7,60));
        students.add(new StudentsInfo("Jane Doe", "1234567p",8,9,15,55));
        course.setStudents(students);
        assertEquals(students, course.getStudents());
    }
}