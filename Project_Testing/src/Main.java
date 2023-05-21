import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "Sample.txt";
            //arraylist of students info objects
            CourseInfo Course = FileReader.readFile(filePath);

            System.out.println("Name: " + Course.getName());
            System.out.println("ID: " + Course.getCode());
            System.out.println("Full Mark: " + Course.getFullMark());
            System.out.println();

            // iterate over the list of objects and print their values
            for (StudentsInfo object : Course.Students) {
                System.out.println("Name: " + object.getName());
                System.out.println("ID: " + object.getID());
                System.out.println("Activities: " + object.getActivities());
                System.out.println("Practical: " + object.getPractical());
                System.out.println("Midterms: " + object.getMidterm());
                System.out.println("Final: " + object.getFinal());
                System.out.println();
            }

          //calculate each student grade
            for (StudentsInfo object : Course.Students) {
                System.out.println("Name: " + object.getName());
                System.out.println("ID: " + object.getID());
                System.out.println(GradingCalculator.CalculateGrade(object.Activities ,object.Practical , object.Midterm , object.Final));
            }
            GradingCalculator.SaveGrade(Course.Students);

    }
}