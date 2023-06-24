package blackjack.player;

import blackjack.player.AbstractPlayer;

public class Dealer extends AbstractPlayer {
    private Dealer(String name) {
        super(name);
        super.role = Role.Dealer;
    }

    public static Dealer getInstance(String name) {
        return new Dealer(name);
    }

    @Override
    public void betMoney(int money) {
        return;
    }

    @Override
    public boolean isBetable() {
        return false;
    }
}
