package pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] pizzaInput = reader.readLine().split("\\s+");
            String pizzaName = pizzaInput[1];
            int countOfToppings = Integer.parseInt(pizzaInput[2]);

            Pizza pizza = new Pizza(pizzaName, countOfToppings);

            String[] doughInput = reader.readLine().split("\\s+");

            String flourType = doughInput[1];
            String backingTechnique = doughInput[2];
            double doughWeight = Double.parseDouble(doughInput[3]);

            Dough dough = new Dough(flourType, backingTechnique, doughWeight);
            pizza.setDough(dough);

            while (countOfToppings-- > 0) {
                String[] toppingInput = reader.readLine().split("\\s+");

                String toppingType = toppingInput[1];
                double toppingWeight = Double.parseDouble(toppingInput[2]);

                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            }

            System.out.println(pizza);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
