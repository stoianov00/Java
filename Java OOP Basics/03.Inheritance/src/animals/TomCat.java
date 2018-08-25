package animals;

public class TomCat extends Cat {
    public TomCat(String name, int age, String gender) {
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
        return "Give me one million b***h";
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
