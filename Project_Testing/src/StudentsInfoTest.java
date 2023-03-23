import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.*;

class StudentsInfoTest {
    StudentsInfo student;

    @BeforeEach
    void setUp(){
        StudentsInfo.usedIDs.clear();
        student = new StudentsInfo("George", "12345678", 10.0, 10.0, 20.0, 60.0);
    }
    @Test
    void testConstructor() {
        StudentsInfo student = new StudentsInfo("John Doe", "1234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals("John Doe", student.getName());
        assertEquals("1234567p", student.getID());
        assertEquals(8.5, student.getActivities());
        assertEquals(9.0, student.getPractical());
        assertEquals(16.0, student.getMidterm());
        assertEquals(45.0, student.getFinal());
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo(" John Doe", "1234567p", 8.5, 9.0, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("123", "1234567p", 8.5, 9.0, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "123456xp", 8.5, 9.0, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "123453p", 8.5, 9.0, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234537p", -10, 9.0, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234547p", 12, 9.0, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234517p", 8.5, 20, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234267p", 8.5, -1, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234367p", 8.5, 9.0, 25.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234767p", 8.5, 9.0, -10, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234067p", 8.5, 9.0, 16.0, 100.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo("John Doe", "1234267p", 8.5, 9.0, 16.0, 45.0));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> new StudentsInfo(" John 1Doe", "1224567p", -10, 20.0, -1, 100));
    }

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
    @Test
    void ActivitiesTest(){
        student.setActivities(10);
        assertEquals(10, student.getActivities());
        student.setActivities(0);
        assertEquals(0, student.getActivities());
        student.setActivities(5.5);
        assertEquals(5.5, student.getActivities());
        student.setActivities(9.99);
        assertEquals(9.99, student.getActivities());
        assertThrows(IllegalArgumentException.class, () -> student.setActivities(100));
        assertThrows(IllegalArgumentException.class, () -> student.setActivities(-10));
    }
    @Test
    void MidtermTest(){
        student.setMidterm(20.0);
        assertEquals(20.0, student.getMidterm());
        student.setMidterm(0);
        assertEquals(0, student.getMidterm());
        student.setMidterm(3.8);
        assertEquals(3.8, student.getMidterm());
        student.setMidterm(17.5);
        assertEquals(17.5, student.getMidterm());
        assertThrows(IllegalArgumentException.class, () -> student.setMidterm(100));
        assertThrows(IllegalArgumentException.class, () -> student.setMidterm(-1));
    }
    @Test
    void FinalTest(){
        student.setFinal(60.0);
        assertEquals(60.0, student.getFinal());
        student.setFinal(35.5);
        assertEquals(35.5, student.getFinal());
        student.setFinal(0);
        assertEquals(0, student.getFinal());
        assertThrows(IllegalArgumentException.class, () -> student.setFinal(-20));
        assertThrows(IllegalArgumentException.class, () -> student.setFinal(61));
    }
}