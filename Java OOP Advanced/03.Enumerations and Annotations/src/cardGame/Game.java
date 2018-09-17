package cardGame;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player player1, Player player2) {
        this.firstPlayer = player1;
        this.secondPlayer = player2;
    }

    public Player getWinner() {
        return this.firstPlayer.getPowerfulCard().compareTo(this.secondPlayer.getPowerfulCard()) > 0 ? this.firstPlayer : this.secondPlayer;
    }
}
