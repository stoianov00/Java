package ferrari;

import ferrari.contracts.Car;

public class Ferrari implements Car {
    private String name;

    public Ferrari(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("488-Spider/")
                .append("Brakes!/")
                .append("Zadu6avam sA!/")
                .append(this.name);

        return sb.toString();
    }
}
