package deckOfCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if ("Card Deck".equals(reader.readLine())) {
            Deck deck = new Deck();
            deck.forEach(System.out::println);
        }
    }

}
