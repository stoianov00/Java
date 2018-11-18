package pr_3;

public class Student {
    private String firstName;
    private String lastName;
    private int age;

    Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.firstName, this.lastName, this.age);
    }
}
