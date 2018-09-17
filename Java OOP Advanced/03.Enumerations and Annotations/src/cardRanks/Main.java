package cardRanks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if ("Card Ranks".equals(reader.readLine())) {
            Rank[] ranks = Rank.values();

            System.out.println("Card Ranks:");
            for (Rank rank : ranks) {
                System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank.name());
            }
        }

    }
}
