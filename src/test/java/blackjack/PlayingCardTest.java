package blackjack;

import blackjack.PlayingCard.Deck;
import blackjack.PlayingCard.PlayingCard;
import blackjack.PlayingCard.PlayingCardGenerator;
import blackjack.PlayingCard.RandomTrumpPlayingCardGenerator;
import blackjack.PlayingCard.TrumpNumber;
import blackjack.PlayingCard.TrumpPlayingCard;
import blackjack.PlayingCard.TrumpType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayingCardTest {

    PlayingCardGenerator randomTrumpPlayingCardGenerator = new RandomTrumpPlayingCardGenerator();

    @Test
    @DisplayName("덱을 생성했을 때, 카드2개가 있으면 참")
    void generateDeck() {
        List<PlayingCard> playingCards = randomTrumpPlayingCardGenerator.cardsGenerate(2);
        Deck deck = Deck.create(playingCards);

        assertThat(deck.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("덱에 카드를 추가했을 때, 추가한 횟수+2개의 카드가 있으면 참")
    void drawNewCard() {
        List<PlayingCard> playingCards = randomTrumpPlayingCardGenerator.cardsGenerate(2);
        Deck deck = Deck.create(playingCards);

        deck.addNewCard(randomTrumpPlayingCardGenerator.generate());
        deck.addNewCard(randomTrumpPlayingCardGenerator.generate());

        assertThat(deck.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("덱에 포함된 카드들의 점수의 합을 올바르게 구하면 참")
    void getScore() {
        List<PlayingCard> playingCards = List.of(
                TrumpPlayingCard.getInstance(TrumpType.DIAMOND, TrumpNumber.FOUR),
                TrumpPlayingCard.getInstance(TrumpType.DIAMOND, TrumpNumber.FIVE)
        );
        Deck deck = Deck.create(playingCards);

        assertThat(deck.getScore()).isEqualTo(9);
    }

}
