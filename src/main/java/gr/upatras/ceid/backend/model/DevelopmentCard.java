package gr.upatras.ceid.backend.model;

import gr.upatras.ceid.backend.enums.Type;
import lombok.Data;

@Data
public class DevelopmentCard {
    private final String id;
    private final Type type;
    private Integer roundAcquired;
}
