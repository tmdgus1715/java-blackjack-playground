package blackjack.PlayingCard;

import java.util.List;

public interface PlayingCardGenerator {

    PlayingCard generate();

    List<PlayingCard> cardsGenerate(int amount);
}
