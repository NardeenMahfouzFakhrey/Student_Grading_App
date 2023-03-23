public class CourseInfo {
    String Name;
    String Code;
    int FullMark;

    public CourseInfo(String name, String code, int fullMark) {
        Name = name;
        Code = code;
        FullMark = fullMark;
    }

    public CourseInfo() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getFullMark() {
        return FullMark;
    }

    public void setFullMark(int fullMark) {
        FullMark = fullMark;
    }
}
