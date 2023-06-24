package blackjack.player;

import blackjack.PlayingCard.Deck;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players generate(List<Player> newPlayers) {
        return new Players(newPlayers);
    }

    public String getName(int i) {
        return players.get(i).getName();
    }

    /*public int getBettingMoney(String name) {
        List<Player> collect = players.stream().filter(i -> i.equals(name)).collect(Collectors.toList());

        if (collect.size() != 1) {
            throw new RuntimeException("중복된 이름이 존재합니다.");
        }

        return collect.get(0).getBettingMoney();
    }*/

    public int getBettingMoney(int i) {
        return players.get(i).getBettingMoney();
    }

    public void bet(List<Integer> bettingMoneys) {
        List<Player> collect = players.stream().filter(Player::isBetable).collect(Collectors.toList());
        IntStream.range(0, bettingMoneys.size()).forEach(i -> collect.get(i).betMoney(bettingMoneys.get(i)));
    }

    public int size() {
        return players.size();
    }

    public Deck getDeck(int i) {
       return players.get(i).getDeck();
    }

    public void initDraw() {
        players.forEach(player -> player.initDraw());
    }
}
