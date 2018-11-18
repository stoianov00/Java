package pr_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeakStudents {
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
                .filter(s -> {
                    List<Integer> weakGrades;
                    weakGrades = s.getGrades().stream().filter(g -> g <= 3).collect(Collectors.toList());

                    return weakGrades.size() >= 2;
                })
                .forEach(System.out::println);

    }
}
