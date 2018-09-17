package cardGame;

import cardGame.enums.RankPower;
import cardGame.enums.SuitPower;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cardList;

    public Deck() {
        this.cardList = new ArrayList<>();
        this.seedDeck();
    }

    private void seedDeck() {
        for (SuitPower suitPower : SuitPower.values()) {
            for (RankPower rankPower : RankPower.values()) {
                Card card = new Card(rankPower, suitPower);

                this.cardList.add(card);
            }
        }
    }

    public boolean contains(Card card) {
        return this.cardList.stream()
                .anyMatch(innerCard -> innerCard.getRankPower().equals(card.getRankPower())
                        && innerCard.getSuitPower().equals(card.getSuitPower()));
    }

    public void remove(Card card) {
        this.cardList.removeIf(innerCard -> innerCard.getRankPower().equals(card.getRankPower())
                && innerCard.getSuitPower().equals(card.getSuitPower()));
    }

}
