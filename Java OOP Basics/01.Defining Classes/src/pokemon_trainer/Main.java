package pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static List<Trainer> trainers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        trainers = new ArrayList<>();

        String line = reader.readLine();
        while (!"Tournament".equals(line)) {
            String[] input = line.split("\\s+");

            String trainerName = input[0];
            String pokemonName = input[1];
            String pokemonElement = input[2];
            int pokemonHealth = Integer.parseInt(input[3]);

            Trainer trainer;
            if ((trainer = containTrainer(trainerName)) == null) {
                trainer = new Trainer(trainerName, pokemonName, pokemonElement, pokemonHealth);
                trainers.add(trainer);
            } else {
                trainer.addPokemon(pokemonName, pokemonElement, pokemonHealth);
            }

            line = reader.readLine();
        }


        String elementInput = reader.readLine();
        int count = 0;
        while (!"End".equals(elementInput)) {
            for (Trainer currentTrainer : trainers) {
                for (Pokemon pokemon : currentTrainer.getPokemons()) {
                    if (pokemon.getElement().equals(elementInput) && pokemon.getHealth() > 0) {
                        count++;
                    }
                }

                if (count > 0) {
                    int incrementBadges = 1;
                    currentTrainer.setNumberOfBadges(currentTrainer.getNumberOfBadges() + incrementBadges);
                } else {
                    int damage = 10;
                    for (Pokemon pokemon : currentTrainer.getPokemons()) {
                        pokemon.setHealth(pokemon.getHealth() - damage);
                    }
                }

                count = 0;
            }

            elementInput = reader.readLine();
        }

        int pokemonsCount = 0;
        trainers = trainers.stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges)
                        .reversed())
                .collect(Collectors.toList());

        for (Trainer currentTrainer : trainers) {
            for (Pokemon pokemon : currentTrainer.getPokemons()) {
                if (pokemon.getHealth() > 0) {
                    pokemonsCount++;
                }
            }

            System.out.printf("%s %d %d%n", currentTrainer.getName(), currentTrainer.getNumberOfBadges(), pokemonsCount);
            pokemonsCount = 0;
        }

    }

    private static Trainer containTrainer(String name) {
        for (Trainer trainer : trainers) {
            if (trainer.getName().equals(name)) {
                return trainer;
            }
        }

        return null;
    }
}
