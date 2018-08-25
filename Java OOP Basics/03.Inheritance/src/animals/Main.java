package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String animalType = reader.readLine();

        while (!"Beast!".equals(animalType)) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];

            try {
                checkAnimal(animals, animalType, name, age, gender);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            animalType = reader.readLine();
            animals.forEach(System.out::println);
        }
    }

    private static void checkAnimal(List<Animal> animals, String animalType, String name, int age, String gender) {
        switch (animalType) {
            case "Cat":
                Cat cat = new Cat(name, age, gender);
                animals.add(cat);
                break;
            case "Dog":
                Dog dog = new Dog(name, age, gender);
                animals.add(dog);
                break;
            case "Frog":
                Frog frog = new Frog(name, age, gender);
                animals.add(frog);
                break;
            case "Kitten":
                Kitten kitten = new Kitten(name, age, gender);
                animals.add(kitten);
                break;
            case "Tomcat":
                TomCat tomCat = new TomCat(name, age, gender);
                animals.add(tomCat);
                break;
        }
    }

}
