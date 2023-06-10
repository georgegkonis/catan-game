package gr.upatras.ceid.backend.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
}
