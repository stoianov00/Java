package pr_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {

            String[] input = line.split("\\s+");
            String firstName = input[0];
            String lastName = input[1];

            Student student = new Student(firstName, lastName);
            students.add(student);

            line = reader.readLine();
        }

        students.stream()
                .sorted((s1, s2) -> {
                    int comparatorByLastName = s1.getLastName().compareTo(s2.getLastName());

                    if (comparatorByLastName != 0) {
                        return comparatorByLastName;
                    }

                    return s2.getFirstName().compareTo(s1.getFirstName());
                })
                .forEach(System.out::println);

    }
}
