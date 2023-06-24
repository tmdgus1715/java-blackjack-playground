package blackjack.player;

import blackjack.PlayingCard.Deck;
import blackjack.PlayingCard.PlayingCard;
import blackjack.PlayingCard.PlayingCardGenerator;
import blackjack.PlayingCard.RandomTrumpPlayingCardGenerator;

import java.util.List;
import java.util.Objects;

public abstract class AbstractPlayer implements Player {

    public static final int BLACKJACK_DEFAULT_CARDS_NUMBER = 2;

    protected final String name;
    protected int bettingMoney;
    protected Deck deck;
    protected Role role;
    private static final PlayingCardGenerator generator = new RandomTrumpPlayingCardGenerator();

    protected AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Deck getDeck() {
        return Deck.create(deck.getCards());
    }

    @Override
    public int getBettingMoney() {
        return this.bettingMoney;
    }

    @Override
    public void initDraw() {
        List<PlayingCard> cards = generator.cardsGenerate(BLACKJACK_DEFAULT_CARDS_NUMBER);
        this.deck = Deck.create(cards);
    }

    @Override
    public void draw() {
        deck.addNewCard(generator.generate());
    }

    abstract public void betMoney(int money);

    abstract public boolean isBetable();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlayer that = (AbstractPlayer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
