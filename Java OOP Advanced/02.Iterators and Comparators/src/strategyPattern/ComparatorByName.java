package strategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int compare = person1.getName().length() - person2.getName().length();

        if (compare != 0) {
            return compare;
        }

        return String.valueOf(person1.getName().charAt(0)).compareToIgnoreCase(String.valueOf(person2.getName().charAt(0)));
    }
}
