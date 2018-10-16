package models;

import contracts.Boat;
import contracts.Race;
import exceptions.DuplicateModelException;
import utility.Constants;
import utility.Validator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceImpl implements Race {
    private int distance;
    private int windSpeed;
    private int oceanCurrentSpeed;
    private boolean allowsMotorBoats;
    private Map<String, Boat> registeredBoats;

    public RaceImpl(int distance, int windSpeed, int oceanCurrentSpeed, boolean allowsMotorBoats) {
        this.setDistance(distance);
        this.windSpeed = windSpeed;
        this.oceanCurrentSpeed = oceanCurrentSpeed;
        this.allowsMotorBoats = allowsMotorBoats;
        this.registeredBoats = new LinkedHashMap<>();
    }

    private void setDistance(int distance) {
        Validator.validatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public int getOceanCurrentSpeed() {
        return this.oceanCurrentSpeed;
    }

    @Override
    public boolean getAllowsMotorboats() {
        return this.allowsMotorBoats;
    }

    @Override
    public void addParticipant(Boat boat) throws DuplicateModelException {
        if (this.registeredBoats.containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DUPLICATE_MODEL_MESSAGE);
        }

        this.registeredBoats.put(boat.getModel(), boat);
    }

    @Override
    public List<Boat> getParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}