package blackjack.player;

import blackjack.PlayingCard.Deck;

public interface Player {
    String getName();
    Deck getDeck();
    int getBettingMoney();
    void betMoney(int money);
    boolean isBetable();
    void initDraw();
    void draw();

}
