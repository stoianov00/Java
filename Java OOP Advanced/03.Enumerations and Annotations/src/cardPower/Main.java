package cardPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Card> cardList = new ArrayList<>();
        Card card;

        int counter = 0;
        int numberOfLines = 2;
        while (counter < numberOfLines) {
            String rankPower = reader.readLine();
            String suitPower = reader.readLine();

            card = new Card(rankPower, suitPower);
            cardList.add(card);

            counter++;
        }

        Collections.sort(cardList);

        int lowestPower = 1;
        cardList.remove(lowestPower);

        cardList.forEach(System.out::println);
    }
}
