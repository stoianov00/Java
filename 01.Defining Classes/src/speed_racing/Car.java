package speed_racing;

public class Car {
    private String carModel;
    private double fuelAmount;
    private double fuelPerKm;
    private double distanceTravelled;

    public Car(String carModel, double fuelAmount, double fuelPerKm) {
        this.carModel = carModel;
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
        this.distanceTravelled = 0;
    }

    public void drive(double distance) {
        if (this.fuelAmount < distance * fuelPerKm) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuelAmount -= distance * this.fuelPerKm;
            this.distanceTravelled += distance;
        }
    }

    public String getCarModel() {
        return this.carModel;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getDistanceTravelled() {
        return this.distanceTravelled;
    }
}
