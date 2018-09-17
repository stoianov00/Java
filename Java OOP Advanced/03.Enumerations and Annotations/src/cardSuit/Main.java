package cardSuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Suit[] suits = Suit.values();

        if ("Card Suits".equals(reader.readLine())) {
            System.out.println("Card Suits:");
            for (Suit suit : suits) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
            }
        }

    }
}
