import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsByFirstLastName {
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
                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getLastName()))
                .forEach(System.out::println);

    }
}
