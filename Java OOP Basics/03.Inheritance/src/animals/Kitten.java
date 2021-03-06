package animals;

public class Kitten extends Cat {
    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected void setName(String name) {
        super.setName(name);
    }

    @Override
    protected void setAge(int age) {
        super.setAge(age);
    }

    @Override
    protected void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    protected String produceSound() {
        return "Miau";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        System.out.println(this.getClass().getSimpleName());

        sb.append(this.getName())
                .append(" ")
                .append(this.getAge())
                .append(" ")
                .append(this.getGender())
                .append(System.lineSeparator())
                .append(this.produceSound());

        return sb.toString();
    }
}
