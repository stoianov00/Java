package deckOfCards;

import deckOfCards.enums.RankPower;
import deckOfCards.enums.SuitPower;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Deck implements Iterable<Card> {
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

    @Override
    public void forEach(Consumer<? super Card> action) {
        for (Card card : this) {
            action.accept(card);
        }
    }

    @Override
    public Iterator<Card> iterator() {
        return new CardIterator();
    }

    private final class CardIterator implements Iterator<Card> {
        private int cursor;

        private CardIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return this.cursor < cardList.size();
        }

        @Override
        public Card next() {
            return cardList.get(cursor++);
        }
    }
}
