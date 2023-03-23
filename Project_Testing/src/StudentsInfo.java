public class StudentsInfo {
    String Name;
    String ID;
    double Activities;
    double Practical;
    double Midterm;
    double Final;

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
            this.ID = ID;
        }
        else if (ID.length() != 8 || !(ID.matches("\\d{7}[a-zA-Z]") || ID.matches("\\d{8}")) ){
            throw new IllegalArgumentException("Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        }
        Activities = activities;
        Practical = practical;
        Midterm = midterm;
        Final = aFinal;
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
            this.ID = ID;
        }
        else if (ID.length() != 8 || !(ID.matches("\\d{7}[a-zA-Z]") || ID.matches("\\d{8}")) ){
            throw new IllegalArgumentException("Student ID must contain 8 digits where all digits are numeric or last digit only is alphabetic character");
        }
    }

    public double getActivities() {
        return Activities;
    }

    public void setActivities(double activities) {
        Activities = activities;
    }

    public double getPractical() {
        return Practical;
    }

    public void setPractical(double practical) {
        Practical = practical;
    }

    public double getMidterm() {
        return Midterm;
    }

    public void setMidterm(double midterm) {
        Midterm = midterm;
    }

    public double getFinal() {
        return Final;
    }

    public void setFinal(double aFinal) {
        Final = aFinal;
    }
}