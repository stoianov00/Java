package strategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> people = new TreeSet<>(new ComparatorByName());
        Set<Person> people2 = new TreeSet<>(new ComparatorByAge());

        int lineCount = Integer.parseInt(reader.readLine());
        while (lineCount-- > 0) {
            String[] inputTokens = reader.readLine().split("\\s+");

            String name = inputTokens[0];
            int age = Integer.parseInt(inputTokens[1]);

            fillCollection(people, name, age);
            fillCollection(people2, name, age);
        }

        printResult(people);
        printResult(people2);
    }

    private static void printResult(Set<Person> people) {
        people.forEach(System.out::println);
    }

    private static void fillCollection(Set<Person> people, String name, int age) {
        people.add(new Person(name, age));
    }

}
