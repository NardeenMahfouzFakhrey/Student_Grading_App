import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {


    public static CourseInfo readFile(String filename) {
        ArrayList<StudentsInfo> objects = new ArrayList<>();
        CourseInfo course = null;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            String line = scanner.nextLine();
            String[] data = line.split(",");

            course = new CourseInfo(data[0],data[1],Integer.parseInt(data[2]));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                data = line.split(",");


                if (data.length == 6) {
                    StudentsInfo object = new StudentsInfo(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]));
                    objects.add(object);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        course.setStudents(objects);
        return course;
    }

}
