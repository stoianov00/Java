package pizza_calories;

import java.util.List;
import java.util.Map;

public class Dough {
    private static final List<String> FLOUR_TYPES = List.of("White", "Wholegrain");
    private static final List<String> BAKING_TECHNIQUE = List.of("Crispy", "Chewy", "Homemade");

    private static final Map<String, Double> DOUGH_MODIFIERS = Map.of(
            "White", 1.5,
            "Wholegrain", 1.0,
            "Crispy", 0.9,
            "Chewy", 1.1,
            "Homemade", 1.0);

    private static final String INVALID_TYPE_DOUGH_EXCEPTION = "Invalid type of dough.";
    private static final String INVALID_WEIGHT_EXCEPTION = "Dough weight should be in the range [1..200].";

    private String flourType;
    private String backingTechnique;
    private double weight;

    public Dough(String flourType, String backingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBackingTechnique(backingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_TYPES.contains(flourType)) {
            throw new IllegalArgumentException(INVALID_TYPE_DOUGH_EXCEPTION);
        }

        this.flourType = flourType;
    }

    private void setBackingTechnique(String backingTechnique) {
        if (!BAKING_TECHNIQUE.contains(backingTechnique)) {
            throw new IllegalArgumentException(INVALID_TYPE_DOUGH_EXCEPTION);
        }

        this.backingTechnique = backingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(INVALID_WEIGHT_EXCEPTION);
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        return Constants.BASE_CALORIES * this.weight * DOUGH_MODIFIERS.get(this.flourType) * DOUGH_MODIFIERS.get(this.backingTechnique);
    }

}
