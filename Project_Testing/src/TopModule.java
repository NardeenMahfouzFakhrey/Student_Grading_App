import java.io.IOException;
import java.util.ArrayList;
public class TopModule {
    CourseInfo course;

    GradingCalculator gradingCalculator;
    ArrayList<GradingCalculator> Grades = new ArrayList<>();

    public ArrayList<GradingCalculator> getGradingCalculator() {
        return Grades;
    }

    public CourseInfo getCourse() {
        return course;
    }

    void TopModule(String filePath) throws IOException {
        course = FileReader.readFile(filePath);
        gradingCalculator.SaveGrade(course.Students);
        for (StudentsInfo object : course.Students) {
            Grades.add(GradingCalculator.CalculateGrade(object.Activities ,object.Practical , object.Midterm , object.Final));
        }

    }



}
