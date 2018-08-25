package animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstants.EXCEPTION);
        }

        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    protected void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException(ExceptionConstants.EXCEPTION);
        }

        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    protected void setGender(String gender) {
        if (gender.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstants.EXCEPTION);
        }

        this.gender = gender;
    }

    protected abstract String produceSound();

    @Override
    public abstract String toString();

}
