package gr.upatras.ceid.backend.models;

import lombok.Data;

@Data
public class Round {
    private Long id;
    private Integer number;
    private Integer dice;
    private Long playerId;
}
