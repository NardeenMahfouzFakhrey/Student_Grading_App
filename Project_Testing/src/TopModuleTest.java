import org.junit.jupiter.api.Test;

//import static org.junit.Assert.*;
import java.io.IOException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TopModuleTest {
    String filePath;
    Exception exception;

    @Test
    public void topModuleTest1() throws IOException {
        TopModule topModule = new TopModule();

        filePath = "EmptyFile.txt";
        assertThrows(NoSuchElementException.class, () -> {
            topModule.TopModule(filePath);
        });
        filePath = "Invalid_File_Path";
        assertThrows(NullPointerException.class, () -> {
            topModule.TopModule(filePath);
        });
    }

    //Test Correct Inputs
    @Test
    public void topModuleTest2() throws IOException {
        filePath = "FileReaderTest.txt";
        TopModule topModule = new TopModule();
        topModule.TopModule(filePath);
        //Correct Course Details
        assertEquals("Math", topModule.getCourse().getName());
        assertEquals("PHM123s", topModule.getCourse().getCode());
        assertEquals(100, topModule.getCourse().getFullMark());
        //Correct Student Details
        //Student 0
        assertEquals("Mariam", topModule.getCourse().getStudents().get(0).getName());
        assertEquals("12345679",topModule.getCourse().getStudents().get(0).getID());
        assertEquals(9,topModule.getCourse().getStudents().get(0).getActivities());
        assertEquals(7,topModule.getCourse().getStudents().get(0).getPractical());
        assertEquals(20,topModule.getCourse().getStudents().get(0).getMidterm());
        assertEquals(45,topModule.getCourse().getStudents().get(0).getFinal());
        //Student 1
        assertEquals("George", topModule.getCourse().getStudents().get(1).getName());
        assertEquals("12345770",topModule.getCourse().getStudents().get(1).getID());
        assertEquals(8,topModule.getCourse().getStudents().get(1).getActivities());
        assertEquals(9,topModule.getCourse().getStudents().get(1).getPractical());
        assertEquals(19,topModule.getCourse().getStudents().get(1).getMidterm());
        assertEquals(59,topModule.getCourse().getStudents().get(1).getFinal());
        //Student 2
        assertEquals("Nardeen", topModule.getCourse().getStudents().get(2).getName());
        assertEquals("12345670",topModule.getCourse().getStudents().get(2).getID());
        assertEquals(10,topModule.getCourse().getStudents().get(2).getActivities());
        assertEquals(10,topModule.getCourse().getStudents().get(2).getPractical());
        assertEquals(20,topModule.getCourse().getStudents().get(2).getMidterm());
        assertEquals(60,topModule.getCourse().getStudents().get(2).getFinal());
        //Get Grade
        assertEquals("B",topModule.Grades.get(0).getGrade());
        assertEquals("A",topModule.Grades.get(1).getGrade());
        assertEquals("A+",topModule.Grades.get(2).getGrade());
        //Get GPA Value
        assertEquals(3,topModule.Grades.get(0).getGpaValue());
        assertEquals(4,topModule.Grades.get(1).getGpaValue());
        assertEquals(4,topModule.Grades.get(2).getGpaValue());

    }

    //Incorrect Course Name
    @Test
    public void topModuleTest3() throws IOException {
        filePath = "TestFile1.txt";
        TopModule topModule = new TopModule();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            topModule.TopModule(filePath);
        });
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
    }

    @Test
    public void topModuleTest4() throws IOException {
        filePath = "TestFile2.txt";
        TopModule topModule = new TopModule();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            topModule.TopModule(filePath);
        });
        assertEquals(exception.getMessage(), "Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
    }
    @Test
    public void topModuleTest5() throws IOException {
        filePath = "TestFile3.txt";
        TopModule topModule = new TopModule();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            topModule.TopModule(filePath);
        });
        assertEquals(exception.getMessage(), "String must be alphabetical characters and start with a letter.");
    }
    @Test
    public void topModuleTest6() throws IOException {
        filePath = "TestFile4.txt";
        TopModule topModule = new TopModule();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            topModule.TopModule(filePath);
        });
        assertEquals(exception.getMessage(), "Final grade must be between 0 and 60");
    }
    @Test
    public void topModuleTest7() throws IOException {
        filePath = "TestFile5.txt";
        TopModule topModule = new TopModule();
        exception = assertThrows(IllegalArgumentException.class, () -> {
            topModule.TopModule(filePath);
        });
        assertEquals(exception.getMessage(), "Student ID must be unique");
    }
}