package models.engines;

public class JetEngine extends BaseBoatEngine {
    private static final int MULTIPLIER = 5;

    public JetEngine(String model, int horsepower, int displacement) {
        super(model, horsepower, displacement);
    }

    @Override
    public int getCachedOutput() {
        return (this.getHorsepower() * MULTIPLIER) + this.getDisplacement();
    }
}
