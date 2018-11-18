package p_11;

public class Student {
    private String studentName;
    private String facultyNumber;

    public Student(String studentName, String facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }
}
