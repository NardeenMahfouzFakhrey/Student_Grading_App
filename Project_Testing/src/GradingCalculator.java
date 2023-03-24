import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingCalculator {

    public String grade="";
    public double gpaValue=0;

    public static GradingCalculator CalculateGrade( double Activities,double Practical,double Midterm,double Final) {
        double totalDegree = TotalSummation(Activities,Practical, Midterm,Final);
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

    public static double TotalSummation( double activities,double practical,double midterm,double afinal) {
        if (! (midterm >=0 && midterm <=20)) {
            throw new IllegalArgumentException("Midterm grade must be between 0 and 20");
        }
        if (! (practical >= 0 && practical <= 10 )) {
            throw new IllegalArgumentException("Practical grade must be between 0 and 10");
        }
        if (!(activities >= 0 && activities <= 10)) {
            throw new IllegalArgumentException("Activities grade must be between 0 and 10");
        }
        if (! (afinal >=0 && afinal <=60)) {
            throw new IllegalArgumentException("Final grade must be between 0 and 60");
        }

        return activities+practical+midterm+afinal;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        String[] grades = new String[]{ "A+", "A", "A-", "B+", "B" , "B-", "C+" , "C" , "C-" , "D+" , "D" , "F"};
        List<String> Grades = new ArrayList<>(Arrays.asList(grades));
        if(!Grades.contains(grade)) {
            throw  new IllegalArgumentException("inValid GPA Value");
        }
        else this.grade = grade;
    }

    public double getGpaValue() {
        return gpaValue;
    }

    public void setGpaValue(double gpaValue) {
         Double [] gpaValues= new Double[] {1.0,1.3,1.7,2.0,2.3,3.0,3.3,3.7,4.0};
        List<Double> GPAList = new ArrayList<Double>(Arrays.<Double>asList(gpaValues));
        if(!GPAList.contains(gpaValue) )
        {throw new IllegalArgumentException("InValid GPA Number");}
        else this.gpaValue = gpaValue;
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
            GradingCalculator g= GradingCalculator.CalculateGrade(object.Activities ,object.Practical , object.Midterm , object.Final);
           output.write(g.toString());
        }

        output.close();
    }
}

