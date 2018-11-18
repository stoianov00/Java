package pr_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExcellentStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {

            String[] input = line.split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            List<Integer> grades = new ArrayList<>() {{
                add(Integer.parseInt(input[2]));
                add(Integer.parseInt(input[3]));
                add(Integer.parseInt(input[4]));
                add(Integer.parseInt(input[5]));
            }};

            Student student = new Student(firstName, lastName, grades);
            students.add(student);

            line = reader.readLine();
        }

        students.stream()
                .filter(s -> s.getGrades().indexOf(6) >= 0)
                .forEach(System.out::println);

    }
}
