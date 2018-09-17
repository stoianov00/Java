package deckOfCards;

import deckOfCards.enums.RankPower;
import deckOfCards.enums.SuitPower;

public class Card {
    private RankPower rankPower;
    private SuitPower suitPower;

    public Card(RankPower rankPower, SuitPower suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rankPower, this.suitPower);
    }
}
