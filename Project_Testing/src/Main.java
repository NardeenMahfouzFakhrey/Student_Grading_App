import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\georg\\Desktop\\Sample.xlsx";

        try {
            ArrayList<StudentsInfo> objects = ExcelReader.readExcel(filePath);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}