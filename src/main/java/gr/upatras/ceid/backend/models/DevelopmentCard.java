package gr.upatras.ceid.backend.models;

import gr.upatras.ceid.backend.enums.Card;
import lombok.Data;

@Data
public class DevelopmentCard {
    private Long id;
    private Card type;
    private String playerId;
}
