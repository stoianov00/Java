package car_salesman;

public class Car {
    private String carModel;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String carModel, Engine engine) {
        this.carModel = carModel;
        this.engine = engine;
    }

    public Car(String carModel, Engine engine, int weight) {
        this(carModel, engine);
        this.weight = weight;
    }

    public Car(String carModel, Engine engine, String color) {
        this(carModel, engine);
        this.color = color;
    }

    public Car(String carModel, Engine engine, int weight, String color) {
        this(carModel, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder car = new StringBuilder();

        car.append(String.format("%s: ", this.carModel))
                .append(System.lineSeparator())
                .append(this.engine.toString())
                .append(System.lineSeparator())
                .append(String.format("Weight: %s", this.weight == 0 ? "n/a" : this.weight))
                .append(System.lineSeparator());

        if (this.color == null) {
            car.append("Color: n/a");
        } else {
            car.append(String.format("Color: %s", this.color));
        }

        return car.toString();
    }

}
