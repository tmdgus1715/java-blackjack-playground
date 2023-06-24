package blackjack;

import blackjack.player.PlayerGenerator;
import blackjack.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("플레이어의 이름을 입력하면, 전체 플레이어 수는 입력한 이름의 개수 + 1(딜러)이면 참")
    void generate() {
        List<String> names = List.of(
                "user1",
                "user2",
                "user3"
        );

        Players players = PlayerGenerator.generate(names);

        assertThat(players.getName(0)).isEqualTo("딜러");
        assertThat(players.getName(1)).isEqualTo("user1");
        assertThat(players.getName(2)).isEqualTo("user2");
        assertThat(players.getName(3)).isEqualTo("user3");
        assertThat(players.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("플레이어들은 베팅을 했을 때, 각 플레이어의 베팅금액이 입력한 값이 나오고, 딜러는 0원이 나오면 참")
    void betting() {
        List<String> names = List.of(
                "user1",
                "user2",
                "user3"
        );
        List<Integer> bettingMoneys = List.of(
                10000,
                20000,
                40000
        );

        Players players = PlayerGenerator.generate(names);
        players.bet(bettingMoneys);

        assertThat(players.getBettingMoney(0)).isEqualTo(0);
        assertThat(players.getBettingMoney(1)).isEqualTo(10000);
        assertThat(players.getBettingMoney(2)).isEqualTo(20000);
        assertThat(players.getBettingMoney(3)).isEqualTo(40000);
    }

    @Test
    @DisplayName("플레이어를 생성하고 초기 카드를 뽑으면 모든 플레이어는 2장씩 카드를 가짐")
    void initDraw() {
        List<String> names = List.of(
                "user1",
                "user2",
                "user3"
        );
        List<Integer> bettingMoneys = List.of(
                10000,
                20000,
                40000
        );

        Players players = PlayerGenerator.generate(names);
        players.bet(bettingMoneys);
        players.initDraw();

        assertThat(players.getDeck(0).size()).isEqualTo(2);
        assertThat(players.getDeck(1).size()).isEqualTo(2);
        assertThat(players.getDeck(2).size()).isEqualTo(2);
        assertThat(players.getDeck(3).size()).isEqualTo(2);
    }
}
