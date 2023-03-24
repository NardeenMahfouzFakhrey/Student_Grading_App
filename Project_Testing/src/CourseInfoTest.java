import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CourseInfoTest {

    CourseInfo course;
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
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" MATH", "PHY001", 100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo(" MATH123", "PHY001", 100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("12345", "PHY001", 100);
        });
        // Test constructor with invalid code
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "MATH", 100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "12345", 100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "1234567p", 100);
        });
        // Test constructor with invalid full mark
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY001", 50);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            course = new CourseInfo("Physics", "PHY001", 120);
        });
    }

    @Test
    void CourseNameTest(){
        // Test setName method with valid input
        course.setName("Physics");
        assertEquals("Physics", course.getName());
        course.setName("Advanced Programming");
        assertEquals("Advanced Programming", course.getName());
        // Test setName method with invalid input
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" Physics"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" Advanced Programming"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName("Physics1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" Physics1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName("123Physics"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName(" 123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setName("123"));
    }

    @Test
    void CodeTest(){
        // Test setCode method with valid input
        course.setCode("PHY001");
        assertEquals("PHY001", course.getCode());
        course.setCode("PHY001s");
        assertEquals("PHY001s", course.getCode());
        // Test setCode method with invalid input
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PHY00"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PHY001a"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PH6001a"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode(" PHY001"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setCode("PH001"));
    }

    @Test
    void FullMarkTest(){
        // // Test setFullMark method with valid input
        course.setFullMark(100);
        assertEquals(100, course.getFullMark());
        // Test setFullMark method with invalid input
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setFullMark(30));
        Assertions.assertThrows(IllegalArgumentException.class, () -> course.setFullMark(120));
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