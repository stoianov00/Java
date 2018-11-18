package pr_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentsEnrolled {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> gradesFacultyNumber = new LinkedHashMap<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {

            String[] input = line.split("\\s+", 3);
            String facultyNumber = input[0];
            List<String> grades = Arrays.stream(input).skip(1).collect(Collectors.toList());

            gradesFacultyNumber.putIfAbsent(facultyNumber, grades);
            line = reader.readLine();
        }

        gradesFacultyNumber.entrySet()
                .stream()
                .filter(g -> g.getKey().endsWith("14") || g.getKey().endsWith("15"))
                .forEach(g -> System.out.printf("%s%n", String.join(" ", g.getValue())));

    }
}
