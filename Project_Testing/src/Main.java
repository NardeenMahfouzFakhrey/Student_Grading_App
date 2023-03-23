import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePath = "Sample.txt";

            ArrayList<StudentsInfo> objects = FileReader.readFile(filePath);


            System.out.println("Name: " + FileReader.course.getName());
            System.out.println("ID: " + FileReader.course.getCode());
            System.out.println("Full Mark: " + FileReader.course.getFullMark());
            System.out.println();

            // iterate over the list of objects and print their values
            for (StudentsInfo object : objects) {
                System.out.println("Name: " + object.getName());
                System.out.println("ID: " + object.getID());
                System.out.println("Activities: " + object.getActivities());
                System.out.println("Practical: " + object.getPractical());
                System.out.println("Midterms: " + object.getMidterm());
                System.out.println("Final: " + object.getFinal());
                System.out.println();
            }
    }
}