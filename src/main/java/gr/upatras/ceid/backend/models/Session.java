package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.models.colony.Bank;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "sessions")
public class Session {
    @Id
    private String id;
    private Board board;
    private Bank bank;
    private List<Player> players;

    public Session() {
        this.board = new Board();
        this.bank = new Bank();
        this.players = new ArrayList<>();
    }
}
