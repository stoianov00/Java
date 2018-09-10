package comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        String line = reader.readLine();
        while (!"END".equals(line)) {
            String[] inputTokens = line.split("\\s+");

            String name = inputTokens[0];
            int age = Integer.parseInt(inputTokens[1]);
            String address = inputTokens[2];

            people.add(new Person(name, age, address));

            line = reader.readLine();
        }

        int n = Integer.parseInt(reader.readLine());

        printStatistics(people, n);
    }

    private static void printStatistics(List<Person> people, int n) {
        if (n < 0 || n >= people.size()) {
            System.out.println("No matches");
            return;
        }

        Person person = people.get(n);

        long countOfEqualsPeople = people.stream()
                .filter(person1 -> person1.compareTo(person) == 0)
                .count();

        if (countOfEqualsPeople == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", countOfEqualsPeople, people.size() - countOfEqualsPeople, people.size());
        }

    }

}
