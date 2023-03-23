import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GradingCalculator {

    public String grade="";
    public double gpaValue=0;

    public static GradingCalculator CalculateGrade(StudentsInfo student) {
        double totalDegree = TotalSummation(student);
        GradingCalculator gradingCalculator = new GradingCalculator();

        if (totalDegree > 100) {
            gradingCalculator.grade = "invalid";
            throw new IllegalArgumentException("The total Degree must be equal 100 or less");
        } else if (totalDegree < 0) {
            gradingCalculator.grade = "invalid";
            throw new IllegalArgumentException("The total Degree must be Positive Number");
        } else if (totalDegree >= 97 && totalDegree <= 100) {
            gradingCalculator.grade = "A+";
            gradingCalculator.gpaValue = 4;
        } else if (totalDegree >= 93 && totalDegree < 97) {
            gradingCalculator.grade = "A";
            gradingCalculator.gpaValue = 4;
        } else if (totalDegree >= 89 && totalDegree < 93) {
            gradingCalculator.grade = "A-";
            gradingCalculator.gpaValue = 3.7;
        } else if (totalDegree >= 84 && totalDegree < 89) {
            gradingCalculator.grade = "B+";
            gradingCalculator.gpaValue = 3.3;
        } else if (totalDegree >= 80 && totalDegree < 84) {
            gradingCalculator.grade = "B";
            gradingCalculator.gpaValue = 3;
        } else if (totalDegree >= 76 && totalDegree < 80) {
            gradingCalculator.grade = "B-";
            gradingCalculator.gpaValue = 2.7;
        } else if (totalDegree >= 73 && totalDegree < 76) {
            gradingCalculator.grade = "C+";
            gradingCalculator.gpaValue = 2.3;
        } else if (totalDegree >= 70 && totalDegree < 73) {
            gradingCalculator.grade = "C";
            gradingCalculator.gpaValue = 2;
        } else if (totalDegree >= 67 && totalDegree < 70) {
            gradingCalculator.grade = "C-";
            gradingCalculator.gpaValue = 1.7;
        } else if (totalDegree >= 64 && totalDegree < 67) {
            gradingCalculator.grade = "D+";
            gradingCalculator.gpaValue = 1.3;
        } else if (totalDegree >= 60 && totalDegree < 64) {
            gradingCalculator.grade = "D";
            gradingCalculator.gpaValue = 1;
        } else if (totalDegree < 60) {
            gradingCalculator.grade = "F";
            gradingCalculator.gpaValue = 0;
        }

        return gradingCalculator;
    }

    public static double TotalSummation(StudentsInfo student) {
        return student.getPractical() + student.getActivities() + student.getMidterm() + student.getFinal();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGpaValue() {
        return gpaValue;
    }

    public void setGpaValue(double gpaValue) {
        this.gpaValue = gpaValue;
    }

    @Override
    public String toString() {
        return grade +","+gpaValue+"\n";
    }
    public static void SaveGrade(ArrayList<StudentsInfo> studentsInfos) throws IOException {
        FileWriter file = new FileWriter("output.txt");
        BufferedWriter output = new BufferedWriter(file);

        for (StudentsInfo object : studentsInfos) {
            output.write(object.toString());
            GradingCalculator g= GradingCalculator.CalculateGrade(object);
           output.write(g.toString());
        }

        output.close();
    }
}

