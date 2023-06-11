package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.Effect;
import lombok.Data;

@Data
public class DevelopmentCard {
    private final String id;
    private final Effect effect;
    private String playerId;

    public DevelopmentCard(String id, Effect effect) {
        this.id = id;
        this.effect = effect;
    }
}
