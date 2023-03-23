import java.util.ArrayList;


public class CourseInfo {
    String Name;
    String Code;
    int FullMark;

    ArrayList<StudentsInfo> Students;

    public ArrayList<StudentsInfo> getStudents() {
        return Students;
    }

    public void setStudents(ArrayList<StudentsInfo> students) {
        Students = students;
    }

    public CourseInfo(String name, String code, int fullMark) {
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
        if((code.length() == 6 && code.charAt(5) != 's' && code.matches("^[a-zA-Z0-9]*$") ) || (code.length() == 7 && code.charAt(6) == 's' && code.matches("^[a-zA-Z0-9]*$"))){
            Code = code;
        }else {
            throw new IllegalArgumentException("Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        }
        if (fullMark == 100){
            FullMark = fullMark;
        }else {
            throw new IllegalArgumentException("Full Mark must be 100");
        }
    }

    public CourseInfo() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if (name.matches("[a-zA-Z]+")) {
            Name = name;
        } else {
            throw new IllegalArgumentException("String must be alphabetical characters and start with a letter.");
        }
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        if((code.length() == 6 && code.charAt(5) != 's' && code.matches("^[a-zA-Z0-9]*$") ) || (code.length() == 7 && code.charAt(6) == 's' && code.matches("^[a-zA-Z0-9]*$"))){
            Code = code;
        }else {
            throw new IllegalArgumentException("Subject code must be 6 or 7 Alphanumeric characters with letter[7] is s");
        }
    }

    public int getFullMark() {
        return FullMark;
    }

    public void setFullMark(int fullMark) {
        if (fullMark == 100){
            FullMark = fullMark;
        }else {
            throw new IllegalArgumentException("Full Mark must be 100");
        }
    }
}
