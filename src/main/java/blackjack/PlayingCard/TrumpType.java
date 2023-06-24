package blackjack.PlayingCard;

public enum TrumpType {
    SPADE("S"),
    HEART("H"),
    DIAMOND("D"),
    CLUB("C");

    private final String type;

    TrumpType(String value) {
        this.type = value;
    }
}
