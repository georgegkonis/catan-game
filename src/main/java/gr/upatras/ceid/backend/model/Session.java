package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.SessionStatus;
import gr.upatras.ceid.backend.exception.notfound.PlayerNotFoundException;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@Document(collection = "sessions")
public class Session {

    private final String id;
    private final Integer slots;
    private Board board;
    private Bank bank;
    private Round round;
    private SessionStatus status;
    private List<Player> players;

    public Player getPlayer(String playerId) {
        return players.stream()
                .filter(player -> Objects.equals(player.getId(), playerId))
                .findFirst()
                .orElseThrow(PlayerNotFoundException::new);
    }
}
