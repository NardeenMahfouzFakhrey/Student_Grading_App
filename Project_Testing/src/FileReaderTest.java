import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class FileReaderTest {

    CourseInfo courseInfo;

    @Test
    void readFile() {

        courseInfo = FileReader.readFile("Project_Testing/FileReaderTest.txt");
        assertEquals("Math", courseInfo.getName());
        assertEquals("PHM123s", courseInfo.getCode());
        assertEquals(100, courseInfo.getFullMark());

        assertEquals("Mariam", courseInfo.getStudents().get(0).getName());
        assertEquals("12345679", courseInfo.getStudents().get(0).getID());
        assertEquals(9, courseInfo.getStudents().get(0).getActivities());
        assertEquals(7, courseInfo.getStudents().get(0).getPractical());
        assertEquals(20, courseInfo.getStudents().get(0).getMidterm());
        assertEquals(45, courseInfo.getStudents().get(0).getFinal());

        assertEquals("Nardeen", courseInfo.getStudents().get(2).getName());
        assertEquals("12345670", courseInfo.getStudents().get(2).getID());
        assertEquals(10, courseInfo.getStudents().get(2).getActivities());
        assertEquals(10, courseInfo.getStudents().get(2).getPractical());
        assertEquals(20, courseInfo.getStudents().get(2).getMidterm());
        assertEquals(60, courseInfo.getStudents().get(2).getFinal());

        assertThrows(NullPointerException.class, () -> {
            FileReader.readFile("Invalid_File_Path");
        });

        assertThrows(NoSuchElementException.class, () -> {
            FileReader.readFile("Project_Testing/EmptyFile.txt");
        });


    }
}
