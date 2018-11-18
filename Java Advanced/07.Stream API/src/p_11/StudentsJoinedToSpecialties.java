package p_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsJoinedToSpecialties {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> studentSpecialties = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        String line;
        while (true) {
            if ("Students:".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");

            String specialTyNameFirst = tokens[0];
            String specialTyNameSecond = tokens[1];
            String facultyNumber = tokens[2];

            StudentSpecialty studentSpecialty = new StudentSpecialty(specialTyNameFirst + " " + specialTyNameSecond, facultyNumber);
            studentSpecialties.add(studentSpecialty);

        }

        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] input = line.split("\\s+");

            String facultyNumber = input[0];
            String studentFirstName = input[1];
            String studentLastName = input[2];

            Student student = new Student(studentFirstName + " " + studentLastName, facultyNumber);
            students.add(student);
        }

        students.sort(Comparator.comparing(Student::getStudentName));

        students
                .forEach(student ->
                        studentSpecialties.forEach(specialty -> {
                            if (specialty.getFacultyNumber().equals(student.getFacultyNumber())) {
                                System.out.println(String.format("%s %s %s",
                                        student.getStudentName(),
                                        student.getFacultyNumber(),
                                        specialty.getSpecialtyName()));
                            }
                        }));

    }
}
