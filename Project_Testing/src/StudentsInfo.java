public class StudentsInfo {
    String Name;
    double ID;
    double Activities;
    double Practical;
    double Midterm;
    double Final;

    public StudentsInfo() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getID() {
        return ID;
    }

    public void setID(double ID) {
        this.ID = ID;
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