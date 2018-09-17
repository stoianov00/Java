package cardPower;

import cardPower.enums.RankPower;
import cardPower.enums.SuitPower;

public class Card implements Comparable<Card> {
    private RankPower rankPower;
    private SuitPower suitPower;

    public Card(String rankPower, String suitPower) {
        this.rankPower = Enum.valueOf(RankPower.class, rankPower);
        this.suitPower = Enum.valueOf(SuitPower.class, suitPower);
    }

    private int calculateAllPower() {
        return this.rankPower.getRankPower() + this.suitPower.getSuitPower();
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(other.calculateAllPower(), this.calculateAllPower());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rankPower, this.suitPower, this.calculateAllPower());
    }
}
