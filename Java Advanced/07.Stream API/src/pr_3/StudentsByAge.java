package pr_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {

            String[] input = line.split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);

            Student student = new Student(firstName, lastName, age);
            students.add(student);

            line = reader.readLine();
        }

        students.stream()
                .filter(s -> s.getAge() >= 18 && s.getAge() <= 24)
                .forEach(System.out::println);

    }
}
