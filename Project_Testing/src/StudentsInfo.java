import java.util.HashSet;

public class StudentsInfo {
    String Name;
    String ID;
    double Activities;
    double Practical;
    double Midterm;
    double Final;

    private static HashSet<String> usedIDs = new HashSet<>();
    public StudentsInfo(String name, String ID, double activities, double practical, double midterm, double aFinal) {
        if (name.matches("[a-zA-Z ]+") && name.charAt(0) != ' ') {
            Name = name;
        } else if (name.charAt(0)== ' ' && !name.matches("[a-zA-Z ]+")){
            throw new IllegalArgumentException(("String must be alphabetical characters and start with a letter."));
        }
        else if(name.charAt(0)== ' '){
            throw new IllegalArgumentException("String must start with a letter.");
        }else {
            throw new IllegalArgumentException("String must be alphabetical characters");
        }
        if(ID.length() == 8 && ID.matches("\\d{7}[a-zA-Z]") || ID.matches("\\d{8}")) {
            if (usedIDs.contains(ID)) {
                throw new IllegalArgumentException("Student ID must be unique");
            }
            this.ID = ID;
            usedIDs.add(ID);
        }
        else if (ID.length() != 8 || !(ID.matches("\\d{7}[a-zA-Z]") || ID.matches("\\d{8}")) ){
            throw new IllegalArgumentException("Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        }
        if (activities >= 0 && activities <= 10) {
            Activities = activities;
        } else {
            throw new IllegalArgumentException("Activities grade must be between 0 and 10");
        }
        if (practical >= 0 && practical <= 10) {
            Practical = practical;
        } else {
            throw new IllegalArgumentException("Practical grade must be between 0 and 10");
        }
        if (midterm >=0 && midterm <=20) {
            Midterm = midterm;
        }else {
            throw new IllegalArgumentException("Midterm grade must be between 0 and 20");
        }
        if (aFinal >=0 && aFinal <=60) {
            Final = aFinal;
        }else {
            throw new IllegalArgumentException("Final grade must be between 0 and 60");
        }
    }

    public StudentsInfo() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name.matches("[a-zA-Z ]+") && name.charAt(0) != ' ') {
            Name = name;
        } else if (name.charAt(0)== ' ' && !name.matches("[a-zA-Z ]+")){
            throw new IllegalArgumentException(("String must be alphabetical characters and start with a letter."));
        }
        else if(name.charAt(0)== ' '){
            throw new IllegalArgumentException("String must start with a letter.");
        }else {
            throw new IllegalArgumentException("String must be alphabetical characters");
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        if(ID.length() == 8 && ID.matches("\\d{7}[a-zA-Z]") || ID.matches("\\d{8}")) {
            if (usedIDs.contains(ID)) {
                throw new IllegalArgumentException("Student ID must be unique");
            }
            this.ID = ID;
            usedIDs.add(ID);
        }
        else if (ID.length() != 8 || !(ID.matches("\\d{7}[a-zA-Z]") || ID.matches("\\d{8}")) ){
            throw new IllegalArgumentException("Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        }
    }

    public double getActivities() {
        return Activities;
    }

    public void setActivities(double activities) {
        if (activities >= 0 && activities <= 10) {
            Activities = activities;
        } else {
            throw new IllegalArgumentException("Activities grade must be between 0 and 10");
        }
    }

    public double getPractical() {
        return Practical;
    }

    public void setPractical(double practical) {
        if (practical >= 0 && practical <= 10) {
            Practical = practical;
        } else {
            throw new IllegalArgumentException("Practical grade must be between 0 and 10");
        }
    }

    public double getMidterm() {
        return Midterm;
    }

    public void setMidterm(double midterm) {
        if (midterm >=0 && midterm <=20) {
            Midterm = midterm;
        }else {
            throw new IllegalArgumentException("Midterm grade must be between 0 and 20");
        }
    }

    public double getFinal() {
        return Final;
    }

    public void setFinal(double aFinal) {
        if (aFinal >=0 && aFinal <=60) {
            Final = aFinal;
        }else {
            throw new IllegalArgumentException("Final grade must be between 0 and 60");
        }
    }
}