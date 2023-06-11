package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.CardType;
import lombok.Data;

@Data
public class DevelopmentCard {
    private final String id;
    private final CardType type;
    private Integer roundAcquired;
}
