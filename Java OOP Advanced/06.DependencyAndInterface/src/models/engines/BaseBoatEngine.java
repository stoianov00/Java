package models.engines;

import contracts.BoatEngine;
import utility.Constants;
import utility.Validator;

public abstract class BaseBoatEngine implements BoatEngine {
    private String model;
    private int cachedOutput;
    private int horsepower;
    private int displacement;

    protected BaseBoatEngine(String model, int horsepower, int displacement) {
        this.setModel(model);
        this.setHorsepower(horsepower);
        this.setDisplacement(displacement);
    }

    private void setHorsepower(int horsepower) {
        Validator.validatePropertyValue(horsepower, "Horsepower");
        this.horsepower = horsepower;
    }

    private void setModel(String model) {
        Validator.validateModelLength(model, Constants.MIN_BOAT_ENGINE_MODEL_LENGTH);
        this.model = model;
    }

    private void setDisplacement(int displacement) {
        Validator.validatePropertyValue(displacement, "Displacement");
        this.displacement = displacement;
    }

    protected int getHorsepower() {
        return this.horsepower;
    }

    protected int getDisplacement() {
        return displacement;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getCachedOutput() {
        return this.cachedOutput;
    }
}
