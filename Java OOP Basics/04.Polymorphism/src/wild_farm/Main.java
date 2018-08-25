package wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        while (!"End".equals(command)) {
            String[] animalArgs = command.split("\\s+");
            Animal animal = AnimalFactory.createAnimal(animalArgs);

            String[] foodArgs = reader.readLine().split("\\s+");
            Food food = FoodFactory.createFood(foodArgs);

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println(animal);

            command = reader.readLine();
        }
    }
}
