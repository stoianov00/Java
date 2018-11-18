package pr_7;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    Student(String firstName, String lastName, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
