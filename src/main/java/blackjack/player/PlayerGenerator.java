package blackjack.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PlayerGenerator {

    private static final Map<String, Function<String, Player>> playerInventory;

    static {
        playerInventory = new HashMap<>();
        playerInventory.put("Dealer", Dealer::getInstance);
        playerInventory.put("NormalPlayer", NormalPlayer::getInstance);
    }

    private PlayerGenerator() {
    }

    public static Players generate(List<String> names) {
        List<Player> newPlayers = new ArrayList<>();

        newPlayers.add(playerInventory.get("Dealer").apply("딜러"));
        names.forEach(i -> newPlayers.add(playerInventory.get("NormalPlayer").apply(i)));

        return Players.generate(newPlayers);
    }

}
