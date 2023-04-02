import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


import static org.junit.jupiter.api.Assertions.*;

class StudentsInfoTest {
    StudentsInfo student;
    Exception exception;

    @BeforeEach
    void setUp(){
        StudentsInfo.usedIDs.clear();
        student = new StudentsInfo("George", "12345678", 10.0, 10.0, 20.0, 60.0);
    }
    @Test
    void testConstructor() {
        // Test constructor with valid inputs
        student = new StudentsInfo("John Doe", "1234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals("John Doe", student.getName());
        assertEquals("1234567p", student.getID());
        assertEquals(8.5, student.getActivities());
        assertEquals(9.0, student.getPractical());
        assertEquals(16.0, student.getMidterm());
        assertEquals(45.0, student.getFinal());
        // Test constructor with invalid inputs
        //Invalid Student name
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo(" John Doe", "1234567p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "String must start with a letter.");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("123", "1234567p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "String must be alphabetical characters");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo(" John123", "2234567p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
        //Invalid student ID
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "123456xp", 8.5, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "123453p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234567p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "Student ID must be unique");
        //invalid Activities grade
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234537p", -10, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234547p", 12, 9.0, 16.0, 45.0));
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");
        //invalid Practical grade
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234517p", 8.5, 20, 16.0, 45.0));
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234267p", 8.5, -1, 16.0, 45.0));
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");
        //invalid Midterm grade
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234367p", 8.5, 9.0, 25.0, 45.0));
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234767p", 8.5, 9.0, -10, 45.0));
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");
        //invalid Final grade
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "7234067p", 8.5, 9.0, 16.0, 100.0));
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "8234267p", 8.5, 9.0, 16.0, -60));
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");

        Assertions.assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo(" John 1Doe", "12234567p", -10, 20.0, -1, 100));
    }

    @Test
    void StudentNameTest(){
        // Test setName method with valid input
        student.setName("John");
        assertEquals("John",student.getName());
        student.setName("John Miller");
        assertEquals("John Miller",student.getName());
        // Test setName method with invalid input
        exception = assertThrows(IllegalArgumentException.class, () -> student.setName(" John"));
        assertEquals(exception.getMessage(), "String must start with a letter.");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setName(" John Miller"));
        assertEquals(exception.getMessage(), "String must start with a letter.");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setName("John1"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setName(" John1"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setName(" 123"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setName("123"));
        assertEquals(exception.getMessage(), "String must be alphabetical characters");
    }
    @Test
    void IDTest() {
        // Test setID method with valid input
        student.setID("87654321");
        assertEquals("87654321", student.getID());
        student.setID("1234567s");
        assertEquals("1234567s", student.getID());
        // Test setID method with invalid input
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID("1234567s"));
        assertEquals(exception.getMessage(),"Student ID must be unique");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID("123"));
        assertEquals(exception.getMessage(),"Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID(" 12345"));
        assertEquals(exception.getMessage(),"Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID("123456ss"));
        assertEquals(exception.getMessage(),"Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID(" 12345678"));
        assertEquals(exception.getMessage(),"Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID(" 123s5678"));
        assertEquals(exception.getMessage(),"Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID("1234s678"));
        assertEquals(exception.getMessage(),"Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setID("123456789"));
        assertEquals(exception.getMessage(),"Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
    }
    @Test
    void ActivitiesTest(){
        // Test setActivities method with valid input
        student.setActivities(10);
        assertEquals(10, student.getActivities());
        student.setActivities(0);
        assertEquals(0, student.getActivities());
        student.setActivities(5.5);
        assertEquals(5.5, student.getActivities());
        student.setActivities(9.99);
        assertEquals(9.99, student.getActivities());
        // Test setActivities method with invalid input
        exception = assertThrows(IllegalArgumentException.class, () -> student.setActivities(100));
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setActivities(-10));
        assertEquals(exception.getMessage(), "Activities grade must be between 0 and 10");
    }
    @Test
    void PracticalTest(){
        // Test setPractical method with valid input
        student.setPractical(10);
        assertEquals(10, student.getPractical());
        student.setPractical(0);
        assertEquals(0, student.getPractical());
        student.setPractical(7.8);
        assertEquals(7.8, student.getPractical());
        student.setPractical(3.5);
        assertEquals(3.5, student.getPractical());
        // Test of setPractical method with invalid input
        exception = assertThrows(IllegalArgumentException.class, () -> student.setPractical(11));
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setPractical(-1));
        assertEquals(exception.getMessage(), "Practical grade must be between 0 and 10");
    }


    @Test
    void MidtermTest(){
        // Test setMidterm method with valid input
        student.setMidterm(20.0);
        assertEquals(20.0, student.getMidterm());
        student.setMidterm(0);
        assertEquals(0, student.getMidterm());
        student.setMidterm(3.8);
        assertEquals(3.8, student.getMidterm());
        student.setMidterm(17.5);
        assertEquals(17.5, student.getMidterm());
        // Test setMidterm method with invalid input
        exception = assertThrows(IllegalArgumentException.class, () -> student.setMidterm(100));
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setMidterm(-1));
        assertEquals(exception.getMessage(), "Midterm grade must be between 0 and 20");
    }
    @Test
    void FinalTest(){
        // Test setFinal method with valid input
        student = new StudentsInfo();
        student.setFinal(60.0);
        assertEquals(60.0, student.getFinal());
        student.setFinal(35.5);
        assertEquals(35.5, student.getFinal());
        student.setFinal(0);
        assertEquals(0, student.getFinal());
        // Test setFinal method with invalid input
        exception = assertThrows(IllegalArgumentException.class, () -> student.setFinal(-20));
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");
        exception = assertThrows(IllegalArgumentException.class, () -> student.setFinal(61));
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");
    }

    @Test
    public void testToString() {
        student = new StudentsInfo("John Doe", "01234567",10,7,13,56);

        String expectedOutput = "StudentsInfo{" +
                "Name='John Doe', " +
                "ID='01234567', " +
                "Activities=10.0, " +
                "Practical=7.0, " +
                "Midterm=13.0, " +
                "Final=56.0" +
                "}";

        assertEquals(expectedOutput, student.toString());
    }
}