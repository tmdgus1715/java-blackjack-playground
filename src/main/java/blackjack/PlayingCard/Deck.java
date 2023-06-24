package blackjack.PlayingCard;

import java.util.List;

public class Deck {
    private final List<PlayingCard> cards;

    private Deck(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public static Deck create(List<PlayingCard> cards) {
        return new Deck(cards);
    }

    public void addNewCard(PlayingCard newCard) {
        cards.add(newCard);
    }

    public int size() {
        return cards.size();
    }

    public int getScore() {
        return cards.stream().mapToInt(PlayingCard::getScore).sum();
    }

    public List<PlayingCard> getCards() {
        return List.copyOf(cards);
    }
}
