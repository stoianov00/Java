package pokemon_trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name, String pokemonName, String pokemonElement, int pokemonHealth) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
        addPokemon(pokemonName, pokemonElement, pokemonHealth);
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addPokemon(String name, String element, int health) {
        Pokemon pokemon = new Pokemon(name, element, health);
        pokemons.add(pokemon);
    }
}
