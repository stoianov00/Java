package cardGame;

import cardGame.enums.RankPower;
import cardGame.enums.SuitPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player firstPlayer = new Player(reader.readLine());
        Player secondPlayer = new Player(reader.readLine());

        Game game = new Game(firstPlayer, secondPlayer);
        Deck deck = new Deck();

        while (!firstPlayer.isHandFull() || !secondPlayer.isHandFull()) {
            String[] inputTokens = reader.readLine().split("\\sof\\s");

            Card card;
            try {
                RankPower rankType = RankPower.valueOf(inputTokens[0]);
                SuitPower suitType = SuitPower.valueOf(inputTokens[1]);

                card = new Card(rankType, suitType);
            } catch (IllegalArgumentException ex) {
                System.out.println(Constants.INVALID_CARD_NAME_EXCEPTION);
                continue;
            }

            if (!deck.contains(card)) {
                System.out.println(Constants.CARD_NOT_IN_DECK_EXCEPTION);
                continue;
            }

            deck.remove(card);

            if (firstPlayer.getHandSize() < 5) {
                firstPlayer.add(card);
            } else if (secondPlayer.getHandSize() < 5) {
                secondPlayer.add(card);
            }

        }

        Player winner = game.getWinner();
        System.out.printf("%s wins with %s.", winner.getName(), winner.getPowerfulCard());

    }
}
