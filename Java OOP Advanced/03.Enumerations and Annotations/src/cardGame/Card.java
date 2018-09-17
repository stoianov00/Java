package cardGame;

import cardGame.enums.RankPower;
import cardGame.enums.SuitPower;

public class Card implements Comparable<Card> {
    private RankPower rankPower;
    private SuitPower suitPower;

    public Card(RankPower rankPower, SuitPower suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public RankPower getRankPower() {
        return this.rankPower;
    }

    public SuitPower getSuitPower() {
        return this.suitPower;
    }

    private int calculateAllPower() {
        return this.rankPower.getRankPower() + this.suitPower.getSuitPower();
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.calculateAllPower(), other.calculateAllPower());
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rankPower, this.suitPower);
    }
}
