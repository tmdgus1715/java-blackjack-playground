package blackjack.PlayingCard;

public class TrumpPlayingCard implements PlayingCard {
    private final TrumpType type;
    private final TrumpNumber number;

    private TrumpPlayingCard(TrumpType type, TrumpNumber number) {
        this.type = type;
        this.number = number;
    }

    public static TrumpPlayingCard getInstance(TrumpType type, TrumpNumber number) {
        return new TrumpPlayingCard(type, number);
    }


    @Override
    public int getScore() {
        return number.getScore();
    }
}
