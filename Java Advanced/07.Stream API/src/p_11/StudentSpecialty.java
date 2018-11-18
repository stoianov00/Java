package p_11;

public class StudentSpecialty {
    private String specialtyName;
    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return this.specialtyName;
    }

    public String getFacultyNumber() {
        return this.facultyNumber;
    }
}
