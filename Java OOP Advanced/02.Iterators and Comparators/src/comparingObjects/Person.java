package comparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        int comparatorByName = this.name.compareTo(o.name);
        if (comparatorByName != 0) {
            return comparatorByName;
        }

        int comparatorByAge = this.age - o.age;
        if (comparatorByAge != 0) {
            return comparatorByAge;
        }

        return this.town.compareTo(o.town);
    }
}
