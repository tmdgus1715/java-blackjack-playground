package blackjack.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTrumpPlayingCardGenerator implements PlayingCardGenerator {

    private final Random random;
    private final TrumpNumber[] values;
    private final TrumpType[] types;

    public RandomTrumpPlayingCardGenerator() {
        this.random = new Random();
        this.values = TrumpNumber.values();
        this.types = TrumpType.values();
    }

    @Override
    public PlayingCard generate() {
        int typeIdx = random.nextInt(types.length);
        int valueIdx = random.nextInt(values.length);

        return TrumpPlayingCard.getInstance(types[typeIdx], values[valueIdx]);
    }

    @Override
    public List<PlayingCard> cardsGenerate(int amount) {
        List<PlayingCard> cards = new ArrayList<>();

        for (int i = 0; i < amount; ++i) {
            cards.add(generate());
        }

        return cards;
    }
}
