package p_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {

            String[] input = line.split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            int group = Integer.parseInt(input[2]);

            String fullName = firstName + " " + lastName;

            Person person = new Person(fullName, group);
            people.add(person);

            line = reader.readLine();
        }

        Map<Integer, List<Person>> peopleByGroup = people.stream()
                .collect(Collectors.groupingBy(Person::getGroup));

        peopleByGroup.forEach((key, value) ->
                System.out.println(String.format("%d - %s", key,
                        value.stream()
                                .map(Person::getName)
                                .collect(Collectors.joining(", ")))));

    }
}
