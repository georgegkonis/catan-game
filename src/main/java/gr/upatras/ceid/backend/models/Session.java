package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.exceptions.notfound.PlayerNotFoundException;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "sessions")
public class Session {

    private String id;
    private Board board;
    private Bank bank;
    private Round round;
    private Boolean active;
    private Integer numberOfPlayers;
    private List<Player> players;

    public Player getPlayer(String playerId) {
        return players.stream()
                .filter(player -> Objects.equals(player.getId(), playerId))
                .findFirst()
                .orElseThrow(PlayerNotFoundException::new);
    }
}
