package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.RoundPhase;
import lombok.Data;

@Data
public class Round {
    private Integer number;
    private RoundPhase phase;
    private Integer dice;
    private String playerId;
}
