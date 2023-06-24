package blackjack.player;

public class NormalPlayer extends AbstractPlayer {
    private NormalPlayer(String name) {
        super(name);
        super.role = Role.NormalPlayer;
    }

    public static NormalPlayer getInstance(String name) {
        return new NormalPlayer(name);
    }

    @Override
    public void betMoney(int money) {
        super.bettingMoney += money;
    }

    @Override
    public boolean isBetable() {
        return true;
    }
}
