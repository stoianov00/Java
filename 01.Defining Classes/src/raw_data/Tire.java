package raw_data;

public class Tire {
    private double tire1Pressure;
    private int tire1Age;
    private double tire2Pressure;
    private int tire2Age;

    public Tire(double tire1Pressure, int tire1Age, double tire2Pressure, int tire2Age) {
        this.tire1Pressure = tire1Pressure;
        this.tire1Age = tire1Age;
        this.tire2Pressure = tire2Pressure;
        this.tire2Age = tire2Age;
    }

    public double getTire1Pressure() {
        return this.tire1Pressure;
    }

    public double getTire2Pressure() {
        return this.tire2Pressure;
    }
}
