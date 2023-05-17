import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentInfoECPTest {
    StudentsInfo student;
    Exception exception;

    @BeforeEach
    void setUp(){
        StudentsInfo.usedIDs.clear();
        student = new StudentsInfo("George", "12345678", 10.0, 10.0, 20.0, 60.0);
    }
    //Black Box Equivalence Class Partitioning Technique
    @Test
    void ECP_testConstructorName(){
        //Invalid name that starts with a white sapce
        String expectedMsg = "String must start with a letter.";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo(" John Doe", "1234567p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Invalid name that has not alphabetical characters
        expectedMsg = "String must be alphabetical characters";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("123", "1234567p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Invalid name that starts with a space and has some not alphabetical characters.
        expectedMsg = "String must be alphabetical characters and start with a letter.";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo(" John123", "2234567p", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Valid name
        String expectedName = "John Doe";
        StudentsInfo s = new StudentsInfo("John Doe", "2234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals(expectedName, s.getName());
    }

    @Test
    void ECP_testConstructorID(){
        //Invalid ID that is not unique
        String expectedMsg = "Student ID must be unique";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "12345678", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Invalid ID that has an incorrect length (less than 8 digits)
        expectedMsg = "Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "123456", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Invalid ID that has an incorrect length (greater than 8 digits)
        expectedMsg = "Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "123456789", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Invalid ID that has alphabetical characters in the first 7 characters
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "123456xp", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Invalid ID that has invalid characters
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "12*4567/", 8.5, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Valid ID that has a number as the last character
        String expectedID = "22345670";
        StudentsInfo s = new StudentsInfo("John Doe", "22345670", 8.5, 9.0, 16.0, 45.0);
        assertEquals(expectedID, s.getID());

        //Valid ID that has an alphabetical character as last character
        expectedID = "2234567p";
        s = new StudentsInfo("John Doe", "2234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals(expectedID, s.getID());
    }

    @Test
    void ECP_testConstructorActivities(){
        //Invalid Activities grade (less than 0)
        String expectedMsg = "Activities grade must be between 0 and 10";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234537p", -10, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Invalid Activities grade (greater than 10)
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234547p", 12, 9.0, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //Valid Activities grade
        double expectedActivities = 8.5;
        StudentsInfo s = new StudentsInfo("John Doe", "2234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals(expectedActivities, s.getActivities());
    }

    @Test
    void ECP_testConstructorPractical(){
        //invalid Practical grade less than 0
        String expectedMsg = "Practical grade must be between 0 and 10";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234267p", 8.5, -1, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //invalid Practical grade greater than 10
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234517p", 8.5, 20, 16.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //valid Practical grade
        double expectedPractical = 9.0;
        StudentsInfo s = new StudentsInfo("John Doe", "2234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals(expectedPractical, s.getPractical());
    }

    @Test
    void ECP_testConstructorMidterm(){
        //invalid Midterm grade less than 0
        String expectedMsg = "Midterm grade must be between 0 and 20";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234767p", 8.5, 9.0, -10, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //invalid Midterm grade greater than 20
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "1234367p", 8.5, 9.0, 25.0, 45.0));
        assertEquals(expectedMsg, exception.getMessage());

        //valid Midterm grade
        double expectedMidterm = 16.0;
        StudentsInfo s = new StudentsInfo("John Doe", "2234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals(expectedMidterm, s.getMidterm());
    }

    @Test
    void ECP_testConstructorFinal(){
        //invalid Final grade less than 0
        String expectedMsg = "Final grade must be between 0 and 60";
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "8234267p", 8.5, 9.0, 16.0, -60));
        assertEquals(expectedMsg, exception.getMessage());

        //invalid Final grade greater than 60
        exception = assertThrows(IllegalArgumentException.class, ()->
                new StudentsInfo("John Doe", "7234067p", 8.5, 9.0, 16.0, 100.0));
        assertEquals(expectedMsg, exception.getMessage());

        //valid Final grade
        double expectedFinal = 45.0;
        StudentsInfo s = new StudentsInfo("John Doe", "2234567p", 8.5, 9.0, 16.0, 45.0);
        assertEquals(expectedFinal, s.getFinal());
    }
}
