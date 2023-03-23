import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.*;

class StudentsInfoTest {
    StudentsInfo student;

    @BeforeEach
    void setUp(){
        student = new StudentsInfo("George", "12345678", 10.0, 10.0, 20.0, 60.0);
    }
    /*@Test
    void testConstructor() {
        StudentsInfo student = new StudentsInfo("John Doe", "12345678", 8.5, 9.0, 16.0, 45.0);
        assertEquals("John Doe", student.getName());
        assertEquals("12345678", student.getID());
        assertEquals(8.5, student.getActivities());
        assertEquals(9.0, student.getPractical());
        assertEquals(16.0, student.getMidterm());
        assertEquals(45.0, student.getFinal());
    }*/

    @Test
    void StudentNameTest(){
        student.setName("John");
        assertEquals("John",student.getName());
        student.setName("John Miller");
        assertEquals("John Miller",student.getName());
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setName(" John"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setName(" John Miller"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setName("John1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setName(" John1"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setName(" 123"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.setName("123"));
    }
    @Test
    void IDTest() {
        StudentsInfo student = new StudentsInfo();
        student.setID("87654321");
        assertEquals("87654321", student.getID());
        student.setID("1234567s");
        assertEquals("1234567s", student.getID());
        assertThrows(IllegalArgumentException.class, () -> student.setID("123"));
        assertThrows(IllegalArgumentException.class, () -> student.setID(" 12345"));
        assertThrows(IllegalArgumentException.class, () -> student.setID("123456ss"));
        assertThrows(IllegalArgumentException.class, () -> student.setID(" 12345678"));
        assertThrows(IllegalArgumentException.class, () -> student.setID(" 123s5678"));
        assertThrows(IllegalArgumentException.class, () -> student.setID("1234s678"));
        assertThrows(IllegalArgumentException.class, () -> student.setID("123456789"));
    }


}