package raw_data;

public class Car {
    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    public Car(String carModel, Engine engine, Cargo cargo, Tire tire) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public Tire getTire() {
        return this.tire;
    }

    public Engine getEngine() {
        return this.engine;
    }
}
